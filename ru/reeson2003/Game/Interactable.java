package ru.reeson2003.Game;

import ru.reeson2003.map.Position;

public interface Interactable {
    void setPosition(Position position);
    String getInfo();
    String getName();
    void interact(Interactable something);
}
