package ru.reeson2003.map;

import ru.reeson2003.tools.Interactable;

import javax.swing.*;
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
    private List<Interactable> objects;
    private Icon icon;
    private Location location;
// TODO: 16.10.2016 syncronized(objects)
// TODO: 16.10.2016  убрать иконы в вид
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
        objects = new LinkedList<>();
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public void setNorth(Position north) {
        this.north = north;
        setIcon();
    }
    public void setSouth(Position south) {
        this.south = south;
        setIcon();
    }
    public void setEast(Position east) {
        this.east = east;
        setIcon();
    }
    public void setWest(Position west) {
        this.west = west;
        setIcon();
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
        setIcon();
    }
    public void deleteDirectionFromAnother(Direction direction) {
        switch (direction) {
            case South: {this.south.north = null; this.south.setIcon();}
                break;
            case North: {this.north.south = null; this.north.setIcon();}
                break;
            case East: {this.east.west = null; this.east.setIcon();}
                break;
            case West: {this.west.east = null; this.west.setIcon();}
        }
    }
    public void deleteDirectionTwoSide(Direction direction) {
        switch (direction) {
            case South: {this.south.north = null;this.south.setIcon(); this.south = null;}
                break;
            case North: {this.north.south = null; this.north.setIcon(); this.north = null;}
                break;
            case East: {this.east.west = null; this.east.setIcon(); this.east = null;}
                break;
            case West: {this.west.east = null; this.west.setIcon(); this.west = null;}
        }
        setIcon();
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
            icon = loadIcon("nowere.jpg");
        else if (north != null && south == null && east == null && west == null)
            icon = loadIcon("n.jpg");
        else if (north == null && south != null && east == null && west == null)
            icon = loadIcon("s.jpg");
        else if (north == null && south == null && east != null && west == null)
            icon = loadIcon("e.jpg");
        else if (north == null && south == null && east == null && west != null)
            icon = loadIcon("w.jpg");
        else if (north != null && south != null && east == null && west == null)
            icon = loadIcon("ns.jpg");
        else if (north != null && south == null && east != null && west == null)
            icon = loadIcon("ne.jpg");
        else if (north != null && south == null && east == null && west != null)
            icon = loadIcon("nw.jpg");
        else if (north != null && south != null && east != null && west == null)
            icon = loadIcon("nse.jpg");
        else if (north != null && south != null && east == null && west != null)
            icon = loadIcon("nws.jpg");
        else if (north != null && south == null && east != null && west != null)
            icon = loadIcon("wne.jpg");
        else if (north != null && south != null && east != null && west != null)
            icon = loadIcon("nwse.jpg");
        else if (north == null && south != null && east != null && west == null)
            icon = loadIcon("se.jpg");
        else if (north == null && south != null && east == null && west != null)
            icon = loadIcon("sw.jpg");
        else if (north == null && south != null && east != null && west != null)
            icon = loadIcon("swe.jpg");
        else if (north == null && south == null && east != null && west != null)
            icon = loadIcon("we.jpg");
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

    public Position moveByDirection(Direction dir) {
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

    public Position getByDirection(Direction dir) {
        if(dir == Direction.South)
            return south;
        else if(dir == Direction.North)
            return north;
        else if(dir == Direction.East)
            return east;
        else
            return west;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are at: ");
        sb.append(info);
        sb.append("\n- - - - - - - - - - - - - - - - - - - - - - - - -\n");
        sb.append("You can moveByDirection to: |");
        if(south != null)
            sb.append("South|");
        if(north != null)
            sb.append("North|");
        if(east != null)
            sb.append("East|");
        if(west != null)
            sb.append("West|");
        sb.append("\nExtra links: |");
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
