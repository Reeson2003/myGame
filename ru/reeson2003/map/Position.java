package ru.reeson2003.map;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 28.09.2016.
 */
public class Position {
    private String info = "";
    private Coordinate coordinate;
    private Position north;
    private Position south;
    private Position east;
    private Position west;
    private List<Position> extraLinks;
    private List<Interactable> items;

    public Position(int X, int Y, String info) {
        this.coordinate = new Coordinate(X, Y);
        if (info != null)
            this.info = info;
        north = null;
        south = null;
        east = null;
        west = null;
        extraLinks = new LinkedList<>();
        items = new LinkedList<>();
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

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void addItem(Interactable item) {
        this.items.add(item);
    }

    public void deleteItem(Interactable item) {
        this.items.remove(item);
    }

    public List<Interactable> getItems() {
        return items;
    }

    public Position move(Direction dir) {
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

    public Position moveExtra(int number) {
        if(extraLinks.size()==0)
            throw new IllegalArgumentException("There is no extra links");
        else if (number <=0 || number> extraLinks.size())
            throw new IllegalArgumentException("Number of extra link must be between: " + 1
                                                + " and " + extraLinks.size());
        else
            return extraLinks.get(number-1);
    }

    public void moveItem(Interactable item, Position position) {
        //if (!(items.contains(item)))
        //    throw new IllegalArgumentException("Position does not contains this item");
        //else
            items.remove(item);
        position.addItem(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("You are at: ");
        sb.append(info);
        sb.append("\n- - - - - - - - - - - - - - - - - - - - - - - - -\n");
        sb.append("You can move to: |");
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
}
