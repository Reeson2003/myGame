package ru.reeson2003.Game.view;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Тоня on 16.10.2016.
 */
final class ConcreteIconManager extends IconManager {
    final static IconManager iconManager = new ConcreteIconManager();
    private Map<Integer, String> iconMap = new HashMap<>();
    private ConcreteIconManager() {
        iconsUrlInit();
    }

    private void iconsUrlInit() {
        iconMap.put(1,"rabbit.jpg");
        iconMap.put(2,"rabbit2.jpg");
    }

    @Override
    public Icon getIcon(int id) {
        return new ImageIcon(iconMap.get(id));
    }
}
