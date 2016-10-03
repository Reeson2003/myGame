package ru.reeson2003.items;


import ru.reeson2003.map.Interactable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тоня on 02.10.2016.
 */
public class Storage extends Item{
    int size;
    int totalWeight;
    int totalPrice;
    List<Item> items;

    public Storage(String name, String info, int price, int weight, int size) {
        super(name,info,price,weight);
        if(size >= 0)
            this.size = size;
        else {
            throw new IllegalArgumentException("Size must be more or equals 0");
        }
        totalPrice = this.price;
        totalWeight = this.weight;
        items = new ArrayList<>(size*16/10);
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public boolean addItemWithCheck(Item item) {
        if(items.size() >= size)
            return false;
        else {
            items.add(item);
            return true;
        }
    }
    public Item getItem(int n) {
        if (n < 0 || n >= items.size()) {
            throw new IllegalArgumentException("No item with this index");
        } else {
            Item result = items.get(n);
            items.remove(n);
            return result;
        }
    }
    public void removeItem(int n) {
        if (n < 0 || n >= items.size()) {
            throw new IllegalArgumentException("No item with this index");
        } else {
            items.remove(n);
        }
    }

    String[] getItemsNames()

    @Override
    public List<Interactable> interact(Interactable something) {
        return null;
    }
}
