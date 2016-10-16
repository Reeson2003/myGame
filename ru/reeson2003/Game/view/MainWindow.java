package ru.reeson2003.Game.view;

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

        this.leftPanel = new LeftPanel();
        this.rightPanel = new RightPanel();
        this.centerPanel  =new CenterPanel();
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);
        this.setMinimumSize(new Dimension(MAIN_FRAME_WIDTH,MAIN_FRAME_HEIGHT));
        this.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH,MAIN_FRAME_HEIGHT));
        this.pack();
    }

    public void setObjects(java.util.List<Interactable> objects) {
        this.leftPanel.setObjects(objects);
    }
    public void setPosition(Position position) {
        rightPanel.setPosition(position);
    }
    public void setIcon(Icon icon) {
        centerPanel.setIcon(icon);
    }
    public void setText(String text) {
        centerPanel.setText(text);
    }

}
