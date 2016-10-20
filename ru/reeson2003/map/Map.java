package ru.reeson2003.map;

import java.util.List;

/**
 * Created by Тоня on 04.10.2016.
 */
public class Map {
    private static Map instance = null;
    private Map(iMapGenerator mapGenerator) {
        this.locations = mapGenerator.getLocations();
        this.start = mapGenerator.getStart();
        instance = this;
    }
    public static Map getInstance(iMapGenerator mapGenerator) {
        if (instance == null)
            return new Map(mapGenerator);
        else
            return instance;
    }

    private Position start;
    private List<Location> locations;
    public Position getStart() {
        return start;
    }

}
