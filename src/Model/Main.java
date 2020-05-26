package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ChecksumUtilities checksumUtilities = new ChecksumUtilities();

        FileInput fileInput = new FileInput();
        fileInput.loadSaveFile("testFile");

        byte checksumTest = checksumUtilities.generateValidChecksum(fileInput.getSaveFileData(), ChecksumUtilities.MAIN_DATA_START, ChecksumUtilities.MAIN_DATA_END);

        System.out.printf("%X",checksumTest);

    }


}
