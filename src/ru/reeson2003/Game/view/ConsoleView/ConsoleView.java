package ru.reeson2003.Game.view.ConsoleView;

import ru.reeson2003.Game.model.map.Position;
import ru.reeson2003.Game.model.npcs.Parameters;
import ru.reeson2003.Game.model.player.Player;
import ru.reeson2003.Game.model.tools.Fight;
import ru.reeson2003.Game.model.tools.Interactable;
import ru.reeson2003.Game.view.NewView;
import ru.reeson2003.Game.view.View;

import javax.swing.*;
import java.util.List;

/**
 * Created by Toshiba on 27.11.2016.
 */
public class ConsoleView extends View implements NewView {
    private static View instance = null;
    private ConsoleView(){}
    public static View getInstance() {
        if(instance == null)
            instance = new ConsoleView();
        return instance;
    }

    @Override
    public void show(Position position) {
        StringBuilder sb = new StringBuilder();
        sb.append("You are: ");
        sb.append(position);
        sb.append("\n Directions:");
        if (position.getSouth() != null) {
            sb.append("\nS: ");
            sb.append(position.getSouth());
        }
        if (position.getNorth() != null) {
            sb.append("\nN: ");
            sb.append(position.getNorth());
        }
        if (position.getEast() != null) {
            sb.append("\nE: ");
            sb.append(position.getEast());
        }
        if (position.getWest() != null) {
            sb.append("\nW: ");
            sb.append(position.getWest());
        }
        sb.append("\n Objects: {");
        List<Interactable> objs = position.getObjects();
        for (int i = 0; i < objs.size(); i++) {
            sb.append(i + 1);
            sb.append(".");
            sb.append(objs.get(i).getName());
            sb.append(", ");
        }
        if (objs.size() > 0)
            sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        System.out.println(sb.toString());
    }

    @Override
    public void show(List<Interactable> objects) {

    }

    @Override
    public void show(Fight fight) {

    }

    @Override
    public void show(Player player) {

    }

    @Override
    public void show(Parameters parameters) {

    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    @Override
    public void show(Icon icon) {

    }
}
