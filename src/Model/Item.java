package Model;

public class Item {
    private int itemID;
    private String itemName;
    private int itemCount;

    public Item(int id, String name, int count){
        itemID = id;
        itemName = name;
        itemCount = count;
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
