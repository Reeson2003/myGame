package ru.reeson2003.items;

import ru.reeson2003.chars.Player;
import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 02.10.2016.
 */
public class Holder extends Item {
    protected List<Item> itemList;

    public Holder(String name, String info, int price, Position position) {
        super(name, info, price,position);
        itemList = new LinkedList<>();
    }

    public Holder(String name, String info, int price, Holder holder) {
        super(name, info, price,holder);
        itemList = new LinkedList<>();
    }

    public void add(Item item) {
        itemList.add(item);
    }

    public Item remove(int number) {
        if (number > 0 && number <= itemList.size()) {
            Item result = itemList.get(number-1);
            itemList.remove(result);
            return result;
        } else
            throw new IllegalArgumentException("This contains " + itemList.size() + " Items");
    }

    public void remove(Item item) {
        itemList.remove(item);
    }

    public String[] takeContent() {
        String[] result = new String[itemList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(i + "-" + itemList.get(i).getInfo());
        }
        return result;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        String[] content = takeContent();
        for (int i = 0; i < itemList.size(); i++) {
            sb.append(content[i]);
            sb.append("|");
        }
        return new String(name + " contains: " + sb.toString());
    }

    @Override
    public List<Interactable> interact(Interactable something) {
        if (something instanceof Player) {
            Player player = (Player) something;
            if (player.getItem() instanceof Holder)
                return interact_0_1(player);
            else
                return super.interact(something);
        } else {
            throw new IllegalArgumentException("No method for this item: " + something);
        }
    }

    private List<Interactable> interact_0_1(Player player) {
        Holder holder = (Holder) player.getItem();
        System.out.println("Enter number:\n1-pick up\n2-get item\n3-look info");
        Scanner scanner = new Scanner(System.in);
        int choise = scanner.nextInt();
        if (choise == 1) {
            holder.add(this);
            System.out.println("you picked up: " + this);
            return null;
        }else if (choise == 2) {
            if (itemList.isEmpty()) {
                System.out.println("There is nothing inside");
                List<Interactable> result = new LinkedList<>();
                result.add(this);
                return result;
            }else {
                System.out.println("Enter number: ");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < itemList.size(); i++) {
                    sb.append(" ");
                    sb.append(i + 1);
                    sb.append("-");
                    sb.append(itemList.get(i).getInfo());
                    if(i != itemList.size())
                        sb.append("\n");
                }
                System.out.println(sb.toString());
                choise = scanner.nextInt();
                List<Interactable> result = new LinkedList<>();
                List<Interactable> temp = itemList.get(choise - 1).interact(player);

                itemList.remove(choise-1);
                if (temp != null) {
                    for (int i = 0; i < temp.size(); i++) {
                        Interactable itr = temp.get(i);
                        temp.remove(i);
                        if (itr instanceof Item) {
                            Item item = (Item) itr;
                            this.add(item);
                        } else
                            result.add(itr);
                    }
                }
                result.add(this);
                return result;
            }
        }else if (choise == 3) {
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
