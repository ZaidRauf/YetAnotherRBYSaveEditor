package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Model.FileOutput.generateEditedSaveFile;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInput fileInput = new FileInput();
        fileInput.loadSaveFile("testFile");
//
//        byte checksumTest = ChecksumUtilities.generateValidChecksum(fileInput.getSaveFileData(), ChecksumUtilities.MAIN_DATA_START, ChecksumUtilities.MAIN_DATA_END);
//
//        System.out.printf("%X\n",checksumTest);

        String testName = "AAAA";

        byte[] testNameArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(testName);

        for (byte b : testNameArray) {
            System.out.printf("0x%X ", b);
        }

        SaveEditor saveEditor = new SaveEditor();
        saveEditor.setSaveGameData(fileInput.getSaveFileData());

        saveEditor.changePlayerName("AAAA");

        System.out.println("\n");

        System.out.println(CharacterDecodingUtilities.decodeName(saveEditor.getSaveGameData(),  0x2598));

        SaveReader.setSaveGameData(SaveEditor.getSaveGameData());

        System.out.printf("0x%X", SaveEditor.getSaveGameData()[Player.GYM_BADGES]);


//        saveEditor.changePlayerMoney(123456);
//
//        int test = 'A' - 'Z';
//        int test2 = 9;
//        int hexSum = NumberUtilities.decimalToBCD(123456);
//
//        System.out.printf("\n\n%X\n",hexSum);
//
//        ArrayList<Byte> arr = NumberUtilities.splitToBytes(hexSum, 3);
//        System.out.println(arr);
//
//        saveEditor.updateMainDataChecksum();
//
    }



}
