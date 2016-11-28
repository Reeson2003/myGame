package ru.reeson2003.Game.model.items;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Тоня on 02.10.2016.
 */
public class Storage extends Item{
    protected  int size;
    protected int totalWeight;
    protected int totalPrice;
    protected List<Item> items;

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
            totalWeight -= items.get(n).weight;
            totalPrice -= items.get(n).price;
            items.remove(n);
            return result;
        }
    }
    public void removeItem(int n) {
        if (n < 0 || n >= items.size()) {
            throw new IllegalArgumentException("No item with this index");
        } else {
            totalWeight -= items.get(n).weight;
            totalPrice -= items.get(n).price;
            items.remove(n);
        }
    }
    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public int getTotalWeight() {
        return totalWeight;
    }
    String[] getItemsNames() {
        String[] result = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            result[i] = items.get(i).getName();
        }
        return result;
    }
    String[] getItemsInfos() {
        String[] result = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            result[i] = items.get(i).getInfo();
        }
        return result;
    }
    int[] getItemsPrices() {
        int[] result = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            result[i] = items.get(i).getPrice();
        }
        return result;
    }
    int[] getItemsWeights() {
        int[] result = new int[items.size()];
        for (int i = 0; i < items.size(); i++) {
            result[i] = items.get(i).getWeight();
        }
        return result;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void interact() {

    }
}
