package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 12.10.2016.
 */
public class RightPanel extends JPanel {

    public RightPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        ArrowsPanel arrowsPanel = new ArrowsPanel();
        this.add(arrowsPanel);
        arrowsPanel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        this.setVisible(true);
    }
}
