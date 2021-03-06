package Data;

import java.util.Map;

public class ItemKeys {
    public static String getItemString(int index){
        return itemIndexMap.get(index);
    }

    public static int getItemIndex(String itemName){
        return itemStringMap.get(itemName);
    }

    public static int numItems(){
        return itemIndexMap.size();
    }

    private static final Map<Integer, String> itemIndexMap = Map.ofEntries(
            Map.entry(1, "Master Ball"),
            Map.entry(2, "Ultra Ball"),
            Map.entry(3, "Great Ball"),
            Map.entry(4, "Poké Ball"),
            Map.entry(5, "Town Map"),
            Map.entry(6, "Bicycle"),
            Map.entry(8, "Safari Ball"),
            Map.entry(10, "Moon Stone"),
            Map.entry(11, "Antidote"),
            Map.entry(12, "Burn Heal"),
            Map.entry(13, "Ice Heal"),
            Map.entry(14, "Awakening"),
            Map.entry(15, "Parlyz Heal"),
            Map.entry(16, "Full Restore"),
            Map.entry(17, "Max Potion"),
            Map.entry(18, "Hyper Potion"),
            Map.entry(19, "Super Potion"),
            Map.entry(20, "Potion"),
            Map.entry(29, "Escape Rope"),
            Map.entry(30, "Repel"),
            Map.entry(31, "Old Amber"),
            Map.entry(32, "Fire Stone"),
            Map.entry(33, "Thunderstone"),
            Map.entry(34, "Water Stone"),
            Map.entry(35, "HP Up"),
            Map.entry(36, "Protein"),
            Map.entry(37, "Iron"),
            Map.entry(38, "Carbos"),
            Map.entry(39, "Calcium"),
            Map.entry(40, "Rare Candy"),
            Map.entry(41, "Dome Fossil"),
            Map.entry(42, "Helix Fossil"),
            Map.entry(43, "Secret Key"),
            Map.entry(45, "Bike Voucher"),
            Map.entry(46, "X Accuracy"),
            Map.entry(47, "Leaf Stone"),
            Map.entry(48, "Card Key"),
            Map.entry(49, "Nugget"),
            Map.entry(51, "Poké Doll"),
            Map.entry(52, "Full Heal"),
            Map.entry(53, "Revive"),
            Map.entry(54, "Max Revive"),
            Map.entry(55, "Guard Spec."),
            Map.entry(56, "Super Repel"),
            Map.entry(57, "Max Repel"),
            Map.entry(58, "Dire Hit"),
            Map.entry(59, "Coin"),
            Map.entry(60, "Fresh Water"),
            Map.entry(61, "Soda Pop"),
            Map.entry(62, "Lemonade"),
            Map.entry(63, "S.S. Ticket"),
            Map.entry(64, "Gold Teeth"),
            Map.entry(65, "X Attack"),
            Map.entry(66, "X Defend"),
            Map.entry(67, "X Speed"),
            Map.entry(68, "X Special"),
            Map.entry(69, "Coin Case"),
            Map.entry(70, "Oak's Parcel"),
            Map.entry(71, "Itemfinder"),
            Map.entry(72, "Silph Scope"),
            Map.entry(73, "Poké Flute"),
            Map.entry(74, "Lift Key"),
            Map.entry(75, "Exp. All"),
            Map.entry(76, "Old Rod"),
            Map.entry(77, "Good Rod"),
            Map.entry(78, "Super Rod"),
            Map.entry(79, "PP Up"),
            Map.entry(80, "Ether"),
            Map.entry(81, "Max Ether"),
            Map.entry(82, "Elixer"),
            Map.entry(83, "Max Elixer"),
            Map.entry(196, "HM01"),
            Map.entry(197, "HM02"),
            Map.entry(198, "HM03"),
            Map.entry(199, "HM04"),
            Map.entry(200, "HM05"),
            Map.entry(201, "TM01"),
            Map.entry(202, "TM02"),
            Map.entry(203, "TM03"),
            Map.entry(204, "TM04"),
            Map.entry(205, "TM05"),
            Map.entry(206, "TM06"),
            Map.entry(207, "TM07"),
            Map.entry(208, "TM08"),
            Map.entry(209, "TM09"),
            Map.entry(210, "TM10"),
            Map.entry(211, "TM11"),
            Map.entry(212, "TM12"),
            Map.entry(213, "TM13"),
            Map.entry(214, "TM14"),
            Map.entry(215, "TM15"),
            Map.entry(216, "TM16"),
            Map.entry(217, "TM17"),
            Map.entry(218, "TM18"),
            Map.entry(219, "TM19"),
            Map.entry(220, "TM20"),
            Map.entry(221, "TM21"),
            Map.entry(222, "TM22"),
            Map.entry(223, "TM23"),
            Map.entry(224, "TM24"),
            Map.entry(225, "TM25"),
            Map.entry(226, "TM26"),
            Map.entry(227, "TM27"),
            Map.entry(228, "TM28"),
            Map.entry(229, "TM29"),
            Map.entry(230, "TM30"),
            Map.entry(231, "TM31"),
            Map.entry(232, "TM32"),
            Map.entry(233, "TM33"),
            Map.entry(234, "TM34"),
            Map.entry(235, "TM35"),
            Map.entry(236, "TM36"),
            Map.entry(237, "TM37"),
            Map.entry(238, "TM38"),
            Map.entry(239, "TM39"),
            Map.entry(240, "TM40"),
            Map.entry(241, "TM41"),
            Map.entry(242, "TM42"),
            Map.entry(243, "TM43"),
            Map.entry(244, "TM44"),
            Map.entry(245, "TM45"),
            Map.entry(246, "TM46"),
            Map.entry(247, "TM47"),
            Map.entry(248, "TM48"),
            Map.entry(249, "TM49"),
            Map.entry(250, "TM50"),
            Map.entry(251, "TM51"),
            Map.entry(252, "TM52"),
            Map.entry(253, "TM53"),
            Map.entry(254, "TM54"),
            Map.entry(255, "TM55")
            );

