package ru.reeson2003.Game.view;


import ru.reeson2003.Game.controller.DirectionKeyListener;
import ru.reeson2003.map.Position;
import ru.reeson2003.tools.Interactable;

import javax.swing.*;
import java.util.List;

/**
 * Created by Тоня on 12.10.2016.
 */
public class SwingView extends View {
    private static SwingView swingView = null;
    private MainWindow mainWindow;
    private SwingView() {
        initialize();
    }

    public static SwingView getInstance() {
        if (swingView == null) {
            swingView = new SwingView();
        }
        return swingView;
    }

    private void initialize() {
        mainWindow = new MainWindow();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.addKeyListener(new DirectionKeyListener());
        mainWindow.setVisible(true);
    }

    public void show(List<Interactable> objects) {
        mainWindow.setObjects(objects);
    }
    public void show(Position position) {
        mainWindow.setPosition(position);
    }
    public void show(Icon icon) {
        mainWindow.setIcon(icon);
    }
    public void show(String text) {
        mainWindow.setText(text);
    }

}
