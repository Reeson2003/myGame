package ru.reeson2003.Game.model.tools;

import ru.reeson2003.Game.model.map.Position;


public interface Interactable {
    void setPosition(Position position);
    String getInfo();
    String getName();
    int getID();
    void interact();
}
