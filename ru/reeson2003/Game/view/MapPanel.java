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

    public MapPanel(Position position) {
        initialize(position);
    }

    private void initialize(Position position) {
        this.setLayout(new GridLayout(3, 3));
        int x = position.getCoordinate().getX();
        int y = position.getCoordinate().getY();
        int width = position.getLocation().getWidth();
        int length = position.getLocation().getLength();

        initializeButtons(position);
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
        this.setMaximumSize(new Dimension(90, 90));
        this.setVisible(true);
    }

    private void initializeButtons(Position position) {
        square5 = new JButton(position.getIcon());
        if (position.getByDirection(Direction.North) != null) {
            square2 = new JButton(position.getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.North).getByDirection(Direction.West) != null)
                square1 = new JButton(position.getByDirection(Direction.North).getByDirection(Direction.West).getIcon());
            else
                square1 = new JButton(emptyIcon());
            if (position.getByDirection(Direction.North).getByDirection(Direction.East) != null)
                square3 = new JButton(position.getByDirection(Direction.North).getByDirection(Direction.East).getIcon());
            else
                square3 = new JButton(emptyIcon());
        } else {
            square1 = new JButton(emptyIcon());
            square2 = new JButton(emptyIcon());
            square3 = new JButton(emptyIcon());
        }
        if (position.getByDirection(Direction.South) != null) {
            square8 = new JButton(position.getByDirection(Direction.South).getIcon());
            if (position.getByDirection(Direction.South).getByDirection(Direction.West) != null)
                square7 = new JButton(position.getByDirection(Direction.South).getByDirection(Direction.West).getIcon());
            else
                square7 = new JButton(emptyIcon());
            if (position.getByDirection(Direction.South).getByDirection(Direction.East) != null)
                square9 = new JButton(position.getByDirection(Direction.South).getByDirection(Direction.East).getIcon());
            else
                square9 = new JButton(emptyIcon());
        } else {
            square7 = new JButton(emptyIcon());
            square8 = new JButton(emptyIcon());
            square9 = new JButton(emptyIcon());
        }
        if (position.getByDirection(Direction.West) != null) {
            square4 = new JButton(position.getByDirection(Direction.West).getIcon());
            if (position.getByDirection(Direction.West).getByDirection(Direction.North) != null)
                square1.setIcon(position.getByDirection(Direction.West).getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.West).getByDirection(Direction.South) != null)
                square7.setIcon(position.getByDirection(Direction.West).getByDirection(Direction.South).getIcon());
        } else
            square4 = new JButton(emptyIcon());
        if (position.getByDirection(Direction.East) != null) {
            square6 = new JButton(position.getByDirection(Direction.East).getIcon());
            if (position.getByDirection(Direction.East).getByDirection(Direction.North) != null)
                square3.setIcon(position.getByDirection(Direction.East).getByDirection(Direction.North).getIcon());
            if (position.getByDirection(Direction.East).getByDirection(Direction.South) != null)
                square9.setIcon(position.getByDirection(Direction.East).getByDirection(Direction.South).getIcon());
        }else
            square6 = new JButton(emptyIcon());
    }

    private Icon emptyIcon() {
        Icon result = new ImageIcon("black.jpg");
        return result;
    }
}
