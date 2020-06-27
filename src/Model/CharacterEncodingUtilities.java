package Model;

import java.util.HashMap;
import java.util.Map;

public class CharacterEncodingUtilities {
    private static final byte startUpperCaseLetters = (byte) 0x80;
    private static final byte startLowerCaseLetters = (byte) 0xA0;
    private static final int PKMN_NULL_TERMINATOR_CHARACTER = 0x50;

    private static final Map<Character, Byte> specialCharacterByteMap = Map.ofEntries(
            Map.entry('(', (byte) 0x9A),
            Map.entry(')', (byte) 0x9B),
            Map.entry(':', (byte) 0x9C),
            Map.entry(';', (byte) 0x9D),
            Map.entry('[', (byte) 0x9E),
            Map.entry(']', (byte) 0x9F),
            Map.entry('1', (byte) 0xE1), //PK
            Map.entry('2', (byte) 0xE2), //MN
            Map.entry('-', (byte) 0xE3),
            Map.entry('?', (byte) 0xE6),
            Map.entry('!', (byte) 0xE7),
            Map.entry('3', (byte) 0xEF), //Male Logo
            Map.entry('4', (byte) 0xF1), //x
            Map.entry('.', (byte) 0xF2),
            Map.entry('/', (byte) 0xF3),
            Map.entry(',', (byte) 0xF4),
            Map.entry('5', (byte) 0xF5) //Female Logo
    );

    public static byte[] stringToEncodedCharByteArray(String nameString){
        int encodedByteArrayLength = nameString.length();
        byte[] encodedByteArray = new byte[encodedByteArrayLength + 1];

        for (int k = 0; k < encodedByteArrayLength; k++){
            char character = nameString.charAt(k);

            if(Character.isAlphabetic(character)){
                encodedByteArray[k] = alphaCharToEncodedByte(character);
            }

            else{
                encodedByteArray[k] = specialCharToEncodedByte(character);
            }
        }

        encodedByteArray[encodedByteArrayLength] = PKMN_NULL_TERMINATOR_CHARACTER;
        return encodedByteArray;
    }

    private static Byte alphaCharToEncodedByte(char character){
        byte charStart;
        byte characterOffset;

        if(Character.isUpperCase(character)){
            charStart = startUpperCaseLetters;
            characterOffset = (byte) (character - 'A');
        }

        else{
            charStart = startLowerCaseLetters;
            characterOffset = (byte) (character - 'a');
        }

        return (byte) (charStart + characterOffset);
    }

    private static byte specialCharToEncodedByte(char character){
        return specialCharacterByteMap.get(character);
    }


}
