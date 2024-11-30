package recursion;

public class Recursion {
    public static void main(String[] args){
        for(int i = 0; i < 15; i++){
            System.out.println(fibonacci(i));
        }

        int[] arr = {3, 4, 5, 6, 9 ,11, 22, 33, 44};

        System.out.println("index of target = " + binarySearch(arr, 44, 0 , arr.length - 1));
    }

    public static void print(int start, int end){
        if(start > end) return;

        System.out.println(start);

        print(start + 1, end);
    }

    public static int fibonacci(int n){
        if(n < 2) return n;

        return fibonacci(n - 1) + fibonacci(n - 2); // Until the first expressions are fully executed, the second expression won't start
        // f(4) -> f(3) f(2)
        // f(3) -> f(2) f(1) // Left side of f(4) == f(3). Right = f(2)
        // f(2) -> f(1) f(0)
        // then start the right side from f(2). The explanation is using fibonacci number 4
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        if(arr.length == 0) return -1;

        int middle = start + (end - start) / 2;

        if(start > end) return -1;

        if(arr[middle] == target) return middle;

        if(arr[middle] > target){
            return binarySearch(arr, target, start, middle - 1);
        }else{
            return binarySearch(arr, target, middle + 1, end);
        }
    }
}
