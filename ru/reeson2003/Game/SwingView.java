package ru.reeson2003.Game;

import ru.reeson2003.Game.view.MapPanel;
import ru.reeson2003.map.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Тоня on 07.10.2016.
 */
public class SwingView implements iView {

    private Presenter presenter;
    private JFrame mainFrame;
    private JLabel mainFrameLabel;
    private KeyListener mainFrameKeyListener;

    private MapPanel mapPanel;

    private JFrame stringFrame;
    private JLabel stringLabel;

    private JFrame choiseFrame;
    public SwingView() {
        mainFrameInit();
        stringFrameInit();
        choiseFrameInit();
    }

    private void mainFrameInit() {
        this.mainFrame = new JFrame("Game");
        mainFrameKeyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                String result = new Character(e.getKeyChar()).toString().toUpperCase();
                presenter.setKeyAction(result);
            }
        };
        mainFrame.setSize(500,300);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocation(100,100);
        mainFrameLabel = new JLabel();
        mainFrame.addKeyListener(mainFrameKeyListener);
        mainFrame.add(mainFrameLabel, BorderLayout.CENTER);
        mapPanel = null;
        //mainFrame.setAlwaysOnTop(true);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void stringFrameInit() {
        stringFrame = new JFrame("");
        stringFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        stringFrame.setSize(300,110);
        stringFrame.setLayout(new FlowLayout());
        stringFrame.setResizable(false);
        stringLabel = new JLabel();
        stringFrame.add(stringLabel);
        JTextField stringTextField = new JTextField(20);
        stringFrame.add(stringTextField);
        JButton stringTextButton = new JButton("Enter");
        stringFrame.add(stringTextButton);
        stringTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = stringTextField.getText();
                if (!result.isEmpty()) {
                    presenter.setKeyAction(result);
                    stringFrame.setVisible(false);
                }
            }
        });
    }

    private void choiseFrameInit() {
        this.choiseFrame = new JFrame("");
        choiseFrame.setLayout(new FlowLayout());
        choiseFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void addListener(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void show(String s) {
        mainFrameLabel.setText(s);
    }

    public void show(Position position) {
        if (mapPanel == null) {
            this.mapPanel = new MapPanel();
            mainFrame.add(mapPanel, BorderLayout.EAST);
        }
        else
            mapPanel.buttonsSetIcons(position);
    }

    @Override
    public void showDialog(String invitation, String[] strings) {
        choiseFrame.setLocation(mainFrame.getX() + 50, mainFrame.getY() + 50);
        JButton[] buttons = new JButton[strings.length+1];
        for (int i = 0; i < strings.length; i++) {
            buttons[i] = new JButton(strings[i]);
        }
        buttons[strings.length] = new JButton("Cancel");
        for (int i = 0; i < buttons.length; i++) {
            String result = buttons[i].getText();
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    presenter.setChooseAction(result);
                    choiseFrame.setVisible(false);
                    choiseFrameInit();
                }
            });
            choiseFrame.add(buttons[i]);
        }
        choiseFrame.pack();
        choiseFrame.setVisible(true);

    }

    @Override
    public void showLineDialog(String invitation) {
        stringLabel.setText(invitation);
        stringFrame.setLocationRelativeTo(mainFrame);
        stringFrame.setVisible(true);
    }
    @Override
    public void showLineDialog(String invitation, int length) {
        stringLabel.setText(invitation);
        stringFrame.setVisible(true);
    }

    @Override
    public void waitAction() {
    }
}
