package ru.reeson2003.tools;

import ru.reeson2003.map.Position;


public interface Interactable {
    void setPosition(Position position);
    String getInfo();
    String getName();
    int getID();
    void interact();
}
