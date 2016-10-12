package ru.reeson2003.Game.view;


import ru.reeson2003.Game.Game;
import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

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
        objects.add(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return null;
            }

            @Override
            public String getName() {
                return "Rabbit";
            }

            @Override
            public void interact(Player player, Game game) {
                System.out.println(getName());
            }
        });
        objects.add(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return null;
            }

            @Override
            public String getName() {
                return "Bear";
            }

            @Override
            public void interact(Player player, Game game) {
                System.out.println(getName());
            }
        });
        objects.add(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return null;
            }

            @Override
            public String getName() {
                return "Wolf";
            }

            @Override
            public void interact(Player player, Game game) {
                System.out.println(getName());
            }
        });
        objects.add(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return null;
            }

            @Override
            public String getName() {
                return "Goblin";
            }

            @Override
            public void interact(Player player, Game game) {
                System.out.println(getName());
            }
        });
        objects.add(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return null;
            }

            @Override
            public String getName() {
                return "Teleport";
            }

            @Override
            public void interact(Player player, Game game) {
                System.out.println(getName());
            }
        });

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame main = new MainWindow("TEST",objects);

    }
}
