package Model;

import java.util.HashMap;
import java.util.Map;

public class CharacterEncodingUtilities {
    private static final int PKMN_NULL_TERMINATOR_CHARACTER = 0x50;
    private static final Map<Character, Byte> characterByteMap = Map.ofEntries(
            Map.entry('A', (byte) 0x80),
            Map.entry('B', (byte) 0x81),
            Map.entry('C', (byte) 0x82),
            Map.entry('D', (byte) 0x83),
            Map.entry('E', (byte) 0x84),
            Map.entry('F', (byte) 0x85),
            Map.entry('G', (byte) 0x86),
            Map.entry('H', (byte) 0x87),
            Map.entry('I', (byte) 0x88),
            Map.entry('J', (byte) 0x89),
            Map.entry('K', (byte) 0x8A),
            Map.entry('L', (byte) 0x8B),
            Map.entry('M', (byte) 0x8C),
            Map.entry('N', (byte) 0x8D),
            Map.entry('O', (byte) 0x8E),
            Map.entry('P', (byte) 0x8F),
            Map.entry('Q', (byte) 0x90),
            Map.entry('R', (byte) 0x91),
            Map.entry('S', (byte) 0x92),
            Map.entry('T', (byte) 0x93),
            Map.entry('U', (byte) 0x94),
            Map.entry('V', (byte) 0x95),
            Map.entry('W', (byte) 0x96),
            Map.entry('X', (byte) 0x97),
            Map.entry('Y', (byte) 0x98),
            Map.entry('Z', (byte) 0x99)
    );

    public static byte[] stringToEncodedCharByteArray(String nameString){
        int encodedByteArrayLength = nameString.length();
        byte[] encodedByteArray = new byte[encodedByteArrayLength + 1];

        for (int k = 0; k < encodedByteArrayLength; k++){
            encodedByteArray[k] = charToEncodedByte(nameString.charAt(k));
        }

        encodedByteArray[encodedByteArrayLength] = PKMN_NULL_TERMINATOR_CHARACTER;

        return encodedByteArray;
    }

    private static Byte charToEncodedByte(char character){
        return characterByteMap.get(character);
    }

}
