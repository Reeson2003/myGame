package ru.reeson2003.npcs;

import ru.reeson2003.Game.Game;
import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

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
    public void interact(Player player, Game game) {

    }
}
