package ru.reeson2003.npcs;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.tools.TimeActivator;
import ru.reeson2003.tools.iTimeActing;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Position;

import java.util.Random;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Rabbit extends Creature implements iTimeActing {
    long time = 0;
    private Random random;
    public Rabbit(String name, Position position) {
        super(name, "Кролик", position);
        random = new Random();
        TimeActivator.getInstance().addTimeListener(this);
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void interact() {
        //System.out.println("Hello, im " + name);
        Game game = Game.getInstance();
        Position temp = this.position;
        randomMove();
        Rabbit valera = new Rabbit("Валера",temp);
        game.showObjects();

    }
    private void randomMove() {
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
    }

    @Override
    public void timeActivate(long time) {
        if ((time-this.time) > random.nextInt(5000)+2500) {
            System.out.println(name + " at " + position.getInfo());
            this.time = time;
            randomMove();
            Game.getInstance().mainLoop();
        }
    }
}
