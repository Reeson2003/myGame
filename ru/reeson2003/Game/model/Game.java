package ru.reeson2003.Game.model;

import ru.reeson2003.Game.view.SwingView;
import ru.reeson2003.map.Direction;
import ru.reeson2003.map.Map;
import ru.reeson2003.map.Map_gen_0_1;
import ru.reeson2003.player.Player;


/**
 * Created by Тоня on 16.10.2016.
 */
public class Game {
    private static Game game = null;
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
        map = Map.getInstance(new Map_gen_0_1());
        player = new Player("Reeson", "player", map.getStart());
        mainLoop();
    }

    public synchronized void mainLoop() {
        refreshIcon();
        refreshPosition();
        refreshInfo();
        refreshObjects();
    }

    public void setDirection(Direction direction) {
        player.move(direction);
        mainLoop();
    }

    public Player getPlayer() {
        return player;
    }

    public void refreshObjects() {
        SwingView.getInstance().show(player.getPosition().getObjects());
    }
    public void refreshPosition() {
        SwingView.getInstance().show(player.getPosition());
    }
    public void refreshIcon() {
        SwingView.getInstance().show(player.getPosition().getLocation().getIcon());
    }
    public void refreshInfo() {
        SwingView.getInstance().show(player.getInfo());
    }

}