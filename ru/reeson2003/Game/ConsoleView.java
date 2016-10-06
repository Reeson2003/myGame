package ru.reeson2003.Game;

import java.util.Scanner;

/**
 * Created by Тоня on 04.10.2016.
 */
public class ConsoleView implements iView {
    Presenter presenter;
    Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addListener(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void show(String s) {
        System.out.println(s);
    }
    @Override
    public void showDialog(String invitation, String[] strings) {
        System.out.print(invitation);
        for (int i = 0; i < strings.length; i++) {
            System.out.println((i+1) + "." + strings[i]);
        }
        int result = scanner.nextInt();
        while (result <= 0 || result>strings.length)
            result = scanner.nextInt();
         presenter.setAction(strings[result-1]);
    }
    @Override
    public void showLineDialog(String invitation, int length) {
        System.out.println(invitation);
        String result;
        do {
            result = scanner.nextLine();
        } while (result.length() > length);
        presenter.setAction(result);
    }
    @Override
    public void waitAction() {
        //String result;
        do {
            result = scanner.nextLine();
            result = result.toUpperCase();
        } while (result != "I" ||
                result != "E" ||
                result != "P" ||
                result != "M" ||
                result != "U" ||
                result != "W" ||
                result != "S" ||
                result != "D" ||
                result == "A");
        presenter.setAction(result);
    }
}
