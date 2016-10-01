package ru.reeson2003.map;

import java.io.Serializable;

/**
 * Created by Тоня on 28.09.2016.
 */
public class Coordinate implements Serializable{
    private int X;
    private int Y;

    public Coordinate(int X, int Y) {
        if (X >= 0)
            this.X = X;
        else
            this.X = 0;
        if (Y >= 0)
            this.Y = Y;
        else
            this.Y = 0;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public boolean equals(Object check) {
        if (!(check instanceof Coordinate))
            return false;
        else {
            if(this.X == ((Coordinate) check).getX() && this.Y == ((Coordinate) check).getY())
                return true;
            else
                return false;
        }
    }
}
