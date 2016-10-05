package ru.reeson2003.Game;

import ru.reeson2003.Game.ConsoleView;
import ru.reeson2003.Game.Game;
import ru.reeson2003.Game.Presenter;


/**
 * Created by Тоня on 28.09.2016.
 */
public class MainProgramm {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        Presenter presenter = Presenter.getInstance(view);
        Game game = Game.getInstance(presenter);
        game.PLAY();
    }
}
