package ru.reeson2003.items;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class StackableItem extends Item {
    protected int amount;
    protected StackableItem(String name, String info, int price, int amount) {
        super(name, info, price);
        if (amount >= 0)
            this.amount = amount;
        else
            this.amount = 0;
    }
}
