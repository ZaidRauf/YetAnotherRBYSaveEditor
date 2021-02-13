package Model;

import Data.ItemKeys;

public class Item {
    private int itemID;
    private String itemName;
    private int itemCount;

    public Item(int id, String name, int count){
        itemID = id;
        itemName = name;
        itemCount = count;
    }

    public void setItemCount(int newAmount) {
        itemCount = newAmount;
    }

    public void setItem(String newItem) {
        itemName = newItem;
        itemID = ItemKeys.getItemIndex(newItem);
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
}
