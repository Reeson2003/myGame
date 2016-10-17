package ru.reeson2003.Game.view;

import ru.reeson2003.map.Position;
import ru.reeson2003.tools.Interactable;

import javax.swing.*;
import java.util.List;

/**
 * Created by Тоня on 18.10.2016.
 */
public abstract class View {
    protected View() {

    }
    public static View getInstance() {
        return SwingView.getInstance();
    }
    public abstract void show(String text);
    public abstract void show(Icon icon);
    public abstract void show(Position position);
    public abstract void show(List<Interactable> objects);
}
