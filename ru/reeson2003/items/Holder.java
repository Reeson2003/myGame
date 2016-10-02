package ru.reeson2003.items;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 02.10.2016.
 */
public abstract class Holder extends Item {
    protected List<Item> itemList;

    protected Holder(String name, String info, int price) {
        super(name, info, price);
        itemList = new LinkedList<>();
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public Item remove(int number) {
        if (number > 0 && number <= itemList.size()) {
            Item result = itemList.get(number-1);
            itemList.remove(result);
            return result;
        } else
            throw new IllegalArgumentException("This contains " + itemList.size() + " Items");
    }

    public String[] takeContent() {
        String[] result = new String[itemList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(i + "-" + itemList.get(i).getInfo());
        }
        return result;
    }
}
