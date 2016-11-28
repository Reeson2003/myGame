package ru.reeson2003.Game.view;

import ru.reeson2003.Game.model.map.Position;
import ru.reeson2003.Game.model.npcs.Parameters;
import ru.reeson2003.Game.model.player.Player;
import ru.reeson2003.Game.model.tools.Fight;

/**
 * Created by Toshiba on 27.11.2016.
 */
public interface NewView {
    void show(Position position);
    void show(Fight fight);
    void show(Player player);
    void show(Parameters parameters);
    void show(String text);
}
