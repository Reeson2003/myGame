package ru.reeson2003.Game.view;

import ru.reeson2003.map.Direction;
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

    private Position position;

    public MapPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridLayout(3, 3));
        this.square1= new JButton();
        this.square2= new JButton();
        this.square3= new JButton();
        this.square4= new JButton();
        this.square5= new JButton();
        this.square6= new JButton();
        this.square7= new JButton();
        this.square8= new JButton();
        this.square9= new JButton();

        this.add(square1);
        this.add(square2);
        this.add(square3);
        this.add(square4);
        this.add(square5);
        this.add(square6);
        this.add(square7);
        this.add(square8);
        this.add(square9);

        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK, 2, false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE, 2, false);
        this.setBorder(BorderFactory.createCompoundBorder(out, in));
        int sizeX = emptyIcon().getIconWidth()*3;
        int sizeY = emptyIcon().getIconHeight()*3;
        this.setMaximumSize(new Dimension(sizeX, sizeY));
        this.setVisible(true);
    }
    public void buttonsSetIcons(Position position) {
        square5.setIcon(position.getIcon());
        if (position.getByDirection(Direction.North) != null) {
            square2.setIcon(position.getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.North).getByDirection(Direction.West) != null)
                square1.setIcon(position.getByDirection(Direction.North).getByDirection(Direction.West).getIcon());
            else
                square1.setIcon(emptyIcon());
            if (position.getByDirection(Direction.North).getByDirection(Direction.East) != null)
                square3.setIcon(position.getByDirection(Direction.North).getByDirection(Direction.East).getIcon());
            else
                square3.setIcon(emptyIcon());
        } else {
            square1.setIcon(emptyIcon());
            square2.setIcon(emptyIcon());
            square3.setIcon(emptyIcon());
        }
        if (position.getByDirection(Direction.South) != null) {
            square8.setIcon(position.getByDirection(Direction.South).getIcon());
            if (position.getByDirection(Direction.South).getByDirection(Direction.West) != null)
                square7.setIcon(position.getByDirection(Direction.South).getByDirection(Direction.West).getIcon());
            else
                square7.setIcon(emptyIcon());
            if (position.getByDirection(Direction.South).getByDirection(Direction.East) != null)
                square9.setIcon(position.getByDirection(Direction.South).getByDirection(Direction.East).getIcon());
            else
                square9.setIcon(emptyIcon());
        } else {
            square7.setIcon(emptyIcon());
            square8.setIcon(emptyIcon());
            square9.setIcon(emptyIcon());
        }
        if (position.getByDirection(Direction.West) != null) {
            square4.setIcon(position.getByDirection(Direction.West).getIcon());
            if (position.getByDirection(Direction.West).getByDirection(Direction.North) != null)
                square1.setIcon(position.getByDirection(Direction.West).getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.West).getByDirection(Direction.South) != null)
                square7.setIcon(position.getByDirection(Direction.West).getByDirection(Direction.South).getIcon());
        } else
            square4.setIcon(emptyIcon());
        if (position.getByDirection(Direction.East) != null) {
            square6.setIcon(position.getByDirection(Direction.East).getIcon());
            if (position.getByDirection(Direction.East).getByDirection(Direction.North) != null)
                square3.setIcon(position.getByDirection(Direction.East).getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.East).getByDirection(Direction.South) != null)
                square9.setIcon(position.getByDirection(Direction.East).getByDirection(Direction.South).getIcon());
        }else
            square6.setIcon(emptyIcon());
    }
    private Icon emptyIcon() {
        Icon result = new ImageIcon("black.jpg");
        return result;
    }

    public void setPosition(Position position) {
        this.position = position;
        buttonsSetIcons(position);
    }
}
