package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 15.10.2016.
 */
public class TextPanel extends JPanel {
    private JLabel textLabel;
    final static int HEIGHT = 110;
    final static int TEXT_SIZE = 12;

    public TextPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT,2,false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN,2,false);
        this.setBackground(Colors.BACKGROUND);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        textLabel = new JLabel("", SwingConstants.CENTER);
        textLabel.setAlignmentX(CENTER_ALIGNMENT);
        textLabel.setPreferredSize(new Dimension(CenterPanel.WIDTH, HEIGHT));
        textLabel.setFont(new Font("Arial", Font.BOLD, TEXT_SIZE));
        textLabel.setForeground(Colors.FOREGROUND);
        textLabel.setBackground(Colors.BACKGROUND);

        this.add(textLabel);
    }

    // TODO: 20.10.2016 реализовать вывод каждой новой информации с новой строки
    // TODO: 20.10.2016 без потери предыдущей.
    // TODO: 20.10.2016 сделать ограничение количества строк либо полосу прокрутки
    public void showText(String text) {
        String result = new String("<html>" + text + "</text>");
        textLabel.setText(result);
    }

}
