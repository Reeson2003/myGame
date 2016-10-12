package ru.reeson2003.map;

import java.io.Serializable;

/**
 * Created by Тоня on 30.09.2016.
 */
public class Location implements Serializable{
    private String name = "";
    private String info = "";
    private Position[][] positions;
    int width;
    int length;

    public Location() {

    }


    public Position getPosition(int x, int y) {
        if (x<0 || x>=width || y<0 || y >=length)
            throw new IndexOutOfBoundsException("Max X is: " + (width-1) + ", Max Y is: " + (length-1));
        else
            return positions[y][x];
    }
    public Position[][] getPositions() {
        return positions;
    }

    public void setInfo(String info) {
        if(info != null)
            this.info  = info;
    }
    public String getInfo() {
        return info;
    }

    public int getWidth() {
        return width;
    }
    public int getLength() {
        return length;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPositions(Position[][] positions) {
        this.positions = positions;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setLength(int length) {
        this.length = length;
    }
}
