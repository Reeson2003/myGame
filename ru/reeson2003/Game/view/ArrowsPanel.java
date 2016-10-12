package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        /*
        JButton upButton = new JButton("  ^  ");
        upButton.setSize(30,30);
        upButton.setBackground(new Color(160,160,160));
        upButton.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        JButton downButton = new JButton("  v  ");
        downButton.setSize(30,30);
        downButton.setBackground(new Color(160,160,160));
        downButton.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        JButton leftButton = new JButton("   <   ");
        leftButton.setSize(30,30);
        leftButton.setBackground(new Color(160,160,160));
        leftButton.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        JButton rightButton = new JButton("   >   ");
        rightButton.setSize(30,30);
        rightButton.setBackground(new Color(160,160,160));
        rightButton.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));

        JButton centerButton = new JButton(" o ");
        centerButton.setSize(30,30);
        centerButton.setBackground(new Color(160,160,160));
        centerButton.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        */
        this.upButton = getButton("up.jpg");
        this.downButton = getButton("down.jpg");
        this.leftButton = getButton("left.jpg");
        this.rightButton = getButton("right.jpg");



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

        this.setVisible(true);
    }

    private JButton getButton(String file) {
        ImageIcon icon  = new ImageIcon(file);
        JButton button = new JButton(icon);
        //button.setSize(30,30);
        //button.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(file);
            }
        });
        return  button;
    }
}
