package ru.reeson2003.Game.view;


import ru.reeson2003.Game.controller.DirectionKeyListener;
import ru.reeson2003.map.Position;
import ru.reeson2003.npcs.Parameters;
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

    @Override
    public void show(List<Interactable> objects) {
        mainWindow.showObjects(objects);
    }
    @Override
    public void show(Parameters parameters) {
        mainWindow.showParameters(parameters);
    }
    @Override
    public void show(Position position) {
        mainWindow.showPosition(position);
    }
    @Override
    public void show(Icon icon) {
        mainWindow.showIcon(icon);
    }
    @Override
    public void show(String text) {
        mainWindow.showText(text);
    }


}
