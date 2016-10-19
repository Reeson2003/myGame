package ru.reeson2003.Game.view;

import ru.reeson2003.Game.controller.DirectionKeyListener;
import ru.reeson2003.npcs.Parameters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Тоня on 14.10.2016.
 */
public class CenterPanel extends JPanel {
    final static int CENTER_PANEL_WIDTH = 400;
    final static int IMAGE_LABEL_HEIGHT = 290;
    private JLabel imageLabel;
    private StatEnterWindow statEnterWindow;
    private TextPanel textPanel;

    public CenterPanel() {
        initialize();
    }

    private void initialize() {
        this.setPreferredSize(new Dimension(CENTER_PANEL_WIDTH, MainWindow.MAIN_FRAME_HEIGHT));
        this.setLayout(new BorderLayout());
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        imageLabel = new JLabel();
        imageLabel.setBorder(BorderFactory.createCompoundBorder(out,in));
        imageLabel.setPreferredSize(new Dimension(CENTER_PANEL_WIDTH,IMAGE_LABEL_HEIGHT));
        imageLabel.setAlignmentX(CENTER_ALIGNMENT);
//        imageLabel.setVisible(true);

        textPanel = new TextPanel();
        textPanel.setAlignmentX(CENTER_ALIGNMENT);
        statEnterWindow = StatEnterWindow.getInstance();
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.SOUTH);

    }

    public void showIcon(Icon icon) {
        this.imageLabel.setIcon(icon);
    }
    public void showText(String text) {
        String result = new String("<html>" + text + "</text>");
        this.textPanel.setText(result);
    }
    public void showParameters(Parameters parameters) {
        StatEnterWindow statEnterWindow = StatEnterWindow.getInstance();
        this.remove(textPanel);
        this.add(statEnterWindow, BorderLayout.CENTER);
        StatEnterWindow.getInstance().showStats(parameters);
    }
}
