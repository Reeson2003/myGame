package ru.reeson2003.chars;

import ru.reeson2003.items.Gold;
import ru.reeson2003.items.Item;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Player extends Creature {
    private Gold gold;

    private Item item;

    public Player(String name, String info, Position position) {
        super(name,info,position);
        gold = new Gold(0);
        item = null;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Gold getGold() {
        return gold;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String getInfo() {
        return name;
    }

    @Override
    public List<Interactable> interact(Interactable player) {
        System.out.println(info);
        List<Interactable> result = new LinkedList<>();
        result.add(this);
        return result;
    }
}
