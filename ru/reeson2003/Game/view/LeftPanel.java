package ru.reeson2003.Game.view;

import ru.reeson2003.Game.controller.ObjectButtonListener;
import ru.reeson2003.tools.Interactable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 12.10.2016.
 */
public class LeftPanel extends JPanel {
    final static int LEFT_PANEL_WIDTH = 110;
    private InteractableDialog interactableDialog;

    public LeftPanel() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        this.setAlignmentY(JComponent.TOP_ALIGNMENT);
        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, MainWindow.MAIN_FRAME_HEIGHT));
        this.setVisible(true);
    }

    public void setObjects(List<Interactable> objects) {
        this.removeAll();
        synchronized (objects) {
            for (Interactable i :
                    objects) {
                int id = i.getID();
                Icon icon = IconManager.getInstance().getIcon(id);
                JButton button = new JButton(icon);
                this.add(button);
                button.setBackground(Color.DARK_GRAY);
                button.setMaximumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
                button.setAlignmentX(CENTER_ALIGNMENT);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InteractableDialog.getInstance().showDialog(i);
                    }
                });
            }
        }
        this.repaint();
        this.validate();
    }
}
