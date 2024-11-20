import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 15, 20, 33, 44, 55, 66, 77, 88, 99, 102, 106, 109, 1100, 1500, 1600};
        System.out.println(binarySearch(arr, 55));
//        System.out.println(orderReversedBinarySearch(arr, 55));
    }


    public static int binarySearch(int[] arr, int target){
        if(arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int middle = start + (end - start) / 2;

            if(target > arr[middle]){
                start =  middle + 1;
            }else if(target < arr[middle]){
                end = middle - 1;
            }else {
                return middle;
            }
        }

        return  -1;
    }

    public static int orderReversedBinarySearch(int[] array, int target){
        int[] reversedArray = new int[array.length];

        for(int i = array.length -1, j = 0; i >= 0; i--, j++){
            reversedArray[j] = array[i];
        }

        int start = 0;
        int end = reversedArray.length - 1;

        while (start <= end){
            int middle = start + (end - start) / 2;

            if(reversedArray[middle] > target){
                start = middle + 1;
            }else if(reversedArray[middle] < target){
                end = middle - 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}