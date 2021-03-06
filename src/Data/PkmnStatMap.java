package Data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PkmnStatMap {

    private static final Map<String, int[]> pkmnIndexMap = Map.ofEntries(
            Map.entry("Bulbasaur", new int[] {1,45,49,49,45,65}),
            Map.entry("Ivysaur", new int[] {2,60,62,63,60,80}),
            Map.entry("Venusaur", new int[] {3,80,82,83,80,100}),
            Map.entry("Charmander", new int[] {4,39,52,43,65,50}),
            Map.entry("Charmeleon", new int[] {5,58,64,58,80,65}),
            Map.entry("Charizard", new int[] {6,78,84,78,100,85}),
            Map.entry("Squirtle", new int[] {7,44,48,65,43,50}),
            Map.entry("Wartortle", new int[] {8,59,63,80,58,65}),
            Map.entry("Blastoise", new int[] {9,79,83,100,78,85}),
            Map.entry("Caterpie", new int[] {10,45,30,35,45,20}),
            Map.entry("Metapod", new int[] {11,50,20,55,30,25}),
            Map.entry("Butterfree", new int[] {12,60,45,50,70,80}),
            Map.entry("Weedle", new int[] {13,40,35,30,50,20}),
            Map.entry("Kakuna", new int[] {14,45,25,50,35,25}),
            Map.entry("Beedrill", new int[] {15,65,80,40,75,45}),
            Map.entry("Pidgey", new int[] {16,40,45,40,56,35}),
            Map.entry("Pidgeotto", new int[] {17,63,60,55,71,50}),
            Map.entry("Pidgeot", new int[] {18,83,80,75,91,70}),
            Map.entry("Rattata", new int[] {19,30,56,35,72,25}),
            Map.entry("Raticate", new int[] {20,55,81,60,97,50}),
            Map.entry("Spearow", new int[] {21,40,60,30,70,31}),
            Map.entry("Fearow", new int[] {22,65,90,65,100,61}),
            Map.entry("Ekans", new int[] {23,35,60,44,55,40}),
            Map.entry("Arbok", new int[] {24,60,85,69,80,65}),
            Map.entry("Pikachu", new int[] {25,35,55,30,90,50}),
            Map.entry("Raichu", new int[] {26,60,90,55,100,90}),
            Map.entry("Sandshrew", new int[] {27,50,75,85,40,30}),
            Map.entry("Sandslash", new int[] {28,75,100,110,65,55}),
            Map.entry("Nidoran♀", new int[] {29,55,47,52,41,40}),
            Map.entry("Nidorina", new int[] {30,70,62,67,56,55}),
            Map.entry("Nidoqueen", new int[] {31,90,82,87,76,75}),
            Map.entry("Nidoran♂", new int[] {32,46,57,40,50,40}),
            Map.entry("Nidorino", new int[] {33,61,72,57,65,55}),
            Map.entry("Nidoking", new int[] {34,81,92,77,85,75}),
            Map.entry("Clefairy", new int[] {35,70,45,48,35,60}),
            Map.entry("Clefable", new int[] {36,95,70,73,60,85}),
            Map.entry("Vulpix", new int[] {37,38,41,40,65,65}),
            Map.entry("Ninetales", new int[] {38,73,76,75,100,100}),
            Map.entry("Jigglypuff", new int[] {39,115,45,20,20,25}),
            Map.entry("Wigglytuff", new int[] {40,140,70,45,45,50}),
            Map.entry("Zubat", new int[] {41,40,45,35,55,40}),
            Map.entry("Golbat", new int[] {42,75,80,70,90,75}),
            Map.entry("Oddish", new int[] {43,45,50,55,30,75}),
            Map.entry("Gloom", new int[] {44,60,65,70,40,85}),
            Map.entry("Vileplume", new int[] {45,75,80,85,50,100}),
            Map.entry("Paras", new int[] {46,35,70,55,25,55}),
            Map.entry("Parasect", new int[] {47,60,95,80,30,80}),
            Map.entry("Venonat", new int[] {48,60,55,50,45,40}),
            Map.entry("Venomoth", new int[] {49,70,65,60,90,90}),
            Map.entry("Diglett", new int[] {50,10,55,25,95,45}),
            Map.entry("Dugtrio", new int[] {51,35,80,50,120,70}),
            Map.entry("Meowth", new int[] {52,40,45,35,90,40}),
            Map.entry("Persian", new int[] {53,65,70,60,115,65}),
            Map.entry("Psyduck", new int[] {54,50,52,48,55,50}),
            Map.entry("Golduck", new int[] {55,80,82,78,85,80}),
            Map.entry("Mankey", new int[] {56,40,80,35,70,35}),
            Map.entry("Primeape", new int[] {57,65,105,60,95,60}),
            Map.entry("Growlithe", new int[] {58,55,70,45,60,50}),
            Map.entry("Arcanine", new int[] {59,90,110,80,95,80}),
            Map.entry("Poliwag", new int[] {60,40,50,40,90,40}),
            Map.entry("Poliwhirl", new int[] {61,65,65,65,90,50}),
            Map.entry("Poliwrath", new int[] {62,90,85,95,70,70}),
            Map.entry("Abra", new int[] {63,25,20,15,90,105}),
            Map.entry("Kadabra", new int[] {64,40,35,30,105,120}),
            Map.entry("Alakazam", new int[] {65,55,50,45,120,135}),
            Map.entry("Machop", new int[] {66,70,80,50,35,35}),
            Map.entry("Machoke", new int[] {67,80,100,70,45,50}),
            Map.entry("Machamp", new int[] {68,90,130,80,55,65}),
            Map.entry("Bellsprout", new int[] {69,50,75,35,40,70}),
            Map.entry("Weepinbell", new int[] {70,65,90,50,55,85}),
            Map.entry("Victreebel", new int[] {71,80,105,65,70,100}),
            Map.entry("Tentacool", new int[] {72,40,40,35,70,100}),
            Map.entry("Tentacruel", new int[] {73,80,70,65,100,120}),
            Map.entry("Geodude", new int[] {74,40,80,100,20,30}),
            Map.entry("Graveler", new int[] {75,55,95,115,35,45}),
            Map.entry("Golem", new int[] {76,80,110,130,45,55}),
            Map.entry("Ponyta", new int[] {77,50,85,55,90,65}),
            Map.entry("Rapidash", new int[] {78,65,100,70,105,80}),
            Map.entry("Slowpoke", new int[] {79,90,65,65,15,40}),
            Map.entry("Slowbro", new int[] {80,95,75,110,30,80}),
            Map.entry("Magnemite", new int[] {81,25,35,70,45,95}),
            Map.entry("Magneton", new int[] {82,50,60,95,70,120}),
            Map.entry("Farfetch'd", new int[] {83,52,65,55,60,58}),
            Map.entry("Doduo", new int[] {84,35,85,45,75,35}),
            Map.entry("Dodrio", new int[] {85,60,110,70,100,60}),
            Map.entry("Seel", new int[] {86,65,45,55,45,70}),
            Map.entry("Dewgong", new int[] {87,90,70,80,70,95}),
            Map.entry("Grimer", new int[] {88,80,80,50,25,40}),
            Map.entry("Muk", new int[] {89,105,105,75,50,65}),
            Map.entry("Shellder", new int[] {90,30,65,100,40,45}),
            Map.entry("Cloyster", new int[] {91,50,95,180,70,85}),
            Map.entry("Gastly", new int[] {92,30,35,30,80,100}),
            Map.entry("Haunter", new int[] {93,45,50,45,95,115}),
            Map.entry("Gengar", new int[] {94,60,65,60,110,130}),
            Map.entry("Onix", new int[] {95,35,45,160,70,30}),
            Map.entry("Drowzee", new int[] {96,60,48,45,42,90}),
            Map.entry("Hypno", new int[] {97,85,73,70,67,115}),
            Map.entry("Krabby", new int[] {98,30,105,90,50,25}),
            Map.entry("Kingler", new int[] {99,55,130,115,75,50}),
            Map.entry("Voltorb", new int[] {100,40,30,50,100,55}),
            Map.entry("Electrode", new int[] {101,60,50,70,140,80}),
            Map.entry("Exeggcute", new int[] {102,60,40,80,40,60}),
            Map.entry("Exeggutor", new int[] {103,95,95,85,55,125}),
            Map.entry("Cubone", new int[] {104,50,50,95,35,40}),
            Map.entry("Marowak", new int[] {105,60,80,110,45,50}),
            Map.entry("Hitmonlee", new int[] {106,50,120,53,87,35}),
            Map.entry("Hitmonchan", new int[] {107,50,105,79,76,35}),
            Map.entry("Lickitung", new int[] {108,90,55,75,30,60}),
            Map.entry("Koffing", new int[] {109,40,65,95,35,60}),
            Map.entry("Weezing", new int[] {110,65,90,120,60,85}),
            Map.entry("Rhyhorn", new int[] {111,80,85,95,25,30}),
            Map.entry("Rhydon", new int[] {112,105,130,120,40,45}),
            Map.entry("Chansey", new int[] {113,250,5,5,50,105}),
            Map.entry("Tangela", new int[] {114,65,55,115,60,100}),
            Map.entry("Kangaskhan", new int[] {115,105,95,80,90,40}),
            Map.entry("Horsea", new int[] {116,30,40,70,60,70}),
            Map.entry("Seadra", new int[] {117,55,65,95,85,95}),
            Map.entry("Goldeen", new int[] {118,45,67,60,63,50}),
            Map.entry("Seaking", new int[] {119,80,92,65,68,80}),
            Map.entry("Staryu", new int[] {120,30,45,55,85,70}),
            Map.entry("Starmie", new int[] {121,60,75,85,115,100}),
            Map.entry("Mime", new int[] {122,40,45,65,90,100}),
            Map.entry("Scyther", new int[] {123,70,110,80,105,55}),
            Map.entry("Jynx", new int[] {124,65,50,35,95,95}),
            Map.entry("Electabuzz", new int[] {125,65,83,57,105,85}),
            Map.entry("Magmar", new int[] {126,65,95,57,93,85}),
            Map.entry("Pinsir", new int[] {127,65,125,100,85,55}),
            Map.entry("Tauros", new int[] {128,75,100,95,110,70}),
            Map.entry("Magikarp", new int[] {129,20,10,55,80,20}),
            Map.entry("Gyarados", new int[] {130,95,125,79,81,100}),
            Map.entry("Lapras", new int[] {131,130,85,80,60,95}),
            Map.entry("Ditto", new int[] {132,48,48,48,48,48}),
            Map.entry("Eevee", new int[] {133,55,55,50,55,65}),
            Map.entry("Vaporeon", new int[] {134,130,65,60,65,110}),
            Map.entry("Jolteon", new int[] {135,65,65,60,130,110}),
            Map.entry("Flareon", new int[] {136,65,130,60,65,110}),
            Map.entry("Porygon", new int[] {137,65,60,70,40,75}),
            Map.entry("Omanyte", new int[] {138,35,40,100,35,90}),
            Map.entry("Omastar", new int[] {139,70,60,125,55,115}),
            Map.entry("Kabuto", new int[] {140,30,80,90,55,45}),
            Map.entry("Kabutops", new int[] {141,60,115,105,80,70}),
            Map.entry("Aerodactyl", new int[] {142,80,105,65,130,60}),
            Map.entry("Snorlax", new int[] {143,160,110,65,30,65}),
            Map.entry("Articuno", new int[] {144,90,85,100,85,125}),
            Map.entry("Zapdos", new int[] {145,90,90,85,100,125}),
            Map.entry("Moltres", new int[] {146,90,100,90,90,125}),
            Map.entry("Dratini", new int[] {147,41,64,45,50,50}),
            Map.entry("Dragonair", new int[] {148,61,84,65,70,70}),
            Map.entry("Dragonite", new int[] {149,91,134,95,80,100}),
            Map.entry("Mewtwo", new int[] {150,106,110,90,130,154}),
            Map.entry("Mew", new int[] {151,100,100,100,100,100})
            );
}
