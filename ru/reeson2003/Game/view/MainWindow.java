package ru.reeson2003.Game.view;

import ru.reeson2003.Game.Interactable;
import ru.reeson2003.map.Position;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Тоня on 10.10.2016.
 */
public class MainWindow extends JFrame {
    private String mainWindowName = "";
    private JPanel leftPanel;
    private JPanel rightPanel;

    public MainWindow(String name, java.util.List<Interactable> objects, Position position) {
        super(name);
        initialize(objects, position);
    }

    private void initialize(java.util.List<Interactable> objects, Position position) {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.leftPanel = new LeftPanel(objects);
        this.rightPanel = new RightPanel(position);
        //this.setLocationRelativeTo(null);
        //this.setSize(600, 200);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);
        this.pack();

        this.setVisible(true);
    }

}
