package Model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ChecksumUtilities {

    public static final int MAIN_DATA_CHECKSUM = 0x3523;

    public static final int MAIN_DATA_START = 0x2598;
    public static final int MAIN_DATA_END = 0x3523;


    public static final int BANK3_ALL_POKEMON_DATA_CHECKSUM = 0x54AC;
    public static final int BANK3_INDIVIDUAL_POKEMON_DATA_CHECKSUM_START = 0x5A4D;
    public static final int BANK3_INDIVIDUAL_POKEMON_DATA_CHECKSUM_END = 0x5A53;

    public static final int BANK4_ALL_POKEMON_DATA_CHECKSUM = 0x7A4C;
    public static final int BANK4_INDIVIDUAL_POKEMON_DATA_CHECKSUM_START = 0x7A4D;
    public static final int BANK4_INDIVIDUAL_POKEMON_DATA_CHECKSUM_END = 0x7A53;


    public boolean isValidChecksum(byte[] bankInput, byte checksum){

        return false;
    }

    public byte generateValidChecksum(byte[] bankInput, int startValue, int endValue){

       int dataSize = startValue - endValue;
       byte[] dataRange =  Arrays.copyOfRange(bankInput, startValue, endValue);
       return checksumAlgorithm(dataRange);
    }

    private byte checksumAlgorithm(byte[] dataRange){

        byte checksum = (byte) (0xFF);

        for (byte currentByte : dataRange) {
            checksum -= currentByte;
        }

        return checksum;
    }
}
