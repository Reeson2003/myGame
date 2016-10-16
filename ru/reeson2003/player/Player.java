package ru.reeson2003.player;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.npcs.Creature;
import ru.reeson2003.map.Position;
import ru.reeson2003.npcs.Parameters;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Player extends Creature {
    private Equip equip;
    private Parameters parameters;

    public Player(String name, String info, Position position) {
        super(name,info,position);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void interact() {
        Game.getInstance().mainLoop();
    }

    @Override
    public String getInfo() {
        String result = name + "<br>" + position.getInfo();
        return result;
    }


}
