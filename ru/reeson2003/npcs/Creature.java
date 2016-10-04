package ru.reeson2003.npcs;

import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class Creature implements Interactable{
    protected String name = "";
    protected String info = "";
    protected Position position;
    protected Creature(String name, String info, Position position) {
        if (name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        this.position = position;
    }
}
