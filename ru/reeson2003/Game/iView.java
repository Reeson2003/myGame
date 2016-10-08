package ru.reeson2003.Game;

/**
 * Created by Тоня on 04.10.2016.
 */
public interface iView{
    void addListener(Presenter presenter);
    void show(String s);
    void showDialog(String invitation, String[] strings);
    void showLineDialog(String invitation, int length);
    void showLineDialog(String invitation);
    void waitAction();
}
