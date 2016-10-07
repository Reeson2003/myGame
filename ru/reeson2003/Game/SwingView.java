package ru.reeson2003.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Тоня on 07.10.2016.
 */
public class SwingView implements iView {
    private Main_0 listener;

    private Presenter presenter;
    private JFrame frame;
    private JLabel label;
    public SwingView() {
        this.frame = new JFrame("Game");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        label = new JLabel();

        frame.add(label);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }

    public void addListener(Main_0 main_0) {
        this.listener = main_0;
    }
    @Override
    public void addListener(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void show(String s) {
        label.setText(s);
    }

    @Override
    public void showDialog(String invitation, String[] strings) {

    }

    @Override
    public void showLineDialog(String invitation, int length) {

    }

    @Override
    public void waitAction() {

    }
}
