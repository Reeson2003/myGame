package ru.reeson2003.player;

import ru.reeson2003.Game.Game;
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
    public void interact(Player player, Game game) {
        if (player == this) {
            this.name = game.getString("Enter name");
            game.show(this.info);
        } else {
            game.show(player.getInfo());
        }
        position.addObject(this);
        game.mainLoop();
    }


}
