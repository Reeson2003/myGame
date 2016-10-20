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
        iconUrlMap.put(0,"icons/npcs/player.jpg");
        iconUrlMap.put(1,"icons/npcs/rabbit.jpg");
        iconUrlMap.put(2,"icons/npcs/rabbit2.jpg");
        iconUrlMap.put(3,"icons/npcs/medved.jpg");
        iconUrlMap.put(4, "icons/npcs/door.jpg");
        iconUrlMap.put(5,"icons/npcs/small_house.jpg");
    }

    @Override
    public Icon getIcon(int id) {
        return new ImageIcon(iconUrlMap.get(id));
    }
}
