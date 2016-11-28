package ru.reeson2003.Game.model.npcs;

import ru.reeson2003.Game.model.map.Position;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Monster extends Creature {

    public Monster(String name, String info, Position position) {
        super(name,info,position);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void interact() {

    }
}
