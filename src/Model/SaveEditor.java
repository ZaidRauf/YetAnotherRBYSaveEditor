package Model;

public class SaveEditor {
    public static final int PLAYER_NAME = 0x2598;
    public static final int PLAYER_NAME_SIZE = 0xB; //TODO: Check to see if this is needed, if not remove
    public static final int PLAYER_MONEY = 0x25F3;
    public static final int PLAYER_MONEY_SIZE = 0x3;
    public static final int PLAYER_GYM_BADGES = 0x2602;

    private byte[] saveGameData;

    public void changePlayerMoney(int newMoneyAmount){
        //TODO: throw exception if amount is greater than 999999

       int  binaryCodedDecimalInput = NumberUtilities.decimalToBCD(newMoneyAmount);
       byte[] splitMoneyArray = NumberUtilities.splitToBytes(binaryCodedDecimalInput);

        for (int offset = 0; offset < splitMoneyArray.length; offset++){

            int moneyAddressAndOffset = PLAYER_MONEY + offset;

            saveGameData[moneyAddressAndOffset] = splitMoneyArray[offset];

        }

    }

    public void changePlayerName(String newPlayerName){
        byte[] nameByteArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(newPlayerName);
        //TODO: Throw exception for names longer than 7 characters
        //TODO: Throw exception for invalid characters
        for (int offset = 0; offset < nameByteArray.length; offset++){

            int nameAddressAndOffset = PLAYER_NAME + offset;

            saveGameData[nameAddressAndOffset] = nameByteArray[offset];

        }
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
