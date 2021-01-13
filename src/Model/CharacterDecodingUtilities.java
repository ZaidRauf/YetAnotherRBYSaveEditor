package Model;

import java.util.Map;

public class CharacterDecodingUtilities {

    private static final byte startUpperCaseLetters = (byte) 0x80;
    private static final byte endUpperCaseLetters = (byte) 0x99;
    private static final byte startLowerCaseLetters = (byte) 0xA0;
    private static final byte endLowerCaseLetters = (byte) 0xB9;
    private static final byte specialCharStart = (byte) 0x9A;
    private static final byte specialCharEnd = (byte) 0x9F;

    private static final int PKMN_NULL_TERMINATOR_CHARACTER = 0x50;

    private static final Map<Byte, Character> specialByteCharacterMap = Map.ofEntries(
            Map.entry((byte) 0x7F, ' '),
            Map.entry((byte) 0x9A, '('),
            Map.entry((byte) 0x9B, ')'),
            Map.entry((byte) 0x9C, ':'),
            Map.entry((byte) 0x9D, ';'),
            Map.entry((byte) 0x9E, '['),
            Map.entry((byte) 0x9F, ']'),
            Map.entry((byte) 0xE1, '1'), //Pk
            Map.entry((byte) 0xE2, '2'),//Mn
            Map.entry((byte) 0xE3, '-'),
            Map.entry((byte) 0xE6, '?'),
            Map.entry((byte) 0xE7, '!'),
            Map.entry((byte) 0xEF, '3'), //Male Logo
            Map.entry((byte) 0xF1, '4'), //x
            Map.entry((byte) 0xF2, '.'),
            Map.entry((byte) 0xF3, '/'),
            Map.entry((byte) 0xF4, ','),
            Map.entry((byte) 0xF5, '5') //Female Logo
    );


    public static String decodeName(byte[] saveGameData, int memAddress){

        StringBuilder stringBuilder = new StringBuilder();

        int indirection = 0;
        byte currentByte = saveGameData[memAddress];

        while(currentByte != PKMN_NULL_TERMINATOR_CHARACTER){
            stringBuilder.append(encodedByteToAlphaChar(currentByte));
            indirection++;
            currentByte = saveGameData[memAddress+indirection];

        }

        return stringBuilder.toString();

    }

    private static char encodedByteToAlphaChar(int encodedByte){

        char decodedChar = '*';
        int charInt;

        if(encodedByte >= startUpperCaseLetters && encodedByte <= endUpperCaseLetters){
            int characterOffset = encodedByte - startUpperCaseLetters;
            charInt = characterOffset + 'A';
            decodedChar = (char) charInt;
            return decodedChar;

        }

        else if(encodedByte >= startLowerCaseLetters && encodedByte <= endLowerCaseLetters){
            int characterOffset = encodedByte - startLowerCaseLetters ;
            charInt = characterOffset + 'a';
            decodedChar = (char) charInt;
            return decodedChar;
        }

        else if (specialByteCharacterMap.containsKey((byte) encodedByte)){
            decodedChar = specialByteToSpecialChar((byte) encodedByte);
            return decodedChar;
        }

        return decodedChar;

    }

    private static char specialByteToSpecialChar(byte charByte){
        return specialByteCharacterMap.get(charByte);
    }


}
