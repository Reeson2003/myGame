package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;

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
    public Item(String name, String info, int price) {
        if(name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        if (price >=0)
            this.price = price;
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
            player.setItem(this);
            System.out.println("you picked up: " + this);
            return null;
        }else if (choise == 2) {
            System.out.println(info);
            List<Interactable> result = new LinkedList<>();
            result.add(this);
            return result;
        } else {
            System.out.println("Wrong number");
            List<Interactable> result = new LinkedList<>();
            result.add(this);
            return result;
        }
    }

}
