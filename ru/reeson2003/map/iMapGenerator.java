package ru.reeson2003.map;

import java.util.List;

/**
 * Created by Тоня on 05.10.2016.
 */
public interface iMapGenerator {
    List<Location> getLocations();
    Position getStart();
}
