package Controller;

import Model.CharacterDecodingUtilities;
import Model.Item;
import Model.NumberUtilities;
import Model.Player;

import java.util.ArrayList;

public class SaveReader {
    private static byte[] saveGameData;

    public static ArrayList<Item> readBagItemList(){

        Player.bagItemList = new ArrayList<Item>();

        int itemCount = saveGameData[Player.BAG_ITEM_START];
        int readingIndex = Player.BAG_ITEM_START + 1;

        for(int k = 0; k < itemCount; k++){

            Item item = readPlayerItem(readingIndex);
            readingIndex += Player.ITEM_SIZE;
            Player.bagItemList.add(item);

            System.out.println(item.getItemName() + " " + item.getItemCount());

        }

        return Player.bagItemList;
    }

    private static Item readPlayerItem(int itemStart){
        int itemIndex = saveGameData[itemStart];
        int itemCount = saveGameData[itemStart + 1];

        return ItemFactory.generateItem(itemIndex, itemCount);
    }

    public static int readPlayerID(){
        int upperHalf =  saveGameData[Player.ID];
        int lowerHalf =  saveGameData[Player.ID + 1];

        upperHalf = (upperHalf & 0xFF) << 8;

        int trainerID = upperHalf + (lowerHalf & 0xFF);

        return trainerID;
    }

    public static String readPlayerIDStr(){
        String idStr = Integer.toString(readPlayerID());
        int numLen = NumberUtilities.numberOfDecimalDigits(readPlayerID());

        for(int k = 5; k > numLen; k--){
            idStr = "0" + idStr;
        }

        return idStr;
    }

    public static int readPlayerMoney(){
        return readPlayerNumber(Player.MONEY, Player.MONEY_SIZE);
    }

    public static int readPlayerCoins(){
        return readPlayerNumber(Player.COINS, Player.COINS_SIZE);
    }

    public static String readPlayerName(){
        return CharacterDecodingUtilities.decodeName(saveGameData,  Player.NAME);
    }

    public static String readRivalName(){
       return CharacterDecodingUtilities.decodeName(saveGameData,  Player.RIVAL_NAME);
    }

    public static byte readBadges(){
        return saveGameData[Player.GYM_BADGES];
    }

    public static int readPlayerNumber(int numStartLocation, int numBytes){
        int currentLocation = numStartLocation;
        int hexSum = 0;
        int shiftMultiple = numBytes - 1;

        for(int k = 0; k < numBytes; k++){
            int readByte = saveGameData[currentLocation] & 0x000000FF;
            int shiftedByte = readByte << 8 * shiftMultiple;
            hexSum = hexSum + shiftedByte;
            currentLocation++;
            shiftMultiple--;

        }

        int byteSum = NumberUtilities.BCDToDecimal(hexSum);


        return byteSum;
    }


    public static void setSaveGameData(byte[] readSaveGameData) {
        saveGameData = readSaveGameData;
    }

    public static byte[] getSaveGameData() {
        return saveGameData;
    }

}
