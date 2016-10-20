package ru.reeson2003.Game.view;

import ru.reeson2003.npcs.Parameters;
import ru.reeson2003.tools.Interactable;
import ru.reeson2003.map.Position;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Тоня on 10.10.2016.
 */
public class MainWindow extends JFrame {
    final static int MAIN_FRAME_WIDTH = 800;
    final static int MAIN_FRAME_HEIGHT = 480;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private CenterPanel centerPanel;

    public MainWindow() {
        super();
        initialize();
    }
    public MainWindow(String name) {
        super(name);
        initialize();
    }
    private void initialize() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();
        centerPanel  =new CenterPanel();
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH,MAIN_FRAME_HEIGHT));
        this.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH,MAIN_FRAME_HEIGHT));
        this.pack();
    }

    public void showObjects(java.util.List<Interactable> objects) {
        this.leftPanel.setObjects(objects);
    }
    public void showPosition(Position position) {
        rightPanel.setPosition(position);
    }
    public void showIcon(Icon icon) {
        centerPanel.showIcon(icon);
    }
    public void showText(String text) {
        centerPanel.showText(text);
    }
    public void showParameters(Parameters parameters) {
        centerPanel.showParameters(parameters);
    }

}
