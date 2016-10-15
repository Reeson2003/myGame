package ru.reeson2003.Game.view;

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
        this.button1 = new JButton();
        this.button2 = new JButton();
        this.button3 = new JButton();
        this.button4 = new JButton();
        this.button5 = new JButton();
        this.button6 = new JButton();
        this.button7 = new JButton();
        this.button8 = new JButton();
        this.button9 = new JButton();

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
