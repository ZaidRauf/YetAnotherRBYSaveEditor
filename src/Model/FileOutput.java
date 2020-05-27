package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutput {

    public static void generateEditedSaveFile(String fileName, byte[] editedFileData) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(editedFileData);
    }

}
