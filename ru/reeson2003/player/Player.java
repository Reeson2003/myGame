package ru.reeson2003.player;

import ru.reeson2003.Game.view.View;
import ru.reeson2003.npcs.Creature;
import ru.reeson2003.map.Position;
import ru.reeson2003.npcs.Parameters;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Player extends Creature {
    private Equip equip;

    public Player(String name, String info, Position position, Parameters parameters) {
        super(name,info,position);
        this.parameters = parameters;
    }

    @Override
    public int getID() {
        return -1;
    }

    @Override
    public void interact() {
        View.getInstance().show(super.getInfo());
    }

    @Override
    public String getInfo() {
        String result = name + "<br>" + position.getInfo();
        return result;
    }

}
