package ru.reeson2003.Game.view;

import ru.reeson2003.Game.controller.ArrowsButtonListener;
import ru.reeson2003.Game.controller.DirectionKeyListener;
import ru.reeson2003.map.Direction;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 12.10.2016.
 */
public class ArrowsPanel extends JPanel {
    private static final int WIDTH = 90;
    private static final int HEIGHT = 90;
    private JButton upButton;
    private JButton downButton;
    private JButton leftButton;
    private JButton rightButton;
    public ArrowsPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridLayout(3,3));
        upButton = getButton("icons/arrows/up.jpg");
        upButton.addActionListener(new ArrowsButtonListener(Direction.North));
        downButton = getButton("icons/arrows/down.jpg");
        downButton.addActionListener(new ArrowsButtonListener(Direction.South));
        leftButton = getButton("icons/arrows/left.jpg");
        leftButton.addActionListener(new ArrowsButtonListener(Direction.West));
        rightButton = getButton("icons/arrows/right.jpg");
        rightButton.addActionListener(new ArrowsButtonListener(Direction.East));

        this.add(new JLabel());
        this.add(upButton);
        this.add(new JLabel());
        this.add(leftButton);
        this.add(new JLabel());
        this.add(rightButton);
        this.add(new JLabel());
        this.add(downButton);
        this.add(new JLabel());

        this.setBackground(Colors.BACKGROUND);
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT,2,false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
    }
    private JButton getButton(String file) {
        ImageIcon icon  = new ImageIcon(file);
        JButton button = new JButton(icon);
        return  button;
    }
}
