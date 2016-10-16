package ru.reeson2003.Game.view;


import ru.reeson2003.tools.Interactable;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.LocGen0_1;
import ru.reeson2003.map.Location;
import ru.reeson2003.map.Position;
import ru.reeson2003.npcs.Rabbit;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 10.10.2016.
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        List<Interactable> objects = new LinkedList<>();
        objects.add(new Rabbit("Крололо", new Position(0,0,"forest")));
        objects.add(new Rabbit("Крололо2", new Position(0,0,"forest")){
            @Override
            public int getID() {
                return 2;
            }
        });
//        objects.add(new Interactable() {
//            @Override
//            public void setPosition(Position position) {
//
//            }
//
//            @Override
//            public String getInfo() {
//                return null;
//            }
//
//            @Override
//            public String getName() {
//                return "Bear";
//            }
//
//            @Override
//            public Icon getIcon() {
//                return new ImageIcon("rabbit.jpg");
//            }
//
//            @Override
//            public void interact(Player player, Game game) {
//                System.out.println(getName());
//            }
//        });
//        objects.add(new Interactable() {
//            @Override
//            public void setPosition(Position position) {
//
//            }
//
//            @Override
//            public String getInfo() {
//                return null;
//            }
//
//            @Override
//            public String getName() {
//                return "Wolf";
//            }
//
//            @Override
//            public Icon getIcon() {
//                return new ImageIcon("rabbit.jpg");
//            }
//
//            @Override
//            public void interact(Player player, Game game) {
//                System.out.println(getName());
//            }
//        });
//        objects.add(new Interactable() {
//            @Override
//            public void setPosition(Position position) {
//
//            }
//
//            @Override
//            public String getInfo() {
//                return null;
//            }
//
//            @Override
//            public String getName() {
//                return "Goblin";
//            }
//
//            @Override
//            public Icon getIcon() {
//                return new ImageIcon("rabbit.jpg");
//            }
//
//            @Override
//            public void interact(Player player, Game game) {
//                System.out.println(getName());
//            }
//        });
//        objects.add(new Interactable() {
//            @Override
//            public void setPosition(Position position) {
//
//            }
//
//            @Override
//            public String getInfo() {
//                return null;
//            }
//
//            @Override
//            public String getName() {
//                return "Teleport";
//            }
//
//            @Override
//            public Icon getIcon() {
//                return new ImageIcon("rabbit.jpg");
//            }
//
//            @Override
//            public void interact(Player player, Game game) {
//                System.out.println(getName());
//            }
//        });

        String info = "Location: Dungeon of silence<br>Size of location: 7x7<br>Level of location: 14";
        Location testLoc = new LocGen0_1("Fantasy dungeon", info, 7,7).getLocation();
        testLoc.setIcon(new ImageIcon("fantasy_dungeon.jpg"));
        testLoc.getPosition(0,1).deleteDirectionTwoSide(Direction.East);
        testLoc.getPosition(0,0).deleteDirectionTwoSide(Direction.East);
        testLoc.getPosition(0,2).deleteDirectionTwoSide(Direction.East);


        MainWindow mainWindow = new MainWindow("WOW - 2");
        mainWindow.setVisible(true);

        mainWindow.setObjects(objects);
        mainWindow.setPosition(testLoc.getPosition(1,1));
        mainWindow.setIcon(testLoc.getIcon());
        mainWindow.setText(testLoc.getInfo());
        mainWindow.setLocationRelativeTo(null);

    }
}
