package Model;

public class SaveReader {
    private byte[] saveGameData;

    public int readPlayerMoney(){
        return 0;
    }

    public String readPlayerName(){
        String k = "k";
        return k;
    }

    public String readRivalName(){
        String k = "k";
        return k;
    }


    public void setSaveGameData(byte[] saveGameData) {
        this.saveGameData = saveGameData;
    }

    public byte[] getSaveGameData() {
        return saveGameData;
    }

}
