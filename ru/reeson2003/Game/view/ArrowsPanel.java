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

    private JButton upButton;
    private JButton downButton;
    private JButton leftButton;
    private JButton rightButton;
    public ArrowsPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridLayout(3,3));
        upButton = getButton("up.jpg");
        upButton.addActionListener(new ArrowsButtonListener(Direction.North));
        downButton = getButton("down.jpg");
        downButton.addActionListener(new ArrowsButtonListener(Direction.South));
        leftButton = getButton("left.jpg");
        leftButton.addActionListener(new ArrowsButtonListener(Direction.West));
        rightButton = getButton("right.jpg");
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
        //this.add(centerButton,BorderLayout.CENTER);

        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.setMaximumSize(new Dimension(90,90));
        System.out.println(this.hasFocus());
        this.setVisible(true);
    }

    private JButton getButton(String file) {
        ImageIcon icon  = new ImageIcon(file);
        JButton button = new JButton(icon);
//        button.setSize(30,30);
//        button.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        return  button;
    }
}
