package Model;

import java.util.ArrayList;

public class Player {
    public static final int NAME = 0x2598;
    public static final int RIVAL_NAME = 0x25F6;
    public static final int NAME_SIZE = 0xB; //TODO: Check to see if this is needed, if not remove
    public static final int MONEY = 0x25F3;
    public static final int MONEY_SIZE = 0x3;
    public static final int GYM_BADGES = 0x2602;
    public static final int GYM_STATUES = 0x29D6;
    public static final int GYM_DATA_SIZE = 0x1;
    public static final int COINS = 0x2850;
    public static final int COINS_SIZE = 0x2;
    public static final int ID = 0x2605;
    public static final int ID_SIZE = 0x2;
    public static final int BAG_ITEM_START = 0x25C9;
    public static final int BAG_ITEM_COUNT_SIZE = 0x1;
    public static final int ITEM_SIZE = 0x2;

    public static String playerName;
    public static String rivalName;
    public static int money = 0;
    public static int gymBadges = (byte) 0x0;
    public static int coins = 0;
    public static int trainerID = 0;

    public static ArrayList<Item> bagItemList = new ArrayList(20);

}
