package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static ru.reeson2003.Game.view.CenterPanel.CENTER_PANEL_WIDTH;

/**
 * Created by Тоня on 15.10.2016.
 */
public class TextPanel extends JPanel {
    private JLabel textLabel;
    final static int TEXT_PANEL_HEIGHT = 110;

    public TextPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        textLabel = new JLabel();
        textLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.textLabel.setPreferredSize(new Dimension(CENTER_PANEL_WIDTH,TEXT_PANEL_HEIGHT));
        this.textLabel.setFont(new Font("Arial", Font.BOLD,12));
        this.textLabel.setForeground(Color.ORANGE);
        this.textLabel.setBackground(Color.DARK_GRAY);

        this.add(textLabel);
    }

    public void setText(String text) {
        this.textLabel.setText(text);
    }

}
