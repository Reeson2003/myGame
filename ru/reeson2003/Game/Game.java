package ru.reeson2003.Game;

import ru.reeson2003.map.*;
import ru.reeson2003.player.Player;

import java.util.List;

/**
 * Created by Тоня on 05.10.2016.
 */
public class Game {
    private static Game instance = null;
    private Game(Presenter presenter) {
        this.presenter = presenter;
    }
    public static Game getInstance(Presenter presenter) {
        if (instance == null)
            return new Game(presenter);
        else
            return instance;
    }

    private Presenter presenter;
    private Player player;
    private Map map;
    private String action;
    private String choise;

    public void show(String msg) {
        presenter.show(msg);
    }

    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        String result = this.action;
        this.action = null;
        return result;
    }
    public void setMove(String move) {

    }
    public void setChoise(String choise) {
        this.choise = choise;
    }
    public String getChoise() {
        String result = choise;
        choise = null;
        return result;
    }
    public String getChoise(String[] variants) {
        return presenter.getChoise(variants);
    }

    public void PLAY() {
        iMapGenerator mapGenerator = new Map_gen_0_1();
        Map map = Map.getInstance(mapGenerator);
        presenter.show("Enter player name");
        String name = presenter.getString(15);
        Player player = new Player(name, "@Player", map.getStart());
        //while (true) {
        presenter.show(player);
        presenter.show(player.getPosition());
        presenter.show(invitation(player));
        presenter.getAction();
        //}
    }
    private String invitation(Player player) {
        Position p = player.getPosition();
        List<Direction> dirs = p.getAvailableDirections();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter to move:\n");
        for (Direction d: dirs) {
            if (d == Direction.South)
                sb.append("S-South");
            if (d == Direction.North)
                sb.append("W-North");
            if (d == Direction.East)
                sb.append("D-East");
            if (d == Direction.West)
                sb.append("A_West");
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-2);
        String[] extras = p.getExtraLinksInfos();
        if(extras.length !=0) {
            sb.append("\n");
            for (int i = 0; i < extras.length; i++) {
                sb.append(i + 1);
                sb.append("-");
                sb.append(extras[i]);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length()-2);
        }
        String[] objects = p.getObjectsNames();
        if (objects.length !=0) {
            sb.append("\n");
            sb.append("Use: ");
            for (String s:objects) {
                sb.append(s);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length()-2);
        }
        sb.append("\n");
        sb.append("I-Inventory, E-Equipment, P-Parameters, M-Map, U-Use object");
        return sb.toString();
    }

}
