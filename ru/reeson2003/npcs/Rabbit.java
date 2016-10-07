package ru.reeson2003.npcs;

import ru.reeson2003.Game.Game;
import ru.reeson2003.map.Direction;
import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

import java.util.Random;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Rabbit extends Creature {
    public Rabbit(String name, Position position) {
        super(name, "Кролик", position);
    }


    @Override
    public void interact(Player player, Game game) {
        game.show("Hello, im " + name);
        Random random = new Random();
        int rnd = random.nextInt(4);
        switch (rnd) {
            case 0: this.move(Direction.South);
                break;
            case 1: this.move(Direction.North);
                break;
            case 2: this.move(Direction.East);
                break;
            case 3: this.move(Direction.West);
                break;
        }
        game.mainLoop();
    }
}
