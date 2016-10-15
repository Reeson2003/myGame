package ru.reeson2003.Game.view;

import javafx.geometry.Pos;
import ru.reeson2003.map.Position;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 12.10.2016.
 */
public class RightPanel extends JPanel {
    final static int RIGHT_PANEL_WIDTH = 110;

    private MapPanel mapPanel;
    private ArrowsPanel arrowsPanel;
    private IconsPanel iconsPanel;

    public RightPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.arrowsPanel = new ArrowsPanel();
        arrowsPanel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        this.mapPanel = new MapPanel();
        mapPanel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        this.iconsPanel = new IconsPanel();
        this.add(mapPanel);
        this.add(arrowsPanel);
        this.add(iconsPanel);
        this.setPreferredSize(new Dimension(RIGHT_PANEL_WIDTH, MainWindow.MAIN_FRAME_HEIGHT));
        this.setVisible(true);
    }

    public void setPosition(Position position) {
        this.mapPanel.setPosition(position);
    }
}
