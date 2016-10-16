package ru.reeson2003.Game.view;

import javax.swing.*;


/**
 * Created by Тоня on 16.10.2016.
 */
public abstract class IconManager {
    protected IconManager() {

    }
    public static IconManager getInstance() {
        return ConcreteIconManager.iconManager;
    }
    public abstract Icon getIcon(int id);
}
