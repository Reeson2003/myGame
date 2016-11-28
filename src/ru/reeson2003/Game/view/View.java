package ru.reeson2003.Game.view;

import ru.reeson2003.Game.model.map.Position;
import ru.reeson2003.Game.model.npcs.Parameters;
import ru.reeson2003.Game.model.tools.Interactable;
import ru.reeson2003.Game.view.ConsoleView.ConsoleView;
import ru.reeson2003.Game.view.swingView.SwingView;

import javax.swing.*;
import java.util.List;

/**
 * Created by Тоня on 18.10.2016.
 */
public abstract class View {
    protected View() {

    }
    public static View getInstance() {
        return ConsoleView.getInstance();
    }
    public abstract void show(String text);
    public abstract void show(Icon icon);
    public abstract void show(Position position);
    public abstract void show(List<Interactable> objects);
    public abstract void show(Parameters parameters);
}
