package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutput {

    public static void generateEditedSaveFile(String fileDirectory, String fileName, byte[] editedFileData) throws IOException {
        File saveFile = new File(fileDirectory, fileName);
        saveFile.createNewFile();

        OutputStream outputStream = new FileOutputStream(saveFile.getAbsolutePath(), false);
        outputStream.write(editedFileData);
    }

}
