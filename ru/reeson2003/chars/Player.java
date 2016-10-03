package ru.reeson2003.chars;

import ru.reeson2003.items.Gold;
import ru.reeson2003.items.Item;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Player extends Creature {
    private Gold gold;

    private Item item;

    public Player(String name, String info, Position position) {
        super(name,info,position);
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

    private Item dropOrNo(Item item) {
        System.out.println("remove: " + item + "? Y/N");
        Scanner scanner = new Scanner(System.in);
        String choise = scanner.nextLine();
        if (choise.equals("Y") || choise.equals("y")) {
            Item result = this.item;
            this.item = item;
            return result;
        } else if (choise.equals("N") || choise.equals("n")) {
            return item;
        } else {
            System.out.println("Wrong answer");
            return item;
        }
    }

    @Override
    public String getInfo() {
        return name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Interactable> interact(Interactable player) {
        System.out.println(info);
        List<Interactable> result = new LinkedList<>();
        result.add(this);
        return result;
    }
}
