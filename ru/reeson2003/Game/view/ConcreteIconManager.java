package ru.reeson2003.Game.view;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Тоня on 16.10.2016.
 */
final class ConcreteIconManager extends IconManager {
    final static IconManager iconManager = new ConcreteIconManager();
    private Map<Integer, String> iconUrlMap = new HashMap<>();
    private Map<Integer, Icon> iconMap = new HashMap<>();
    private ConcreteIconManager() {
        iconsUrlInit();
    }

    private void iconsUrlInit() {
        iconUrlMap.put(0,"player.jpg");
        iconUrlMap.put(1,"rabbit.jpg");
        iconUrlMap.put(2,"rabbit2.jpg");
        iconUrlMap.put(3,"medved.jpg");
    }

    @Override
    public Icon getIcon(int id) {
        return new ImageIcon(iconUrlMap.get(id));
    }
}
