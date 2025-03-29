package sorting;

import java.sql.SQLOutput;
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {1515, 9, 6, -1, 1, 2, 3, 4, 5, 11, 155, -1};
        bubbleSort(arr);
        showArray(arr);

        int[] arr2 = {9, 6, -1, 1, 2, 3, 4, 5, 11};
        selectionSort(arr2);
        showArray(arr2);

        int[] arr3 = {9, 6, -1, 1, 2, 3, 4, 5, 11};
        insertionSort(arr3);
        showArray(arr3);

        int[] arr4 = {2, 2, 7, 8, 1, 3, 4, 3, 9};
        cyclicSort(arr4);
        showArray(arr4);

        int[] arr5 = {3, 4, 1, 3, 2, 5, 2};
        countSort(arr5);
        showArray(arr5);

        int[] arr6 = {29, 83, 471, 36, 91, 8, 2};
        radixSort(arr6);
        showArray(arr6);
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else{
                i++;
            }
        }
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swaped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swapElements(arr, j, j - 1);
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swapElements(arr, maxIndex, last);
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swapElements(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }


    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;

        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }

    static void swapElements(int[] arr, int val1, int val2) {
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }

    static void countSort(int[] arr){
        if(arr == null || arr.length <= 1) return;

        int max = arr[0];

        for(int num: arr){
            if(num > max){
                max = num;
            }
        }

        int[] countArr = new int[max + 1];

        for(int num: arr){
            countArr[num]++;
        }

        int idx = 0;
        for(int i = 0; i <= max; i++){
            while(countArr[i] > 0){
                arr[idx] = i;
                idx++;
                countArr[i]--;
            }
        }

    }

    static void radixSort(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int exp = 1; max / exp > 0; exp *= 10){
            countSortForRadix(arr, exp);
        }
    }

    static void countSortForRadix(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for(int i = 0; i < count.length; i++){
            count[i] = 0;
        }

        for(int j = 0; j < n ; j++){
            count[(arr[j] / exp) % 10]++;
        }

        System.out.println("Count array for " + exp + " : " + Arrays.toString(count));
        for(int k = 1; k < 10; k++){
            count[k] = count[k] + count[k - 1];
        }

        System.out.println("Updated count array for " + exp + " : " + Arrays.toString(count));

        for(int l = n - 1; l >= 0; l--){
            output[count[(arr[l] / exp) % 10] - 1] = arr[l];
            count[(arr[l] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    static void showArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
