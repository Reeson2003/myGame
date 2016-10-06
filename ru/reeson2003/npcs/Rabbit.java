package ru.reeson2003.npcs;

import ru.reeson2003.map.Direction;
import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Rabbit extends Creature {
    public Rabbit(String name, Position position) {
        super(name, "Кролик", position);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfo() {
        String result = new String(info + " по имени " + name);
        return result;
    }

    @Override
    public void interact(Interactable something) {

    }
}
