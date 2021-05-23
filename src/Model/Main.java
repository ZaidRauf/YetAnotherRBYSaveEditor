package Model;

import Controller.FileInput;
import Controller.SaveEditor;
import Controller.SaveReader;
import Data.PkmnStatMap;

import java.io.IOException;

import static Controller.SaveReader.getSaveGameData;
import static Controller.SaveReader.readBagItemList;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(NumberUtilities.BCDToDecimal(0x1234));

        PkmnStatMap pkmn = new PkmnStatMap();

        FileInput fileInput = new FileInput();
        fileInput.loadSaveFile("test3");

        SaveReader.setSaveGameData(fileInput.getSaveFileData());

        byte[] nameTest = {(byte) 0x81,(byte) 0x8B,(byte) 0x94,(byte) 0x84,(byte) 0x50};
        byte[] nameTest2 = {(byte) 0x86,(byte) 0x80,(byte) 0x91,(byte) 0x98,(byte) 0x50};
        byte[] nameTest3 = {(byte) 0x89,(byte) 0x81,(byte) 0x8B,(byte) 0x94,(byte) 0x84,(byte) 0x50};
        byte[] nameTest4 = {(byte) 0x82,(byte) 0x87,(byte) 0x80,(byte) 0x91,(byte) 0x8C,(byte) 0x80,(byte) 0x8D,(byte) 0x83,(byte) 0x84,(byte) 0x91,(byte) 0x50};
        byte[] nameTest5 = {(byte) 0x91,(byte) 0x80,(byte) 0x93,(byte) 0x93,(byte) 0x80,(byte) 0x93,(byte) 0x80,(byte) 0x50};
        String str = CharacterDecodingUtilities.decodeName(nameTest5, 0);

        System.out.println(str);

        SaveReader.readBagItemList();

        PokemonUtilities.readPartyPokemon(SaveReader.getSaveGameData(), 0x2F34);

////
////        byte checksumTest = ChecksumUtilities.generateValidChecksum(fileInput.getSaveFileData(), ChecksumUtilities.MAIN_DATA_START, ChecksumUtilities.MAIN_DATA_END);
////
////        System.out.printf("%X\n",checksumTest);
//
//        String testName = "AAAA";
//
//        byte[] testNameArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(testName);
//
////        for (byte b : testNameArray) {
////            System.out.printf("0x%X ", b);
////        }
//
//        SaveEditor saveEditor = new SaveEditor();
//        saveEditor.setSaveGameData(fileInput.getSaveFileData());
//
//        SaveReader.setSaveGameData(fileInput.getSaveFileData());
//        System.out.println(SaveReader.readPlayerNumber(Player.COINS, Player.COINS_SIZE));
//
//        saveEditor.changePlayerName("AAAA");
//
//        System.out.println("\n");
//        int tst = SaveEditor.getSaveGameData()[0x25F3];
//        System.out.println(Integer.toBinaryString(tst & 0x000000FF)); // 1001 1000
//        System.out.println(0x98);
////        System.out.println(CharacterDecodingUtilities.decodeName(saveEditor.getSaveGameData(),  0x2598));
//
//        SaveReader.setSaveGameData(SaveEditor.getSaveGameData());

//        System.out.printf("0x%X", SaveEditor.getSaveGameData()[Player.GYM_BADGES]);

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
