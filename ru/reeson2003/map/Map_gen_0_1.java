package ru.reeson2003.map;

import ru.reeson2003.npcs.Rabbit;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
        Location forest = new Location(new LocGen0_1("Лес", 4, 4));
        Location field  = new Location(new LocGen0_1("Поле", 5, 5));
        Location dungeon = new Location(new LocGen0_1("Подземелье", 3, 2));
        start = field.getPosition(2, 0);
        forest.getPosition(0, 3).setExtraLinkTwoSide(field.getPosition(4,3));
        field.getPosition(4, 0).setExtraLinkToAnother(forest.getPosition(0, 0));
        forest.getPosition(3, 0).setExtraLinkTwoSide(dungeon.getPosition(2, 1));

        Rabbit roger = new Rabbit("Роджер", field.getPosition(2,1));
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
