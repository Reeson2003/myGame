package ru.reeson2003.Game;

/**
 * Created by Тоня on 04.10.2016.
 */
public interface iView{
    void addListener(Presenter presenter);
    void show(String s);
    void showDialog(String[] strings);
}
