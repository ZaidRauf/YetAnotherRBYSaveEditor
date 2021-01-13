package Model;

public class SaveReader {
    private static byte[] saveGameData;

    public static int readPlayerMoney(){
        return 0;
    }

    public static String readPlayerName(){
        return CharacterDecodingUtilities.decodeName(SaveEditor.getSaveGameData(),  Player.NAME);
    }

    public static String readRivalName(){
       return CharacterDecodingUtilities.decodeName(SaveEditor.getSaveGameData(),  Player.RIVAL_NAME);
    }

    public static byte readBadges(){
        return saveGameData[Player.GYM_BADGES];
    }


    public static void setSaveGameData(byte[] readSaveGameData) {
        saveGameData = readSaveGameData;
    }

    public static byte[] getSaveGameData() {
        return saveGameData;
    }

}
