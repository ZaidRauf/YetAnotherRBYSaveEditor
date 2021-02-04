package Model;

import java.util.ArrayList;

public class NumberUtilities {

    public static ArrayList<Byte> splitToBytes(int hexadecimalValue, int partitionNum){
        ArrayList<Byte> byteArrayList = new ArrayList<>();

        int byteShiftAmount = 8 * (partitionNum - 1);

        for (int k = 0; k < partitionNum; k++){
            byteArrayList.add((byte) (0x00FF & (hexadecimalValue >> byteShiftAmount)));
            byteShiftAmount -= 8;
        }

        return byteArrayList;
    }

    public static int decimalToBCD(int inputDecimalValue){

        int len = numberOfDecimalDigits(inputDecimalValue);
        int hexSum = 0;

        for(int k = 0; k < len; k++){
            int kDigit = inputDecimalValue % ((int)Math.pow(10, k + 1));
            kDigit = kDigit / ((int) Math.pow(10, k));

            kDigit = kDigit << 4 * k;

            hexSum += kDigit;

        }

        return hexSum;
    }

    public static int BCDToDecimal(int inputBCDValue){
        int hexLength = numberOfHexDigits(inputBCDValue);
        int bcdSum = 0;
        int bcdMultiple = 1;

       for(int k = 0; k < hexLength; k++){

           int hexByte = inputBCDValue >> 4 * k;
           hexByte = hexByte & 0xF;
           bcdSum += hexByte * bcdMultiple;
           bcdMultiple = 10 * bcdMultiple;

       }

        return bcdSum;
    }


    private static int numberOfHexDigits(int hexInput){
        if (hexInput == 0){
            return 1;
        }

        return (int) Math.floor((Math.log(hexInput)/Math.log(16)) + 1);
    }

    public static int numberOfDecimalDigits(int decimalInput){
        if (decimalInput == 0){
            return 1;
        }

        return (int) Math.floor(Math.log10(decimalInput) + 1);
    }

}
