package Data;

import java.util.Map;

public class Type {
    private static final Map<Integer, String> typeMap = Map.ofEntries(
            Map.entry(0x00, "Normal"),
            Map.entry(0x01, "Fighting"),
            Map.entry(0x02, "Flying"),
            Map.entry(0x03, "Poison"),
            Map.entry(0x04, "Ground"),
            Map.entry(0x05, "Rock"),
            Map.entry(0x07, "Bug"),
            Map.entry(0x08, "Ghost"),
            Map.entry(0x14, "Fire"),
            Map.entry(0x15, "Water"),
            Map.entry(0x16, "Grass"),
            Map.entry(0x17, "Electric"),
            Map.entry(0x18, "Psychic"),
            Map.entry(0x19, "Ice"),
            Map.entry(0x1A, "Dragon")
    );

    private int typeValue;
    private String typeStr;

    public Type(int typeVal){
        typeValue = typeVal;
        typeStr = translateTypeVal(typeValue);
    }

    public String getTypeStr(){
        return typeStr;
    }

    public int getTypeValue(){
        return typeValue;
    }

    public void changeType(int typeVal){
        typeValue = typeVal;
        typeStr = translateTypeVal(typeValue);
    }

    public static String translateTypeVal(int typeVal) {
        return typeMap.get(typeVal);
    }
}
