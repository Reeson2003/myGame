package ru.reeson2003.Game;

import ru.reeson2003.map.Position;

/**
 * Created by Тоня on 04.10.2016.
 */
public interface iView{
    void addListener(Presenter presenter);
    void show(String s);
    void show(Position position);
    void showDialog(String invitation, String[] strings);
    void showLineDialog(String invitation, int length);
    void showLineDialog(String invitation);
    void waitAction();
}
