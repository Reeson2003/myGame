package ru.reeson2003.Game.view;

import ru.reeson2003.Game.controller.PlayerButtonListener;
import ru.reeson2003.Game.controller.StatsButtonListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 15.10.2016.
 */
public class IconsPanel extends JPanel {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;


    public IconsPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridLayout(3, 3));
        button1 = new JButton();
        button1.addActionListener(new StatsButtonListener());
        button1.setIcon(new ImageIcon("icons/buttons/player.jpg"));
        button2 = new JButton();
        button2.setIcon(new ImageIcon("icons/buttons/armor.jpg"));
        button3 = new JButton();
        button3.setIcon(new ImageIcon("icons/buttons/bag.jpg"));
        button4 = new JButton();
        button4.setIcon(new ImageIcon("icons/buttons/scroll.jpg"));
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);

        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK, 2, false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE, 2, false);
        this.setBorder(BorderFactory.createCompoundBorder(out, in));
        this.setMaximumSize(new Dimension(90, 90));
        this.setVisible(true);
    }
}
