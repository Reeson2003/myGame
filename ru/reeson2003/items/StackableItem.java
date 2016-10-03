package ru.reeson2003.items;

import ru.reeson2003.map.Position;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class StackableItem extends Item {
    protected int amount;
    protected StackableItem(String name, String info, int price, int amount, Position position) {
        super(name, info, price,position);
        if (amount >= 0)
            this.amount = amount;
        else
            this.amount = 0;
    }
    protected StackableItem(String name, String info, int price, int amount, Holder holder) {
        super(name, info, price,holder);
        if (amount >= 0)
            this.amount = amount;
        else
            this.amount = 0;
    }
}
