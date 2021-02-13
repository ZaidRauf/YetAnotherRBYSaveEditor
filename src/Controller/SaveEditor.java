package Controller;

import Data.ItemKeys;
import Model.*;

import java.util.ArrayList;

public class SaveEditor {

    private static byte[] saveGameData;

    public static void changePlayerMoney(int newMoneyAmount){
        //TODO: throw exception if amount is greater than 999999

        changePlayerNumericalValue(newMoneyAmount, Player.MONEY, Player.MONEY_SIZE);

    }

    public static void removeBagItem(int removalIndex){
        removeItem(Player.bagItemList, removalIndex);
    }

    public static void addBagItem(String itemName, int itemCount){
        addItem(Player.bagItemList, ItemKeys.getItemIndex(itemName), itemCount);
    }

    private static void addItem(ArrayList<Item> itemList, int itemIndex, int itemCount){
        itemList.add(ItemFactory.generateItem(itemIndex, itemCount));
    }

    public static void changeBagAmount(int changeIndex, int newCount){
        changeItemAmount(Player.bagItemList, changeIndex, newCount);
    }

    public static void changeBagItem(int changeIndex, String newItem){
        changeItem(Player.bagItemList, changeIndex, newItem);
    }

    private static void changeItem(ArrayList<Item> itemList, int changeIndex, String newItem){
        itemList.get(changeIndex).setItem(newItem);
    }

    private static void changeItemAmount(ArrayList<Item> itemList, int changeIndex, int newCount){
        itemList.get(changeIndex).setItemCount(newCount);
    }

    private static void removeItem(ArrayList<Item> itemList, int removalIndex){
        itemList.remove(removalIndex);
    }

    public static void writeBagItems(){
        writePlayerItems(Player.BAG_ITEM_START, Player.bagItemList);
    }

    private static void writePlayerItems(int location, ArrayList<Item> items){
        saveGameData[location] = (byte) items.size();
        location++;

        for(Item k : items){
            saveGameData[location] = (byte) k.getItemID();
            saveGameData[location + 1] = (byte) k.getItemCount();

            location += 2;
        }

        saveGameData[location] = (byte) 0xFF;

    }

    private static void writePlayerItem(int location, int itemIndex, int itemAmount){
        saveGameData[location] = (byte) itemIndex;
        saveGameData[location + 1] = (byte) itemAmount;
    }

    public static void changePlayerGameCornerCoins(int newCoinsAmount){
        changePlayerNumericalValue(newCoinsAmount, Player.COINS, Player.COINS_SIZE);

    }

    public static void changePlayerID(int newCoinsAmount){
        int upperHalf =  newCoinsAmount & 0xFF00;
        upperHalf = upperHalf >> 8;

        int lowerHalf =  newCoinsAmount & 0x00FF;

        saveGameData[Player.ID] = (byte) upperHalf;
        saveGameData[Player.ID + 1] = (byte) lowerHalf;
    }

    private static void changePlayerNumericalValue(int numericalValue, int address, int partitionNum){

        int  binaryCodedDecimalInput = NumberUtilities.decimalToBCD(numericalValue);
        ArrayList<Byte> splitArray = NumberUtilities.splitToBytes(binaryCodedDecimalInput, partitionNum);

        for (int offset = 0; offset < splitArray.size(); offset++){

            int addressAndOffset = address + offset;

            saveGameData[addressAndOffset] = splitArray.get(offset);

        }

    }

    public static void changePlayerName(String newPlayerName){

        for(int currentNameByte = Player.NAME; currentNameByte < Player.NAME + Player.NAME_SIZE; currentNameByte++){
            saveGameData[currentNameByte] = 0x0;
        }

        changePlayerTextValue(newPlayerName, Player.NAME);

    }

    public static void changePlayerRivalName(String newRivalName){

        for(int currentNameByte = Player.RIVAL_NAME; currentNameByte < Player.RIVAL_NAME + Player.NAME_SIZE; currentNameByte++){
            saveGameData[currentNameByte] = 0x0;
        }

        changePlayerTextValue(newRivalName, Player.RIVAL_NAME);

    }

    private static void changePlayerTextValue(String newTextString, int address){
        byte[] newTextByteArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(newTextString);

        //TODO: Throw exception for names longer than 7 characters
        //TODO: Throw exception for invalid characters
        for (int offset = 0; offset < newTextByteArray.length; offset++){

            int nameAddressAndOffset = address + offset;

            saveGameData[nameAddressAndOffset] = newTextByteArray[offset];

        }
    }

    public static void changePlayerBadges(byte newBadgeValue){
        saveGameData[Player.GYM_BADGES] = newBadgeValue;
        saveGameData[Player.GYM_STATUES] = newBadgeValue;
    }

    public static void changePlayerIDNumber(short newPlayerIDNumber){

        ArrayList<Byte> playerArray = NumberUtilities.splitToBytes(newPlayerIDNumber,Player.ID_SIZE);

        saveGameData[Player.ID] = playerArray.get(0);
        saveGameData[Player.ID] = playerArray.get(1);

    }


    public static void updateMainDataChecksum(){
        byte newChecksum = ChecksumUtilities.generateValidChecksum(saveGameData,
                ChecksumUtilities.MAIN_DATA_START,
                ChecksumUtilities.MAIN_DATA_END);

        saveGameData[ChecksumUtilities.MAIN_DATA_CHECKSUM] = newChecksum;
    }

    public static void setSaveGameData(byte[] newSaveData) {
        saveGameData = newSaveData;
    }

    public static byte[] getSaveGameData() {
        return saveGameData;
    }


}