    private static final Map<String, Integer> itemStringMap = Map.ofEntries(
            Map.entry("Master Ball", 1),
            Map.entry("Ultra Ball", 2),
            Map.entry("Great Ball", 3),
            Map.entry("Poké Ball", 4),
            Map.entry("Town Map", 5),
            Map.entry("Bicycle", 6),
            Map.entry("Safari Ball", 8),
            Map.entry("Pokédex", 9),
            Map.entry("Moon Stone", 10),
            Map.entry("Antidote", 11),
            Map.entry("Burn Heal", 12),
            Map.entry("Ice Heal", 13),
            Map.entry("Awakening", 14),
            Map.entry("Parlyz Heal", 15),
            Map.entry("Full Restore", 16),
            Map.entry("Max Potion", 17),
            Map.entry("Hyper Potion", 18),
            Map.entry("Super Potion", 19),
            Map.entry("Potion", 20),
            Map.entry("Escape Rope", 29),
            Map.entry("Repel", 30),
            Map.entry("Old Amber", 31),
            Map.entry("Fire Stone", 32),
            Map.entry("Thunderstone", 33),
            Map.entry("Water Stone", 34),
            Map.entry("HP Up", 35),
            Map.entry("Protein", 36),
            Map.entry("Iron", 37),
            Map.entry("Carbos", 38),
            Map.entry("Calcium", 39),
            Map.entry("Rare Candy", 40),
            Map.entry("Dome Fossil", 41),
            Map.entry("Helix Fossil", 42),
            Map.entry("Secret Key", 43),
            Map.entry("Bike Voucher", 45),
            Map.entry("X Accuracy", 46),
            Map.entry("Leaf Stone", 47),
            Map.entry("Card Key", 48),
            Map.entry("Nugget", 49),
            Map.entry("Poké Doll", 51),
            Map.entry("Full Heal", 52),
            Map.entry("Revive", 53),
            Map.entry("Max Revive", 54),
            Map.entry("Guard Spec.", 55),
            Map.entry("Super Repel", 56),
            Map.entry("Max Repel", 57),
            Map.entry("Dire Hit", 58),
            Map.entry("Coin", 59),
            Map.entry("Fresh Water", 60),
            Map.entry("Soda Pop", 61),
            Map.entry("Lemonade", 62),
            Map.entry("S.S. Ticket", 63),
            Map.entry("Gold Teeth", 64),
            Map.entry("X Attack", 65),
            Map.entry("X Defend", 66),
            Map.entry("X Speed", 67),
            Map.entry("X Special", 68),
            Map.entry("Coin Case", 69),
            Map.entry("Oak's Parcel", 70),
            Map.entry("Itemfinder", 71),
            Map.entry("Silph Scope", 72),
            Map.entry("Poké Flute", 73),
            Map.entry("Lift Key", 74),
            Map.entry("Exp. All", 75),
            Map.entry("Old Rod", 76),
            Map.entry("Good Rod", 77),
            Map.entry("Super Rod", 78),
            Map.entry("PP Up", 79),
            Map.entry("Ether", 80),
            Map.entry("Max Ether", 81),
            Map.entry("Elixer", 82),
            Map.entry("Max Elixer", 83),
            Map.entry("HM01", 196),
            Map.entry("HM02", 197),
            Map.entry("HM03", 198),
            Map.entry("HM04", 199),
            Map.entry("HM05", 200),
            Map.entry("TM01", 201),
            Map.entry("TM02", 202),
            Map.entry("TM03", 203),
            Map.entry("TM04", 204),
            Map.entry("TM05", 205),
            Map.entry("TM06", 206),
            Map.entry("TM07", 207),
            Map.entry("TM08", 208),
            Map.entry("TM09", 209),
            Map.entry("TM10", 210),
            Map.entry("TM11", 211),
            Map.entry("TM12", 212),
            Map.entry("TM13", 213),
            Map.entry("TM14", 214),
            Map.entry("TM15", 215),
            Map.entry("TM16", 216),
            Map.entry("TM17", 217),
            Map.entry("TM18", 218),
            Map.entry("TM19", 219),
            Map.entry("TM20", 220),
            Map.entry("TM21", 221),
            Map.entry("TM22", 222),
            Map.entry("TM23", 223),
            Map.entry("TM24", 224),
            Map.entry("TM25", 225),
            Map.entry("TM26", 226),
            Map.entry("TM27", 227),
            Map.entry("TM28", 228),
            Map.entry("TM29", 229),
            Map.entry("TM30", 230),
            Map.entry("TM31", 231),
            Map.entry("TM32", 232),
            Map.entry("TM33", 233),
            Map.entry("TM34", 234),
            Map.entry("TM35", 235),
            Map.entry("TM36", 236),
            Map.entry("TM37", 237),
            Map.entry("TM38", 238),
            Map.entry("TM39", 239),
            Map.entry("TM40", 240),
            Map.entry("TM41", 241),
            Map.entry("TM42", 242),
            Map.entry("TM43", 243),
            Map.entry("TM44", 244),
            Map.entry("TM45", 245),
            Map.entry("TM46", 246),
            Map.entry("TM47", 247),
            Map.entry("TM48", 248),
            Map.entry("TM49", 249),
            Map.entry("TM50", 250),
            Map.entry("TM51", 251),
            Map.entry("TM52", 252),
            Map.entry("TM53", 253),
            Map.entry("TM54", 254),
            Map.entry("TM55", 255)
    );
}
