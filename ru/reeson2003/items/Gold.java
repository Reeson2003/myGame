package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Gold extends StackableItem {
    private static long globalAmount = 0;
    public Gold(int amount) {
        super("Gold","Золото",1,0);
        if (amount >=0)
            this.amount = amount;
        globalAmount += amount;
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
    public List<Interactable> interact(Interactable something) {
        if (something instanceof Player) {
            Player player = (Player) something;
            return interact_0_1(player);
        } else {
            throw new IllegalArgumentException("No method for this item: " + something);
        }
    }
    List<Interactable> interact_0_1(Player player) {
        System.out.println("Enter number:\n1-pick up\n2-look info");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        if (choise == 1) {
            player.getGold().addGold(this);
            System.out.println("global gold: " + globalAmount);
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
