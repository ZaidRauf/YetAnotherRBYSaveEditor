package Controller;

import Model.*;

import java.util.ArrayList;

public class SaveReader {
    private static byte[] saveGameData;

    public static Pokemon readPartyPokemon(int location){
        Pokemon pkmn = new Pokemon();
        return pkmn;
    }

    public static int readCurrentInventoryItems(boolean bagItems){
        if(bagItems){
            return readBagNumItems();
        }

        else{
            return readPCNumItems();
        }
    }

    public static int readPCNumItems() {
        return Player.pcItemList.size();
    }

    public static int readBagNumItems() {
        return Player.bagItemList.size();
    }

    public static int readCurrentInventoryItemAmount(int readIndex, boolean bagItems){
        if(bagItems){
            return readItemAmount(Player.bagItemList, readIndex);
        }

        else{
            return readItemAmount(Player.pcItemList, readIndex);
        }
    }

    public static int readPCItemAmount(int readIndex) {
        return readItemAmount(Player.pcItemList, readIndex);
    }

    public static int readBagItemAmount(int readIndex) {
        return readItemAmount(Player.bagItemList, readIndex);
    }

    private static int readItemAmount(ArrayList<Item> itemList, int readIndex){
        return itemList.get(readIndex).getItemCount();
    }

    public static void readPCItemList(){

        Player.pcItemList = new ArrayList<Item>();

        int itemCount = saveGameData[Player.PC_ITEM_START];
        int readingIndex = Player.PC_ITEM_START + 1;

        for(int k = 0; k < itemCount; k++){

            Item item = readPlayerItem(readingIndex);
            readingIndex += Player.ITEM_SIZE;
            Player.pcItemList.add(item);

            System.out.println(item.getItemName() + " " + item.getItemCount());

        }

    }

    public static void readBagItemList(){

        Player.bagItemList = new ArrayList<Item>();

        int itemCount = saveGameData[Player.BAG_ITEM_START];
        int readingIndex = Player.BAG_ITEM_START + 1;

        for(int k = 0; k < itemCount; k++){

            Item item = readPlayerItem(readingIndex);
            readingIndex += Player.ITEM_SIZE;
            Player.bagItemList.add(item);

            System.out.println(item.getItemName() + " " + item.getItemCount());

        }

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
