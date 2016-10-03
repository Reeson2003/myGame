package ru.reeson2003.chars;

import ru.reeson2003.map.Interactable;
import ru.reeson2003.map.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Monster extends Creature {

    public Monster(String name, String info, Position position) {
        super(name,info,position);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        return name;
    }

    @Override
    public List<Interactable> interact(Interactable player) {
        System.out.println(info);
        List<Interactable> result = new LinkedList<>();
        result.add(this);
        return result;
    }
}
