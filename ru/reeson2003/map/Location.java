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

    public Location(iLocationGenerator locGen) {
        this.positions = locGen.getPositions();
        setSize();
    }

    private void setSize() {
        if (positions != null) {
            width = positions[0].length;
            length = positions.length;
        }
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
}
