package ru.reeson2003.Game.model.npcs;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.Game.view.View;
import ru.reeson2003.Game.model.tools.TimeActivator;
import ru.reeson2003.Game.model.tools.iTimeActing;
import ru.reeson2003.Game.model.map.Direction;
import ru.reeson2003.Game.model.map.Position;

import java.util.Random;

/**
 * Created by Тоня on 01.10.2016.
 */
public class Rabbit extends Creature implements iTimeActing {
    private static int rabbitsAmount = 0;
    long time = 0;
    long lifeTime = 0;
    private Random random;
    public Rabbit(String name, Position position) {
        super(name, "Кролик", position);
        random = new Random();
        TimeActivator.getInstance().addTimeListener(this);
        rabbitsAmount++;
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
        Rabbit rabbit = new Rabbit("Заец #" + rabbitsAmount,temp);
        View.getInstance().show("Привет, я " + name);
        game.refreshObjects();
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
        if (lifeTime == 0) {
            lifeTime = time;
        } else {
            if (time-lifeTime > 60000) {
                position.removeObject(this);
                TimeActivator.getInstance().removeTimeListener(this);
            }
        }
        if ((time-this.time) > random.nextInt(5000)+2500) {
            //System.out.println(name + " at " + position.getInfo());
            this.time = time;
            randomMove();
            Game.getInstance().refreshObjects();
        }
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.err.println(name + " iz dead");
    }
}
