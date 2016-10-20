package ru.reeson2003.Game.controller;

import ru.reeson2003.Game.model.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 19.10.2016.
 */
public class StatsButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Game.getInstance().showPlayerStats();
    }
}
