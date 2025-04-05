package algorithms;

import java.util.*;

public class HuffmanEncoder {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanEncoder(String feeder) throws Exception{
        HashMap<Character, Integer> fmap = new HashMap<>();

        for(int i = 0; i < feeder.length(); i++){
            char character = feeder.charAt(i);
            if(fmap.containsKey(character)){
                int originalValue = fmap.get(character);
                originalValue += 1;
                fmap.put(character, originalValue);
            }else{
                fmap.put(character, 1);
            }
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Set<Map.Entry<Character, Integer>> entrySet = fmap.entrySet();

        for(Map.Entry<Character,Integer> entry: entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        while (minHeap.size() != 1) {
            Node first = minHeap.remove();
            Node second = minHeap.remove();
            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.add(newNode);
        }

        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft, "");
    }



    public void initEncoderDecoder(Node node, String output){
        if(node == null){
            return;
        }

        if(node.left == null & node.right == null){
            this.encoder.put(node.data, output);
            this.decoder.put(output, node.data);
        }
        initEncoderDecoder(node.left, output + "0");
        initEncoderDecoder(node.right, output + "1");
    }

    public StringBuilder encode(String source){
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < source.length(); i++){
            ans.append(this.encoder.get(source.charAt(i)));
        }

        return ans;
    }


    public StringBuilder decode(String codedString){
        StringBuilder key = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < codedString.length(); i++){
            key.append(codedString.charAt(i));
            if(decoder.containsKey(key)){
                ans.append(decoder.get(key));
                key = new StringBuilder();
            }
        }

        return key;
    }



    public static void main(String[] args) throws Exception{
        String str = "abbccdda";
        HuffmanEncoder huffmanEncoder = new HuffmanEncoder(str);
        StringBuilder codedString = huffmanEncoder.encode(str);
        System.out.println(codedString);
        StringBuilder decodedString = huffmanEncoder.decode(str);
        System.out.println(decodedString);
    }
}


