package btws_numsystems;

import java.lang.reflect.Array;
import java.util.*;

public class NumSystems {
    public static void main(String[] args){
//       System.out.println(fromDecimalToBinary(4));
//       System.out.println(fromBinaryToOctal(1000));
        System.out.println(magicNumber(6));
        for(int i = 0; i < 100; i++){
            if(isPrime(i)) System.out.println(i);
        }
        System.out.println(isOdd(2));
    }

    static StringBuilder fromDecimalToBinary(int num){
        StringBuilder binary = new StringBuilder();
        while(num > 0){
            binary.append(num % 2);
            num = num / 2;
        }
        return binary.reverse();
    }

    static StringBuilder fromDecimalToOctal(int num){
        StringBuilder octal = new StringBuilder();
        while(num > 0){
            octal.append(num % 8);
            num = num / 8;
        }
        return octal.reverse();
    }

    static int fromBinaryToDecimal(int num){
        double decimal = 0;
        int i = 1;
        while(num > 0){
            decimal += Math.pow((num % 10 * 2), i);
            num = num / 10;
            i++;
        }

        return (int) decimal / 2;
    }

    static StringBuilder fromBinaryToOctal(int num){
        int decimal = fromBinaryToDecimal(num);
        return fromDecimalToOctal(decimal);
    }

    static int magicNumber(int n){
        int base = 5;
        int ans = 0;
        while(n > 0){
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base * 5;
        }
        return ans;
    }

    static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static boolean isOdd(int n){
        return (n & 1) == 1;
    }

}
