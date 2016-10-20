package ru.reeson2003.items;


/**
 * Created by Тоня on 01.10.2016.
 */
public class ItemPacket extends Item{
    int amount;
    int elementPrice;
    int elementWeight;

    protected ItemPacket(String name, String info, int price, int weight, int amount) {
        super(name, info, 0, 0);
        if (amount >= 0)
            this.amount = amount;
        else
            this.amount = 0;
        if (price >= 0)
            elementPrice = price;
        else
            elementPrice = 0;
        if (weight >= 0)
            elementWeight = price;
        else
            elementWeight = 0;
        this.price = elementPrice*amount;
    }

    public int getElementPrice() {
        return elementPrice;
    }
    public int getElementWeight() {
        return elementWeight;
    }

    protected void add(ItemPacket itemPacket) {
        this.price += itemPacket.price;
        this.weight += itemPacket.weight;
        this.amount += itemPacket.amount;
    }
    protected boolean checkGet(int amount) {
        if (amount <= this.amount) {
            ItemPacket result = new ItemPacket(name, info, elementPrice, elementWeight, amount);
            this.amount -= amount;
            this.price -= amount * elementPrice;
            this.weight -= amount * elementWeight;
            return true;
        }else {
            return false;
        }
    }
    public int getAmount() {
        return amount;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void interact() {
        //реализовать тут
    }
}
