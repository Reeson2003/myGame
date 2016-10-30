package ru.reeson2003.Game.view;

import ru.reeson2003.map.Position;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Тоня on 12.10.2016.
 */
public class RightPanel extends JPanel {
    final static int WIDTH = 110;

    private MapPanel mapPanel;
    private ArrowsPanel arrowsPanel;
    private IconsPanel iconsPanel;

    // TODO: 21.10.2016 заменить цвета на константы
    public RightPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT,2,false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN,2,false);
        this.setBackground(Colors.BACKGROUND);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.arrowsPanel = new ArrowsPanel();
        arrowsPanel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        this.mapPanel = new MapPanel();
        mapPanel.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        this.iconsPanel = new IconsPanel();
        this.add(mapPanel);
        this.add(arrowsPanel);
        this.add(iconsPanel);
        this.setPreferredSize(new Dimension(WIDTH, MainWindow.HEIGHT));
        this.setVisible(true);
    }

    public void setPosition(Position position) {
        this.mapPanel.setPosition(position);
    }
}
