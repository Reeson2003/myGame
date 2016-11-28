package ru.reeson2003.Game.controller.swingControler;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.Game.model.map.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Тоня on 17.10.2016.
 */
public class DirectionKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        switch (key) {
            case 'w':
            case 'W':
                Game.getInstance().setDirection(Direction.North);
                break;
            case 's':
            case 'S':
                Game.getInstance().setDirection(Direction.South);
                break;
            case 'a':
            case 'A':
                Game.getInstance().setDirection(Direction.West);
                break;
            case 'd':
            case 'D':
                Game.getInstance().setDirection(Direction.East);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
