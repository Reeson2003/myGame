package ru.reeson2003.Game.view;

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
        this.imageLabel = new JLabel();
        this.imageLabel.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.imageLabel.setPreferredSize(new Dimension(CENTER_PANEL_WIDTH,IMAGE_LABEL_HEIGHT));
        this.imageLabel.setAlignmentX(CENTER_ALIGNMENT);
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X: " + e.getX() + " Y: " + e.getY());
            }
        });
        this.textPanel = new TextPanel();
        this.textPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(imageLabel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.SOUTH);

    }
    public void setIcon(Icon icon) {
        this.imageLabel.setIcon(icon);
    }
    public void setText(String text) {
        String result = new String("<html>" + text + "</text>");
        this.textPanel.setText(result);
    }
}
