package ru.reeson2003.Game.model;

import ru.reeson2003.tools.iTimeActivator;
import ru.reeson2003.Game.view.SwingView0_2;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Map;
import ru.reeson2003.map.Map_gen_0_1;
import ru.reeson2003.player.Player;
import ru.reeson2003.tools.TimeActivator;


/**
 * Created by Тоня on 16.10.2016.
 */
public class Game {
    private static Game game = null;
    private iTimeActivator timeActivator;
    private Player player;
    private Map map;

    private volatile Direction direction = null;
    private Game() {
        initialize();
    }
    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    private void initialize() {
        timeActivator = new TimeActivator();
        map = Map.getInstance(new Map_gen_0_1(timeActivator));
        player = new Player("Reeson", "player", map.getStart());
        Thread timeAct = new Thread(timeActivator);
        timeAct.start();
        mainLoop();
    }

    public synchronized void mainLoop() {
        //while(true) {
            SwingView0_2.getInstance().show(player.getPosition().getLocation().getIcon());
            SwingView0_2.getInstance().show(player.getPosition());
            SwingView0_2.getInstance().show(player.getInfo());
            SwingView0_2.getInstance().show(player.getPosition().getObjects());
//            if(direction != null) {
//                System.out.println(direction);
//                player.move(direction);
//                direction = null;
//            }
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void setDirection(Direction direction) {
        player.move(direction);
        mainLoop();
    }

    public Player getPlayer() {
        return player;
    }

}
