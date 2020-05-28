package Model;

public class SaveEditor {
    public static final int PLAYER_NAME = 0x2598;
    public static final int PLAYER_NAME_SIZE = 0xB;
    public static final int PLAYER_MONEY = 0x25F3;
    public static final int PLAYER_GYM_BADGES = 0x2602;

    private byte[] saveGameData;

    public void changePlayerMoney(){

    }

    public void changePlayerName(String newPlayerName){
        byte[] nameByteArray = CharacterEncodingUtilities.stringToEncodedCharByteArray(newPlayerName);
        //TODO: Throw exception for names longer than 7 characters
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
