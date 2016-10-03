package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Item implements Interactable, Serializable{
    protected String name = "";
    protected String info = "";
    protected int price = 0;
    protected Position position;
    protected Holder holder;

    public Item(String name, String info, int price, Position position) {
        if(name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        if (price >=0)
            this.price = price;
        this.position = position;
        position.addItem(this);
    }
    public Item(String name, String info, int price, Holder holder) {
        if(name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        if (price >=0)
            this.price = price;
        this.holder = holder;
        holder.add(this);
    }

    public void setPosition(Position position) {
        this.position.deleteItem(this);
        position.addItem(this);
    }
    public void setHolder(Holder holder) {
        this.holder.remove(this);
        holder.add(this);
    }

    @Override
    public String getInfo() {
        return name;
    }
    @Override
    public List<Interactable> interact(Interactable something) {
        if (something instanceof Player) {
            Player player = (Player) something;
            return interact_0_1(player);
        } else {
            throw new IllegalArgumentException("No method for this item: " + something);
        }
    }

    private List<Interactable> interact_0_1(Player player) {
        System.out.println("Enter number:\n1-pick up\n2-look info");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        if (choise == 1) {
            return pickUp(player);
        }else if (choise == 2) {
            return lookInfo(player);
        } else {
            return wrongNumberMessage(player);
        }
    }
    protected List<Interactable> pickUp(Player player) {
        Item item = player.pickUp(this);
        if (item == null) {
            return null;
        }
        else {
            List<Interactable> result = new LinkedList<>();
            result.add(item);
            return result;
        }
    }
    protected List<Interactable> lookInfo(Player player) {
        System.out.println(info);
        List<Interactable> result = new LinkedList<>();
        result.add(this);
        return result;
    }
    protected List<Interactable> wrongNumberMessage(Player player) {
        System.out.println("Wrong number");
        List<Interactable> result = new LinkedList<>();
        result.add(this);
        return result;
    }

}
