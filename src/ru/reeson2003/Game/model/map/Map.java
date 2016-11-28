package ru.reeson2003.Game.model.map;

import java.util.List;

/**
 * Created by Тоня on 04.10.2016.
 */
public class Map {
    public Map() {
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    private Position start;
    private List<Location> locations;
    public Position getStart() {
        return start;
    }

}
