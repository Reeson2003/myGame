package ru.reeson2003.Game.model;

import ru.reeson2003.Game.model.map.Direction;
import ru.reeson2003.Game.model.map.Map;
import ru.reeson2003.Game.model.map.MapFactory;
import ru.reeson2003.Game.model.map.Position;
import ru.reeson2003.Game.model.tools.Interactable;
import ru.reeson2003.Game.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by Toshiba on 27.11.2016.
 */
public class Main3 {
    public static void main(String[] args) {
        Map map = MapFactory.getMap();
        View cv = View.getInstance();
        Position current = map.getStart();
        while (true) {
            char dir = getKey();
            if (dir == 'w')
                current = current.moveByDirection(Direction.North);
            else if (dir == 's')
                current = current.moveByDirection(Direction.South);
            else if (dir == 'a')
                current = current.moveByDirection(Direction.West);
            else if (dir == 'd')
                current = current.moveByDirection(Direction.East);
            cv.show(current);
        }

    }
    public static char getKey() {
        Reader rd = new BufferedReader(new InputStreamReader(System.in));
        char ch[] = new char[1];
        try {
            rd.read(ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ch[0];
    }
}
