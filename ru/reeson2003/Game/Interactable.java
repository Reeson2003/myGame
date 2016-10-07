package ru.reeson2003.Game;

import ru.reeson2003.map.Position;
import ru.reeson2003.player.Player;

public interface Interactable {
    void setPosition(Position position);
    String getInfo();
    String getName();
    void interact(Player player, Game game);
}
