package ru.reeson2003.map;

import ru.reeson2003.Game.Interactable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 28.09.2016.
 */
public class Position implements Serializable{
    private String info;
    private Coordinate coordinate;
    private Position north;
    private Position south;
    private Position east;
    private Position west;
    private List<Position> extraLinks;
    private List<Interactable> objects;
    private Icon icon;

    public Position(int X, int Y, String info) {
        this.coordinate = new Coordinate(X, Y);
        if (info != null)
            this.info = info;
        else
            this.info = "@NoInfo";
        north = null;
        south = null;
        east = null;
        west = null;
        extraLinks = new LinkedList<>();
        objects = new LinkedList<>();
    }

    public void setNorth(Position north) {
        this.north = north;
    }
    public void setSouth(Position south) {
        this.south = south;
    }
    public void setEast(Position east) {
        this.east = east;
    }
    public void setWest(Position west) {
        this.west = west;
    }
    public void deleteDirectionFromThis(Direction direction) {
        switch (direction) {
            case South: this.south = null;
                break;
            case North: this.north = null;
                break;
            case East: this.east = null;
                break;
            case West: this.west = null;
        }
    }
    public void deleteDirectionFromAnother(Direction direction) {
        switch (direction) {
            case South: this.south.north = null;
                break;
            case North: this.north.south = null;
                break;
            case East: this.east.west = null;
                break;
            case West: this.west.east = null;
        }
    }
    public void deleteDirectionTwoSide(Direction direction) {
        switch (direction) {
            case South: {this.south = null; this.south.north = null;}
                break;
            case North: {this.north = null; this.north.south = null;}
                break;
            case East: {this.east = null; this.east.west = null;}
                break;
            case West: {this.west = null; this.west.east = null;}
        }
    }
    public List<Direction> getAvailableDirections() {
        List<Direction> directions = new ArrayList<>(8);
        if(south != null)
            directions.add(Direction.South);
        if(north != null)
            directions.add(Direction.North);
        if(east != null)
            directions.add(Direction.East);
        if(west != null)
            directions.add(Direction.West);
        return directions;
    }

    public void setExtraLinkToThis(Position another) {
        this.extraLinks.add(another);
    }
    public void setExtraLinkToAnother(Position another) {
        another.extraLinks.add(this);
    }
    public void setExtraLinkTwoSide(Position another) {
        this.extraLinks.add(another);
        another.extraLinks.add(this);
    }
    public void deleteExtraLinkFromThis(Position another) {
        this.extraLinks.remove(another);
    }
    public void deleteExtraLinkFromAnother(Position another) {
        another.extraLinks.remove(this);
    }
    public void deleteExtraLinkTwoSide(Position another) {
        another.extraLinks.remove(this);
        this.extraLinks.remove(another);
    }
    public String[] getExtraLinksInfos() {
        String[] result = new String[extraLinks.size()];
        for (int i = 0; i< extraLinks.size(); i++) {
            result[i] = extraLinks.get(i).getInfo();
        }
        return result;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void setIcon() {
        if (north == null && south == null && east == null && west == null)
            loadIcon("icons/nowere.bmp");
        else if (north != null && south == null && east == null && west == null)
            loadIcon("icons/n.bmp");
        else if (north == null && south != null && east == null && west == null)
            loadIcon("icons/s.bmp");
        else if (north == null && south == null && east != null && west == null)
            loadIcon("icons/e.bmp");
        else if (north == null && south == null && east == null && west != null)
            loadIcon("icons/w.bmp");

        else if (north != null && south != null && east == null && west == null)
            loadIcon("icons/ns.bmp");
        else if (north != null && south == null && east != null && west == null)
            loadIcon("icons/ne.bmp");
        else if (north != null && south == null && east == null && west != null)
            loadIcon("icons/nw.bmp");
        else if (north != null && south != null && east != null && west == null)
            loadIcon("icons/nse.bmp");
        else if (north != null && south != null && east == null && west != null)
            loadIcon("icons/nws.bmp");
        else if (north != null && south == null && east != null && west != null)
            loadIcon("icons/wne.bmp");
        else if (north != null && south != null && east != null && west != null)
            loadIcon("icons/nwse.bmp");

        else if (north == null && south != null && east != null && west == null)
            loadIcon("icons/se.bmp");
        else if (north == null && south != null && east == null && west != null)
            loadIcon("icons/sw.bmp");
        else if (north == null && south != null && east != null && west != null)
            loadIcon("icons/swe.bmp");
        else if (north == null && south == null && east != null && west != null)
            loadIcon("icons/we.bmp");

    }

    private Icon loadIcon(String file) {
        Image image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(file));
        } catch (IOException e) {
            System.err.println("Can not load icon");
            e.printStackTrace();
        }
        return new ImageIcon(image);
    }
    public Icon getIcon() {
        return icon;
    }

    public void addObject(Interactable object) {
        this.objects.add(object);
    }
    public Interactable getObject(int n) {
        if (n < 0 || (n+1) > objects.size()) {
            throw new IllegalArgumentException("No item with this index");
        }
        else {
            Interactable result = objects.get(n);
            objects.remove(n);
            return result;
        }
    }
    public void removeObject(int n) {
        if (n < 0 || (n+1) > objects.size()) {
            throw new IllegalArgumentException("No item with this index");
        }
        else {
            objects.remove(n);
        }
    }
    public void removeObject(Interactable object) {
        this.objects.remove(object);
    }
    public String[] getObjectsNames() {

        String[] result =new String[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            result[i] = objects.get(i).getName();
        }
        return result;
    }
    public String[] getObjectsInfos() {
        String[] result =new String[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            result[i] = objects.get(i).getInfo();
        }
        return result;
    }

    public Position getByDirection(Direction dir) {
        if(dir == Direction.South && south != null)
            return south;
        else if(dir == Direction.North && north != null)
            return north;
        else if(dir == Direction.East && east != null)
            return east;
        else if(dir == Direction.West && west != null)
            return west;
        else
            return this;

    }
    public Position getExtraLink(int number) {
        if(extraLinks.size()==0)
            throw new IllegalArgumentException("There is no extra links");
        else if (number <0 || number >= extraLinks.size())
            throw new IllegalArgumentException("Number of extra link must be between: " + 1
                                                + " and " + extraLinks.size());
        else
            return extraLinks.get(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are at: ");
        sb.append(info);
        sb.append("\n- - - - - - - - - - - - - - - - - - - - - - - - -\n");
        sb.append("You can getByDirection to: |");
        if(south != null)
            sb.append("South|");
        if(north != null)
            sb.append("North|");
        if(east != null)
            sb.append("East|");
        if(west != null)
            sb.append("West|");
        sb.append("\nExtra links: |");
        for(int i = 0;i<extraLinks.size();i++) {
            sb.append(i+1);
            sb.append("-");
            sb.append(extraLinks.get(i).info);
            sb.append("|");
        }
        return sb.toString();
    }
    @Deprecated
    public void moveObject(Interactable object, Position position) {
            objects.remove(object);
        position.addObject(object);
    }
    @Deprecated
    public List<Interactable> getObjects() {
        return objects;
    }
}
