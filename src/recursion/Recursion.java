package recursion;

public class Recursion {
    static int sum = 0;
    public static void main(String[] args){

        System.out.println(countZero(104030303, 0));
    }

    public static void print(int n){
        if(n == 0) return;

        System.out.println(n);

        print(n - 1);
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

        if(start > end) return -1;

        int middle = start + (end - start) / 2;

        if(arr[middle] == target) return middle;

        if(arr[middle] > target){
            return binarySearch(arr, target, start, middle - 1);
        }

        return binarySearch(arr, target, middle + 1, end);
    }

    public static int factorial(int n){
        if(n == 0) return 1;

        return n * factorial(n - 1);
    }

    public static int sumOfDigits(int n){
        if(n == 0) return 0;

        return n % 10 + sumOfDigits(n / 10);
    }


    public static void reverseNumber(int n){
        if(n == 0) {
            return;
        }

        int remainder = n % 10;
        sum = sum * 10 + remainder;
        reverseNumber(n / 10);
    }



//    public static StringBuilder reverseNumber(int n){ // My favorite way to reverse a number
//        StringBuilder reversed = new StringBuilder();
//        while(n > 0){
//            reversed.append(n % 10);
//            n /= 10;
//        }
//        return reversed;
//    }

    public static int countZero(int n, int count){
        if(n == 0) return count;

        if(n % 10 == 0) count++;

        return countZero(n / 10, count);
    }
}
