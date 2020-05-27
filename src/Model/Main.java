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

        ChecksumUtilities checksumUtilities = new ChecksumUtilities();

        FileInput fileInput = new FileInput();
        fileInput.loadSaveFile("testFile");

        byte checksumTest = checksumUtilities.generateValidChecksum(fileInput.getSaveFileData(), ChecksumUtilities.MAIN_DATA_START, ChecksumUtilities.MAIN_DATA_END);

        System.out.printf("%X\n",checksumTest);

        String testName = "ZED";

        byte[] testNameArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(testName);


        for (int k = 0; k < testNameArray.length; k++){

            System.out.printf("0x%X ",testNameArray[k]);

        }

        generateEditedSaveFile("testOutput.sav", fileInput.getSaveFileData());
    }


}
