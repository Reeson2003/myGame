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
    public static Game getInstance() {
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
        this.player = new Player(name, "@Player", map.getStart());
        //while (true) {
        mainLoop();
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
                sb.append("A-West");
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
        sb.append("T-Transit, I-Inventory, E-Equipment, P-Parameters, M-Map, U-Use object");
        return sb.toString();
    }

    public void mainLoop() {
        presenter.show(player);
        presenter.show(player.getPosition());
        presenter.show(invitation(player));
        action(presenter.getAction());
    }

    public void action(String action) {
        System.out.println(action);
        if (action.equals("W"))
            player.move(Direction.North);
        else if (action.equals("S"))
            player.move(Direction.South);
        else if (action.equals("D"))
            player.move(Direction.East);
        else if (action.equals("A"))
            player.move(Direction.West);
        else if (action.equals("T"))
            extraMove();
        else if (action.equals("U"))
            useObject();
        mainLoop();
    }
    private void extraMove() {
        String[] extraMoves = player.getPosition().getExtraLinksInfos();
        if (extraMoves.length >0) {
            String action = presenter.getChoise(extraMoves);
            int index = 0;
            for (int i = 0; i < extraMoves.length; i++) {
                if (extraMoves[i].equals(action))
                    index = i;
            }
            player.setPosition(player.getPosition().getExtraLink(index));
        }
        mainLoop();
    }
    private void useObject() {
        String[] objects = player.getPosition().getObjectsNames();
        String[] objInfos = player.getPosition().getObjectsInfos();
        String[] invitation = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            invitation[i] = objects[i] + ", " + objInfos[i];
        }
        if (objects.length >0) {
            String action = presenter.getChoise(invitation);
            if (!action.equals("Cancel")) {
                int index = 0;
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i].equals(action))
                        index = i;
                }
                player.getPosition().getObject(index).interact(player, this);
            }
        }
        mainLoop();
    }

}
