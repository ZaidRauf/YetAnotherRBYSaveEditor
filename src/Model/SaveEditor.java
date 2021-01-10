package Model;

import java.util.ArrayList;

public class SaveEditor {

    private byte[] saveGameData;

    public void changePlayerMoney(int newMoneyAmount){
        //TODO: throw exception if amount is greater than 999999

        changePlayerNumericalValue(newMoneyAmount, Player.MONEY, Player.MONEY_SIZE);

    }

    public void changePlayerGameCornerCoins(int newCoinsAmount){
        changePlayerNumericalValue(newCoinsAmount, Player.COINS, Player.COINS_SIZE);

    }

    private void changePlayerNumericalValue(int numericalValue, int address, int partitionNum){

        int  binaryCodedDecimalInput = NumberUtilities.decimalToBCD(numericalValue);
        ArrayList<Byte> splitArray = NumberUtilities.splitToBytes(binaryCodedDecimalInput, partitionNum);

        for (int offset = 0; offset < splitArray.size(); offset++){

            int addressAndOffset = address + offset;

            saveGameData[addressAndOffset] = splitArray.get(offset);

        }

    }

    public void changePlayerName(String newPlayerName){

        changePlayerTextValue(newPlayerName, Player.NAME);

    }

    public void changePlayerRivalName(String newRivalName){

        changePlayerTextValue(newRivalName, Player.RIVAL_NAME);

    }

    private void changePlayerTextValue(String newTextString, int address){
        byte[] newTextByteArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(newTextString);
        //TODO: Throw exception for names longer than 7 characters
        //TODO: Throw exception for invalid characters
        for (int offset = 0; offset < newTextByteArray.length; offset++){

            int nameAddressAndOffset = address + offset;

            saveGameData[nameAddressAndOffset] = newTextByteArray[offset];

        }
    }

    public void changePlayerBadges(byte newBadgeValue){
        saveGameData[Player.GYM_BADGES] = newBadgeValue;
        saveGameData[Player.GYM_STATUES] = newBadgeValue;
    }

    public void changePlayerIDNumber(short newPlayerIDNumber){

        ArrayList<Byte> playerArray = NumberUtilities.splitToBytes(newPlayerIDNumber,Player.ID_SIZE);

        saveGameData[Player.ID] = playerArray.get(0);
        saveGameData[Player.ID] = playerArray.get(1);

    }


    public void updateMainDataChecksum(){
        byte newChecksum = ChecksumUtilities.generateValidChecksum(saveGameData,
                ChecksumUtilities.MAIN_DATA_START,
                ChecksumUtilities.MAIN_DATA_END);

        saveGameData[ChecksumUtilities.MAIN_DATA_CHECKSUM] = newChecksum;
    }

    public void setSaveGameData(byte[] saveGameData) {
        this.saveGameData = saveGameData;
    }

    public byte[] getSaveGameData() {
        return saveGameData;
    }


}
