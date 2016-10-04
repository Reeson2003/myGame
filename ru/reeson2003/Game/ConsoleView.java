package ru.reeson2003.Game;

import java.util.Scanner;

/**
 * Created by Тоня on 04.10.2016.
 */
public class ConsoleView implements iView {
    Presenter presenter;

    @Override
    public void addListener(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void show(String s) {
        System.out.println(s);
    }

    @Override
    public void showDialog(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println((i+1) + "." + strings[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        while (result <= 0 || result>strings.length)
            result = scanner.nextInt();
         presenter.setAction(strings[result]);
    }


}
