package ru.reeson2003.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Тоня on 07.10.2016.
 */
public class SwingView implements iView {

    private Presenter presenter;
    private JFrame frame;
    private JLabel label;
    private KeyListener keyListener;
    public SwingView() {
        this.frame = new JFrame("Game");
        keyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String result = new Character(e.getKeyChar()).toString().toUpperCase();
                presenter.setAction(result);
            }
        };
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        label = new JLabel();

        frame.addKeyListener(keyListener);
        frame.add(label);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append(invitation);
        stringBuilder.append("<br>0.Cancel");
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append("<br>");
            stringBuilder.append(i+1);
            stringBuilder.append(".");
            stringBuilder.append(strings[i]);
        }
        show(stringBuilder.toString());
    }

    @Override
    public void showLineDialog(String invitation, int length) {
        presenter.setAction("Reeson");
    }

    @Override
    public void waitAction() {
    }
}
