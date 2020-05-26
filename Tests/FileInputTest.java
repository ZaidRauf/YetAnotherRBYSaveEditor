import Model.ChecksumUtilities;
import Model.FileInput;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileInputTest {

    private FileInput givenFileInput() throws IOException{
        FileInput fileInput = new FileInput();
        fileInput.loadSaveFile("testFile");
        return fileInput;
    }

    @Test
    void validateFileInput() throws IOException {
        FileInput fileInput = givenFileInput();

        thenFileDataShouldBeValid(fileInput);

    }

    private void thenFileDataShouldBeValid(FileInput fileInput) {
        assertEquals((byte) 0xB2, fileInput.getSaveFileData()[ChecksumUtilities.MAIN_DATA_CHECKSUM]);
    }


    private byte whenGeneratingValidChecksum(FileInput fileInput){
        ChecksumUtilities checksumUtilities = new ChecksumUtilities();
        byte checksum = checksumUtilities.generateValidChecksum(
                fileInput.getSaveFileData(),
                ChecksumUtilities.MAIN_DATA_START,
                ChecksumUtilities.MAIN_DATA_END);
        return checksum;
    }


    @Test
    void validateCheckSum() throws IOException {

       FileInput fileInput = givenFileInput();

       byte checksumTestValue = whenGeneratingValidChecksum(fileInput);

        assertEquals((byte) 0xB2, checksumTestValue);

    }



}