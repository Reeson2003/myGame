package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;

import java.util.List;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class Stackable extends Item {
    protected int amount;
    protected Stackable(String name, String info, int price, int amount) {
        super(name, info, price);
        if (amount >= 0)
            this.amount = amount;
        else
            amount = 0;
    }

}
