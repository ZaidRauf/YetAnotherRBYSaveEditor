package Model;

public class PokemonUtilities {
    public static void readPartyPokemon(byte[] saveDataArray, int startOffset){
        byte pokemonIndex = saveDataArray[startOffset + Pokemon.INDEX_OFFSET];
        int currentHP = (((int) saveDataArray[startOffset + Pokemon.CURRENT_HP_OFFSET]) << 8) + saveDataArray[startOffset + Pokemon.CURRENT_HP_OFFSET + 1];
        byte level = saveDataArray[startOffset + Pokemon.STATUS_CONDITION_OFFSET];

        System.out.println(pokemonIndex);

    }

}
