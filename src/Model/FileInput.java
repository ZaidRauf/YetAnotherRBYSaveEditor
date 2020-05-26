package Model;
import java.io.*;

public class FileInput {

   public static final int BANK_0_START = 0x0;
   public static final int BANK_1_START = 0x2000;
   public static final int BANK_2_START = 0x4000;
   public static final int BANK_4_START = 0x6000;

   private RandomAccessFile originalSaveFileInputStream = null;

   private byte[] saveFileData = null;

   public void loadSaveFile(String fileName) throws IOException{
       FileInputStream originalSaveFileInputStream = new FileInputStream(fileName);
       saveFileData = originalSaveFileInputStream.readAllBytes();
   }

    public byte[] getSaveFileData() { return saveFileData; }

}
