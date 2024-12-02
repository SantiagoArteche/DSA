package recursion;

import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args){

        int[] arrSorted = {1, 3 , 5, 9,9, 10, 12};
        int[] arrNotSorted = {4,4, 6,6, 2,2, 1,1, 9,9, 11,1};
        System.out.println(isSorted(arrSorted, 0));
        System.out.println(findIndex(arrNotSorted, 0 , 1));
        System.out.println(findLastIndex(arrSorted, arrSorted.length - 1 , 55));
        System.out.println(findOccurrences(arrNotSorted, 0, 1, new ArrayList<>()));
    }


    static boolean isSorted(int[] arr, int idx){
        if(idx == arr.length - 1) return true;

        return arr[idx] <= arr[idx + 1] && isSorted(arr, idx + 1);
    }

    static int findIndex(int[] arr, int idx, int target){
        if(idx == arr.length) return -1;

        if(arr[idx] == target) return idx;

        return findIndex(arr, idx + 1, target);
    }

    static int findLastIndex(int[] arr, int idx, int target){
        if(idx < 0) return -1;

        if(arr[idx] == target) return idx;

        return findIndex(arr, idx - 1, target);
    }

    static ArrayList<Integer> findOccurrences(int[] arr, int idx, int target, ArrayList<Integer> occ){
        if(idx == arr.length) return occ;

        if(arr[idx] == target) occ.add(idx);

        return findOccurrences(arr, idx + 1, target, occ);
    }
}
