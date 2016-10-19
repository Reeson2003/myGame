package ru.reeson2003.map;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.Game.view.View;
import ru.reeson2003.npcs.Creature;
import ru.reeson2003.npcs.Rabbit;
import ru.reeson2003.tools.Interactable;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 06.10.2016.
 */
public class Map_gen_0_1 implements iMapGenerator{
    Position start;
    List<Location> locations;

    public Map_gen_0_1() {
        this.locations = new LinkedList<>();
        makeMap();
    }

    private void makeMap() {
        Location forest = new LocGen0_1("Forest","Лес", 4, 4).getLocation();
        forest.setIcon(new ImageIcon("icons/mainpics/fantasy_forest.jpg"));
        Location field  = new LocGen0_1("Field","Поле", 5, 5).getLocation();
        field.setIcon(new ImageIcon("icons/mainpics/fantasy_field.jpg"));
        Location dungeon = new LocGen0_1("Dungeon","Подземелье", 3, 2).getLocation();
        dungeon.setIcon(new ImageIcon("icons/mainpics/fantasy_dungeon.jpg"));
        start = field.getPosition(2, 0);
        field.getPosition(0,1).setWest(forest.getPosition(3,3));
        forest.getPosition(3,3).setEast(field.getPosition(0,1));
        field.getPosition(4,3).setEast(dungeon.getPosition(0,1));
        dungeon.getPosition(0,1).setWest(field.getPosition(4,3));
        dungeon.getPosition(1,0).deleteDirectionTwoSide(Direction.South);

        Rabbit rabbit = new Rabbit("Заец", field.getPosition(2,1));
        Creature medved = new Creature("Медведь", "Medved", field.getPosition(2,0)) {
            @Override
            public int getID() {
                return 3;
            }

            @Override
            public void interact() {
                Game game = Game.getInstance();
                View.getInstance().show("Йа медвед, пошол нахуй!!!!");
                game.getPlayer().setPosition(forest.getPosition(0,0));
                new Rabbit("Заец", forest.getPosition(0,0));
                game.refreshObjects();
                game.refreshIcon();
                game.refreshPosition();
            }
        };

        Location smallHouse = new LocGen0_1("House", "Избушка", 2,2).getLocation();
        smallHouse.setIcon(new ImageIcon("icons/mainpics/small_house.jpg"));
        smallHouse.getPosition(0,0).addObject(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }
            @Override
            public String getInfo() {
                return "Exit";
            }
            @Override
            public String getName() {
                return "Выход";
            }
            @Override
            public int getID() {
                return 4;
            }
            @Override
            public void interact() {
                Game game = Game.getInstance();
                game.getPlayer().setPosition(forest.getPosition(0,3));
                game.refreshObjects();
                game.refreshIcon();
                game.refreshPosition();
            }
        });
        forest.getPosition(0, 3).addObject(new Interactable() {
            @Override
            public void setPosition(Position position) {

            }

            @Override
            public String getInfo() {
                return "House";
            }

            @Override
            public String getName() {
                return "Избушка";
            }

            @Override
            public int getID() {
                return 5;
            }

            @Override
            public void interact() {
                Game game = Game.getInstance();
                game.getPlayer().setPosition(smallHouse.getPosition(0, 0));
                game.refreshObjects();
                game.refreshIcon();
                game.refreshPosition();
            }
        });

    }

    @Override
    public List<Location> getLocations() {
        return locations;
    }
    @Override
    public Position getStart() {
        return start;
    }
}
