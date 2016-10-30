package ru.reeson2003.Game.view;

import ru.reeson2003.npcs.Parameters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 14.10.2016.
 */
public class CenterPanel extends JPanel {
    final static int WIDTH = 400;
    final static int IMAGE_LABEL_HEIGHT = 290;
    private JLabel imageLabel;
    private StatEnterWindow statEnterWindow;
    private TextPanel textPanel;

    public CenterPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(WIDTH, MainWindow.HEIGHT));
        this.setLayout(new BorderLayout());
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT,2,false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN,2,false);
        this.setBackground(Colors.BACKGROUND);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        imageLabel = new JLabel();
        imageLabel.setBorder(BorderFactory.createCompoundBorder(out,in));
        imageLabel.setPreferredSize(new Dimension(WIDTH,IMAGE_LABEL_HEIGHT));
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);

        textPanel = new TextPanel();
        textPanel.setAlignmentX(CENTER_ALIGNMENT);
        statEnterWindow = new StatEnterWindow();
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.SOUTH);

    }

    public void showIcon(Icon icon) {
        this.remove(statEnterWindow);
        imageLabel.setIcon(icon);
        this.add(imageLabel, BorderLayout.CENTER);
        repaint();
        validate();
    }
    public void showText(String text) {
        textPanel.showText(text);
    }
    public void showParameters(Parameters parameters) {
        this.remove(imageLabel);
        this.add(statEnterWindow, BorderLayout.CENTER);
        statEnterWindow.showStats(parameters);
        repaint();
        validate();
    }
}
