
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] numbers = {15555 , 1234, 123123, 123, 3, 5, 11,9999999, 1,91 , 14,9 ,12 , 8, 12124, 6};
       for(int i = 0; i < numbers.length - 1; i++){
           for(int j = i + 1; j < numbers.length; j++){
               if(numbers[i] > numbers[j]){
                   int temp = numbers[j];
                   numbers[j] = numbers[i];
                   numbers[i] = temp;
               }
           }
       }

       System.out.println("ASC " + Arrays.toString(numbers));
       System.out.println();

       int[] ints = new int[numbers.length];
       for(int i = numbers.length - 1, j = 0; i >= 0; i--, j++){
           ints[j] = numbers[i];
       }
        System.out.println("DESC " + Arrays.toString(ints));

       System.out.println(1912422144 % 10);

       int n = 9494;
       int count = 0;
       int target = 4;
       StringBuilder reverseNumber = new StringBuilder();
       while(n > 0){
           int rem = n % 10; // all numbers % 10 return the last digit of the number example 195819 % 10 = 9
           if(rem == target){
               count++;
           }
           reverseNumber.append(rem);
           n /= 10;
       }

       System.out.println(Long.parseLong(reverseNumber.toString()));
       System.out.println("This is count " + count);

       System.out.println(getMax(numbers));
       System.out.println(Arrays.toString(numbers));
       System.out.println(reverse(numbers));
    }

    static int getMax(int[] nums){
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    static String reverse(int[] nums){
        int[] arrayReversed = new int[nums.length];

        for(int i = nums.length - 1, j = 0; // Init Variables
            i >= 0; // Condition
            i--, j++ //Update Variables
        ) {
            // arrRev[0], arrRev[1], arrRev[2] = nums[arr.length -1], nums[arr.length -2], etc.
            arrayReversed[j] = nums[i];
        }

        return Arrays.toString(arrayReversed);
    }
}