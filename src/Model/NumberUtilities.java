package Model;

public class NumberUtilities {

    public static byte[] splitToBytes(int hexadecimalValue){
        byte[] byteArray = {0x0,0x0,0x0};

        byteArray[2] = (byte) (0x00FF&(hexadecimalValue));
        byteArray[1] = (byte) (0x00FF&(hexadecimalValue >> 8));
        byteArray[0] = (byte) (hexadecimalValue >> 16);

        return byteArray;
    }

    public static int decimalToBCD(int inputDecimalValue){

        int len = numberOfDigits(inputDecimalValue);
        int hexSum = 0;

        for(int k = 0; k < len; k++){
            int kDigit = inputDecimalValue % ((int)Math.pow(10, k + 1));
            kDigit = kDigit / ((int) Math.pow(10, k));

            kDigit = kDigit << 4 * k;

            hexSum = hexSum|kDigit;

        }

        return hexSum;
    }

    private static int numberOfDigits(int decimalInput){
        if (decimalInput == 0){
            return 0;
        }

        return (int) Math.floor(Math.log10(decimalInput) + 1);
    }

}
