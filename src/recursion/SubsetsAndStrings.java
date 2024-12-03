package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsAndStrings {
    public static void main(String[] args){
        System.out.println(subseq2("", "abc", new ArrayList<>()));
    }

    static void skip(String p, String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p + ch, up.substring(1));
        }
    }

    static String skip2(String str){
        if(str.isEmpty()) return "";

        char ch = str.charAt(0);

        if(ch == 'a'){
            return skip2(str.substring(1));
        }else {
            return ch + skip2(str.substring(1));
        }
    }

    static String skipString(String str){
        if(str.isEmpty()) return "";

        String wordToSkip = "lemon";
        char ch = str.charAt(0);

        if(str.startsWith(wordToSkip)){
            return skipString(str.substring(wordToSkip.length()));
        }else{
            return ch + skipString(str.substring(1));
        }
    }

    static String skipLemButNotLemon(String str){
        if(str.isEmpty()) return "";

        String wordToSkip = "lem";
        char ch = str.charAt(0);

        if(str.startsWith(wordToSkip) && !str.startsWith("lemon")){
            return skipLemButNotLemon(str.substring(wordToSkip.length()));
        }else{
            return ch + skipLemButNotLemon(str.substring(1));
        }
    }

    static void subseq(String p, String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    static ArrayList<String> subseq2(String p, String up, ArrayList<String> arr){
        if(up.isEmpty()) {
            if(!p.isEmpty()) arr.add(p);
            return arr;
        }
        char ch = up.charAt(0);
        subseq2(p + ch, up.substring(1), arr);
        subseq2(p, up.substring(1), arr);
        return arr;
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num: arr){
            int size = outer.size();
            for(int i = 0; i < size; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }

        return outer;
    }

}
