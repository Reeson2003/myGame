package ru.reeson2003.Game;

/**
 * Created by Тоня on 08.10.2016.
 */
public interface iTimeActivator extends Runnable {
    void addTimeListener(iTimeActing timeActing);
    void timeActivate();
}
