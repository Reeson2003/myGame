package ru.reeson2003.Game.controller.swingControler;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.Game.model.map.Direction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 16.10.2016.
 */
public class ArrowsButtonListener implements ActionListener {
    private Direction direction;
    public ArrowsButtonListener(Direction direction) {
        this.direction = direction;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.getInstance().setDirection(direction);
    }
}
