package ru.reeson2003.map;

import ru.reeson2003.chars.Player;
import ru.reeson2003.chars.Rabbit;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Тоня on 28.09.2016.
 */
public class MainProgramm {
    public static void main(String[] args) {

        Location izbushka = new Location(new LocGen0_1("Избушка", 4,5));

        Location cherdak = new Location(new LocGen0_1("Чердак", 3, 4));

        izbushka.getPosition(0,2).setExtraLinkTwoSide(cherdak.getPosition(0,0));

        izbushka.getPosition(3,3).addItem(new Interactable() {
            int useCounter = 0;
            @Override
            public String getInfo() {
                return "Cow";
            }

            @Override
            public List<Interactable> interact(Player player) {
                useCounter++;
                System.out.println("MOOOOOO");
                List<Interactable> result = new LinkedList<Interactable>();
                result.add(new Interactable() {
                    @Override
                    public String getInfo() {
                        return "***SHIT***";
                    }

                    @Override
                    public List<Interactable> interact(Player player) {
                        System.out.println("FOOOOOOOOOO");
                        return null;
                    }
                });
                if(useCounter <=5)
                    result.add(this);
                else
                    result.add(new Interactable() {
                        @Override
                        public String getInfo() {
                            return "Dead Cow";
                        }

                        @Override
                        public List<Interactable> interact(Player player) {
                            System.out.println("I'm dead cow");
                            List<Interactable> result = new LinkedList<Interactable>();
                            result.add(this);
                            return result;
                        }
                    });
                return result;
            }
        });
        izbushka.getPosition(2,1).addItem(new Interactable() {
            @Override
            public String getInfo() {
                return "Dog";
            }

            @Override
            public List<Interactable> interact(Player player) {
                System.out.println("WOOF-WOOF  BUEEEEEEEEEEE (x_x)");
                List<Interactable> result = new LinkedList<Interactable>();
                result.add(new Interactable() {
                    @Override
                    public String getInfo() {
                        return "(x_x)";
                    }

                    @Override
                    public List<Interactable> interact(Player player) {
                        System.out.println("This is Corpse");
                        List<Interactable> result = new LinkedList<Interactable>();
                        result.add(this);
                        return result;
                    }
                });
                return result;
            }
        });
        izbushka.getPosition(3,4).addItem(new Interactable() {
            @Override
            public String getInfo() {
                return "EXIT";
            }

            @Override
            public List<Interactable> interact(Player player) {
                System.exit(0);
                return null;
            }
        });

        //cherdak.getPosition(1,1).addItem(new Rabbit("Заенька", cherdak.getPosition(1,1)));

        izbushka.getPosition(0,0).addItem(new Rabbit("Зайка", izbushka.getPosition(0,0)));

        Position current = izbushka.getPosition(0,0);
        Player p1 = new Player("xXxTurboGladNagibator3000xXx", "Нагибаю на скилле", current);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(p1.getPosition());
            StringBuilder sb = new StringBuilder();
            sb.append("You can interact: |");
            List<Interactable> items = p1.getPosition().getItems();
            for (Interactable i: items) {
                sb.append(i.getInfo());
                sb.append("|");
            }
            System.out.println(sb.toString());
        System.out.println("Enter 1 to move, 2 to extra move, 3 to interact with item");
        int choose = scanner.nextInt();
        if(choose == 1) {
            System.out.println("Enter number: 1-North, 2-South, 3-East, 4-West");
            p1.setPosition(move(scanner.nextInt(), p1));
        }
        else if(choose == 2) {
            System.out.print("Enter number: ");
            p1.setPosition(p1.getPosition().moveExtra(scanner.nextInt()));
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
            return p.getPosition().move(Direction.North);
        else if (d == 2)
            return p.getPosition().move(Direction.South);
        else if (d == 3)
            return p.getPosition().move(Direction.East);
        else if (d == 4)
            return p.getPosition().move(Direction.West);
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
