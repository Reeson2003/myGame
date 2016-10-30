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

        this.setBackground(Colors.BACKGROUND);
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT, 2, false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN, 2, false);
        this.setBorder(BorderFactory.createCompoundBorder(out, in));
        int sizeX = emptyIcon().getIconWidth()*3;
        int sizeY = emptyIcon().getIconHeight()*3;
        this.setMaximumSize(new Dimension(sizeX, sizeY));
        this.setVisible(true);
    }
    public void buttonsSetIcons(Position position) {
        square5.setIcon(getIcon(position));
        if (position.getByDirection(Direction.North) != null) {
            square2.setIcon(getIcon(position.getByDirection(Direction.North)));
            if (position.getByDirection(Direction.North).getByDirection(Direction.West) != null)
                square1.setIcon(getIcon(position.getByDirection(Direction.North).getByDirection(Direction.West)));
            else
                square1.setIcon(emptyIcon());
            if (position.getByDirection(Direction.North).getByDirection(Direction.East) != null)
                square3.setIcon(getIcon(position.getByDirection(Direction.North).getByDirection(Direction.East)));
            else
                square3.setIcon(emptyIcon());
        } else {
            square1.setIcon(emptyIcon());
            square2.setIcon(emptyIcon());
            square3.setIcon(emptyIcon());
        }
        if (position.getByDirection(Direction.South) != null) {
            square8.setIcon(getIcon(position.getByDirection(Direction.South)));
            if (position.getByDirection(Direction.South).getByDirection(Direction.West) != null)
                square7.setIcon(getIcon(position.getByDirection(Direction.South).getByDirection(Direction.West)));
            else
                square7.setIcon(emptyIcon());
            if (position.getByDirection(Direction.South).getByDirection(Direction.East) != null)
                square9.setIcon(getIcon(position.getByDirection(Direction.South).getByDirection(Direction.East)));
            else
                square9.setIcon(emptyIcon());
        } else {
            square7.setIcon(emptyIcon());
            square8.setIcon(emptyIcon());
            square9.setIcon(emptyIcon());
        }
        if (position.getByDirection(Direction.West) != null) {
            square4.setIcon(getIcon(position.getByDirection(Direction.West)));
            if (position.getByDirection(Direction.West).getByDirection(Direction.North) != null)
                square1.setIcon(getIcon(position.getByDirection(Direction.West).getByDirection(Direction.North)));
            if (position.getByDirection(Direction.West).getByDirection(Direction.South) != null)
                square7.setIcon(getIcon(position.getByDirection(Direction.West).getByDirection(Direction.South)));
        } else
            square4.setIcon(emptyIcon());
        if (position.getByDirection(Direction.East) != null) {
            square6.setIcon(getIcon(position.getByDirection(Direction.East)));
            if (position.getByDirection(Direction.East).getByDirection(Direction.North) != null)
                square3.setIcon(getIcon(position.getByDirection(Direction.East).getByDirection(Direction.North)));
            if (position.getByDirection(Direction.East).getByDirection(Direction.South) != null)
                square9.setIcon(getIcon(position.getByDirection(Direction.East).getByDirection(Direction.South)));
        }else
            square6.setIcon(emptyIcon());
    }
    private Icon emptyIcon() {
        Icon result = new ImageIcon("icons/position/black.jpg");
        return result;
    }

    public void setPosition(Position position) {
        this.position = position;
        buttonsSetIcons(position);
    }

    public Icon getIcon(Position p) {
        Icon icon = emptyIcon();
        if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/nowere.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/n.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/s.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/e.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/w.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/ns.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/ne.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/nw.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/nse.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/nws.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/wne.jpg");
        else if (p.getByDirection(Direction.North) != null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/nwse.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) == null)
            icon = loadIcon("icons/position/se.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) == null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/sw.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) != null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/swe.jpg");
        else if (p.getByDirection(Direction.North) == null && p.getByDirection(Direction.South) == null
                && p.getByDirection(Direction.East) != null && p.getByDirection(Direction.West) != null)
            icon = loadIcon("icons/position/we.jpg");
        return icon;
    }
    private Icon loadIcon(String file) {
        /*
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            System.err.println("Can not load icon");
            e.printStackTrace();
        }
        */
        return new ImageIcon(file);
    }
}
