package ru.reeson2003.items;


/**
 * Created by Тоня on 01.10.2016.
 */
public class Gold extends ItemPacket{

    protected Gold(int amount) {
        super("Gold", "Gold", 1, 0, amount);
    }

    public void add(Gold gold) {
        super.add(gold);
    }

    public Gold get(int amount) {
        if (super.checkGet(amount)) {
            return new Gold(amount);
        } else {
            throw new IllegalArgumentException("There is only " + this.amount + " gold");
        }
    }
}
