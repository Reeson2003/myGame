package ru.reeson2003.Game.controller;

import ru.reeson2003.tools.Interactable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 16.10.2016.
 */
public class ObjectButtonListener implements ActionListener {
    private Interactable object;
    public ObjectButtonListener(Interactable object) {
        this.object = object;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        object.interact();
    }
}
