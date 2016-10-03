package ru.reeson2003.items;

import ru.reeson2003.map.Interactable;

/**
 * Created by Тоня on 03.10.2016.
 */
public abstract class Item implements Interactable{
    String name;
    String info;
    int price;
    int weight;

    protected Item(String name, String info, int price, int weight) {
        if(name != null)
            this.name = name;
        else
            this.name = "@NoName";
        if(info != null)
            this.info = info;
        else
            this.info = "@NoInfo";
        if(price >= 0)
            this.price = price;
        else
            this.price = 0;
        if(weight >= 0)
            this.weight = weight;
        else
            this.weight = 0;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getInfo() {
        return info;
    }
    int getPrice() {
        return price;
    }
    public int getWeight() {
        return weight;
    }

}
