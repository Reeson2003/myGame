package ru.reeson2003.Game;

import java.util.Scanner;

/**
 * Created by Тоня on 07.10.2016.
 */
public class Main_0 {
    String action = null;
    public static void main(String[] args) throws InterruptedException {
        SwingView view = new SwingView();
        Scanner scanner = new Scanner(System.in);

    }

    synchronized void setAction(String action) {
        this.action = action;
    }
}
