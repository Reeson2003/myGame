package ru.reeson2003.map;

import ru.reeson2003.player.Player;
import ru.reeson2003.items.Item;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 28.09.2016.
 */
public class MainProgramm {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        Location cherdak = new Location(new LocGen0_1("Чердак", 3, 3));
        Player p1 = new Player("xXxTurboGladNagibator3000xXx", "Нагибаю на скилле", cherdak.getPosition(0,0));

        Item test = new Item("Item", "item", 10,7) {
            @Override
            public List<Interactable> interact(Interactable something) {
                return null;
            }
        };

        cherdak.getPosition(0,0).addObject(test);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            String itms = "";
            if (p1.getItem() != null)
                itms = p1.getItem().getInfo();
            System.out.println(p1.getInfo() + ", " + ", " + itms);
            System.out.println(p1.getPosition());
            StringBuilder sb = new StringBuilder();
            sb.append("You can interact: |");
            List<Interactable> items = p1.getPosition().getObjects();
            for (Interactable i: items) {
                sb.append(i.getInfo());
                sb.append("|");
            }
            System.out.println(sb.toString());
        System.out.println("Enter 1 to Move, 2 to extra Move, 3 to interact with item");
        int choose = scanner.nextInt();
        if(choose == 1) {
            System.out.println("Enter number: 1-North, 2-South, 3-East, 4-West");
            p1.setPosition(move(scanner.nextInt(), p1));
        }
        else if(choose == 2) {
            System.out.print("Enter number: ");
            p1.setPosition(p1.getPosition().getExtraLink(scanner.nextInt()));
        }
        else if(choose == 3) {
            System.out.print("Enter number: ");
            for (int i = 1 ; i <= items.size(); i++) {
                System.out.print(i + "-" + items.get(i-1).getInfo() + ", ");
            }
            interact(scanner.nextInt(), items, p1);
        }
        }
    }

    public static Position move(int d, Player p) {
        if (d == 1)
            return p.getPosition().getByDirection(Direction.North);
        else if (d == 2)
            return p.getPosition().getByDirection(Direction.South);
        else if (d == 3)
            return p.getPosition().getByDirection(Direction.East);
        else if (d == 4)
            return p.getPosition().getByDirection(Direction.West);
        else
            return p.getPosition();
    }

    public static void interact(int n, List<Interactable> items, Player player) {
        if(n>0 && n<=items.size()) {
            Interactable item = items.get(n - 1);
            items.remove(n-1);
            List<Interactable> itemList = item.interact(player);
            if(itemList != null)
                items.addAll(itemList);
        }
    }

}
