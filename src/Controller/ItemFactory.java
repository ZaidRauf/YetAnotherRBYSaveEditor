package Controller;

import Data.ItemKeys;
import Model.Item;

public class ItemFactory {
    public static Item generateItem(int itemIndex, int itemCount){
        return new Item(itemIndex, ItemKeys.getItemString(itemIndex), itemCount);
    }
}
