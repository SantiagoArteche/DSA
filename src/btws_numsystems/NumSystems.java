package btws_numsystems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumSystems {
    public static void main(String[] args){
//        System.out.println(fromDecimalToBinary(4));
        System.out.println(fromBinaryToOctal(1000));
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

}
