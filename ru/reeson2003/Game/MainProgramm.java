package ru.reeson2003.Game;

import ru.reeson2003.Game.ConsoleView;
import ru.reeson2003.Game.Game;
import ru.reeson2003.Game.Presenter;


/**
 * Created by Тоня on 28.09.2016.
 */
public class MainProgramm {
    public static void main(String[] args) {
        //ConsoleView view = new ConsoleView();
        SwingView swingView = new SwingView();
        Presenter presenter = Presenter.getInstance(swingView);
        Game game = Game.getInstance(presenter);
        try {
            game.PLAY();
        } catch (NullPointerException e) {
            e.printStackTrace(System.err);
            System.exit(5);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.err);
            System.exit(6);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(7);
        }
    }
}
