package Model;

import Data.Type;

public class Pokemon {
    public static final int INDEX_OFFSET = 0x00;
    public static final int CURRENT_HP_OFFSET = 0x01;
    public static final int CURRENT_HP_SIZE = 0x02;
    public static final int LEVEL_OFFSET_FIRST = 0x03;
    public static final int STATUS_CONDITION_OFFSET = 0x04;
    public static final int TYPE1_OFFSET = 0x05;
    public static final int TYPE2_OFFSET = 0x06;
    public static final int CATCH_RATE = 0x07;
    public static final int MOVE1_OFFSET = 0x08;
    public static final int MOVE2_OFFSET = 0x09;
    public static final int MOVE3_OFFSET = 0x0A;
    public static final int MOVE4_OFFSET = 0x0B;
    public static final int OT_ID_OFFSET = 0x0C;
    public static final int OT_ID_SIZE = 0x02;
    public static final int EXP_OFFSET = 0x0E;
    public static final int EXP_SIZE = 0x03;
    public static final int HP_EV_OFFSET = 0x11;
    public static final int EV_SIZE = 0x02;
    public static final int ATTACK_EV_OFFSET = 0x13;
    public static final int DEFENSE_EV_OFFSET = 0x15;
    public static final int SPEED_EV_OFFSET = 0x17;
    public static final int SPECIAL_EV_OFFSET = 0x19;
    public static final int IV_OFFSET = 0x1B;
    public static final int IV_SIZE = 0x02;
    public static final int MOVE1_PP_OFFSET = 0x1D;
    public static final int MOVE2_PP_OFFSET = 0x1E;
    public static final int MOVE3_PP_OFFSET = 0x1F;
    public static final int MOVE4_PP_OFFSET = 0x20;
    public static final int PARTY_LEVEL_SECOND_OFFSET = 0x21;
    public static final int PARTY_STAT_SIZE = 0x02;
    public static final int PARTY_MAX_HP_OFFSET = 0x22;
    public static final int PARTY_ATTACK_STAT_OFFSET = 0x24;
    public static final int PARTY_DEFENSE_STAT_OFFSET = 0x26;
    public static final int PARTY_SPEED_STAT_OFFSET = 0x28;
    public static final int PARTY_SPECIAL_STAT_OFFSET = 0x2A;


    //    String speciesName;
//    String nickName;
    int speciesIndex;
    int currentHP;
    int statusCondition;
//    Type type1;
//    Type type2;
    int catchRate;
    int move1;
    int move2;
    int move3;
    int move4;
    int originalTrainedID;
    int experiencePoints;
    int ev_hp;
    int ev_atk;
    int ev_def;
    int ev_special;
    int iv_data;
    int move1_pp;
    int move2_pp;
    int move3_pp;
    int move4_pp;
//    int level;
//    int max_hp;
//    int stat_atk;
//    int stat_def;
//    int stat_spd;
//    int stat_spec;

    public int calculatePartyPkmnOTOffset(int partyIndex){
        return (0x2C*(6-partyIndex)) + (0xB*(partyIndex));
    }

    public int calculatePartyPkmnNameOffset(int partyIndex){
        return ((0x2C+0xB)*(6-partyIndex)) + (0xB*(partyIndex)) + (0xB*(partyIndex));
    }

}
