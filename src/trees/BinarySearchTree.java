package trees;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){

    };

    public int height(Node node){
        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void display(){
        display(this.root, "Root Node: ");
    }

    public void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.println(details + node.val);

        display(node.left, "Left child of " + node.getValue() + " : ");
        display(node.right, "Right child of " + node.getValue() + " : ");
    }

    public void insert(int val){
        this.root = insert(val, this.root);
    }

    private Node insert(int val, Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }

        if(val < node.val){
            node.left = insert(val, node.left);
        }

        if(val > node.val){
            node.right = insert(val, node.right);
        }

        node.height = Math.max(this.height(node.left), this.height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;

        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    private static class Node{
        private final int val;
        private int height;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }

        public int getValue(){
            return this.val;
        }
    }

    public static void main(String[] args){
        BinarySearchTree treeSearch = new BinarySearchTree();
        int[] nums = {5, 15, 12, 3 ,4 , 1, 6};
        int[] sortedNums = {1,2,3,4,5,6,7,8};
        treeSearch.populateSorted(nums);
        treeSearch.display();
    }
}
