package recursion;

public class Permutation {
    public static void main(String[] args){
        permutations("", "abc");
        System.out.println(permutationCount("", "abc"));
    }

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString();

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String fs = p.substring(0, i);
            String sc = p.substring(i);
            permutations(fs + ch + sc,  up.substring(1));
        }
    }

    static int permutationCount(String p, String up){
        if(up.isEmpty()) return 1;

        char ch = up.charAt(0);
        int count = 0;

        for(int i = 0; i <= p.length(); i++){
            String fs = p.substring(0, i);
            String sc = p.substring(i);
            count += permutationCount(fs + ch + sc, up.substring(1));
        }

        return count;
    }
}
