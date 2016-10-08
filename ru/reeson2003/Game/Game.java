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
    private iTimeActivator timeActivator;

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
    public String getString(String invitation) {
        return presenter.getString(invitation);
    }

    public void PLAY() {
        this.timeActivator = new TimeActivator();
        iMapGenerator mapGenerator = new Map_gen_0_1(timeActivator);
        this.map = Map.getInstance(mapGenerator);
        presenter.show("Enter player name");
        String name = presenter.getString("Enter player name");
        this.player = new Player(name, "@Player", map.getStart());

        mainLoop();
    }
    private String invitation(Player player) {
        Position p = player.getPosition();
        List<Direction> dirs = p.getAvailableDirections();
        StringBuilder sb = new StringBuilder();
        sb.append("Enter to move:<br>");
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
            sb.append("<br>");
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
            sb.append("<br>");
            sb.append("Use: ");
            for (String s:objects) {
                sb.append(s);
                sb.append(", ");
            }
            sb.deleteCharAt(sb.length()-2);
        }
        sb.append("<br>");
        sb.append("T-Transit, I-Inventory, E-Equipment, P-Parameters, M-Map, U-Use object");
        return sb.toString();
    }

    public void mainLoop() {
        while(true) {
            presenter.show(mainDisplayText(player));
            action(presenter.getKeyAction());
            timeActivator.timeActivate();
        }
    }

    public void action(String action) {
        //System.out.println(action + "bnf");
        if (action.equals("W")) {
            presenter.setKeyAction("");
            player.move(Direction.North);
        }
        else if (action.equals("S")) {
            presenter.setKeyAction("");
            player.move(Direction.South);
        }
        else if (action.equals("D")) {
            presenter.setKeyAction("");
            player.move(Direction.East);
        }
        else if (action.equals("A")) {
            presenter.setKeyAction("");
            player.move(Direction.West);
        }
        else if (action.equals("T")) {
            presenter.setKeyAction("");
            extraMove();
        }
        else if (action.equals("U")) {
            presenter.setKeyAction("");
            useObject();
        }
    }
    private String mainDisplayText(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append(player.getName());
        stringBuilder.append("<br>HP: 50% ##########----------<br>MP: 80% ################----<br>");
        stringBuilder.append(player.getPosition().getInfo());
        stringBuilder.append("<br>");
        stringBuilder.append(invitation(player));
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
    private void extraMove() {
        String[] extraMoves = player.getPosition().getExtraLinksInfos();
        if (extraMoves.length >0) {
            String action = presenter.getChoise(extraMoves);
            if(!action.equals("Cancel")) {
                int index = 0;
                //тут не работает
                for (int i = 0; i < extraMoves.length; i++) {
                    if (extraMoves[i].equals(action))
                        index = i;
                }
                player.setPosition(player.getPosition().getExtraLink(index));
            }
        }
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
            System.out.println(action);
            if (!action.equals("Cancel")) {
                int index = 0;
                for (int i = 0; i < objects.length; i++) {
                    if (objects[i].equals(action))
                        index = i;
                }
                player.getPosition().getObject(index).interact(player, this);
            }
        }
    }

}
