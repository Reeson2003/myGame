package ru.reeson2003.Game.model.items;

import ru.reeson2003.Game.model.tools.Interactable;
import ru.reeson2003.Game.model.map.Position;

/**
 * Created by Тоня on 03.10.2016.
 */
public abstract class Item implements Interactable{
    Position position;
    Storage storage;
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
        this.position = null;
        this.storage = null;
    }
    protected Item(String name, String info, int price, int weight,Position position) {
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
        this.position = position;
        this.storage = null;
        position.addObject(this);

    }
    protected Item(String name, String info, int price, int weight,Storage storage) {
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
        this.storage = storage;
        this.position = null;
        storage.addItem(this);
    }

    public void setStorage(Storage storage) {
        if (position == null) {
            this.storage = storage;
            storage.addItem(this);
        } else {
            position.removeObject(this);
            storage.addItem(this);
            this.storage = storage;
        }
    }
    public void setPosition(Position position) {
        if (this.storage == null) {
            this.position = position;
            position.addObject(this);
        } else {
            storage.removeItem(this);
            this.position = position;
            position.addObject(this);
        }
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
