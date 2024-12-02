package recursion;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {4,5,9,1,2,3,11,23, -3};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int row, int col){
        if(row == 0) return;

        if(col < row){
            if(arr[col] > arr[col + 1]){
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        }else{
            bubbleSort(arr, row - 1, 0);
        }
    }

    public static void selectionSort(int[] arr, int row, int col, int max){
        if(row == 0) return;

        if(col < row){
            if(arr[col] > arr[max]){
                selectionSort(arr, row, col + 1, col);
            }else{
                selectionSort(arr, row, col + 1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort(arr, row - 1, 0,  0);
        }
    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1) return arr;


        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right){
        int[] mergedArr = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                mergedArr[k] = left[i];
                i++;
            }else{
                mergedArr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length){
            mergedArr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            mergedArr[k] = right[j];
            j++;
            k++;
        }

        return mergedArr;
    }

    private static void inPlaceMergeSort(int[] arr, int start, int end){
        if(end - start == 1) return;

        int mid = start + (end - start) / 2;

        inPlaceMergeSort(arr, start, mid);
        inPlaceMergeSort(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    public static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mergedArr = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mergedArr[k] = arr[i];
                i++;
            }else{
                mergedArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < mid){
            mergedArr[k] = arr[i];
            i++;
            k++;
        }

        while(j < end){
            mergedArr[k] = arr[j];
            j++;
            k++;
        }

        for(int l = 0; l < mergedArr.length; l++){
            arr[start + l] = mergedArr[l];
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end){
            while (arr[start] < pivot){
                start++;
            }
            while (arr[end] > pivot){
                end--;
            }

            if(start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}


