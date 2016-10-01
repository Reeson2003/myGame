package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;

import java.util.List;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Gold extends Item {
    private int amount = 0;

    public Gold(int amount) {
        super("Gold","Золото",1);
        if (amount >=0)
            this.amount = amount;
    }

    public void addGold(Gold another) {
        this.amount += another.amount;
        another.amount = 0;
    }

    public Gold removeGold(int value) {
        Gold result = new Gold(value);
        this.amount -= value;
        return result;
    }

    @Override
    public String getInfo() {
        return new String(name + ": " + amount);
    }

    @Override
    public List<Interactable> interact(Interactable player) {
        System.out.println(getInfo());
        Player p = null;
        if (player instanceof Player)
            p = (Player) player;
        p.getGold().addGold(this);
        return null;
    }
}
