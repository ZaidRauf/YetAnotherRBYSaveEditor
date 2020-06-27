package Model;

import java.util.ArrayList;

public class NumberUtilities {

    public static ArrayList<Byte> splitToBytes(int hexadecimalValue, int partitionNum){
        ArrayList<Byte> byteArrayList = new ArrayList<>();

        int byteShiftAmount = 8 * (partitionNum - 1);

        for (int k = 0; k < partitionNum; k++){
            byteArrayList.add((byte) (0x00FF&(hexadecimalValue >> byteShiftAmount)));
            byteShiftAmount -= 8;
        }

        return byteArrayList;
    }


    public static int decimalToBCD(int inputDecimalValue){

        int len = numberOfDigits(inputDecimalValue);
        int hexSum = 0;

        for(int k = 0; k < len; k++){
            int kDigit = inputDecimalValue % ((int)Math.pow(10, k + 1));
            kDigit = kDigit / ((int) Math.pow(10, k));

            kDigit = kDigit << 4 * k;

            hexSum += kDigit;

        }

        return hexSum;
    }

    private static int numberOfDigits(int decimalInput){
        if (decimalInput == 0){
            return 1;
        }

        return (int) Math.floor(Math.log10(decimalInput) + 1);
    }

}
