package ru.reeson2003.Game.view;

import ru.reeson2003.map.Position;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 12.10.2016.
 */
public class MapPanel extends JPanel {

    private JButton square1;
    private JButton square2;
    private JButton square3;
    private JButton square4;
    private JButton square5;
    private JButton square6;
    private JButton square7;
    private JButton square8;
    private JButton square9;

    public MapPanel(Position position) {
        initialize(position);
    }

    private void initialize(Position position) {
        this.setLayout(new GridLayout(3,3));
        int x = position.getCoordinate().getX();
        int y = position.getCoordinate().getY();
        


        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.setMaximumSize(new Dimension(90,90));
        this.setVisible(true);
    }
}
