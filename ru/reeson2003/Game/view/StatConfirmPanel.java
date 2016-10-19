package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 19.10.2016.
 */
public class StatConfirmPanel extends JPanel {
    private JButton confirm;
    private JButton cancel;
    private JLabel pointsLabel;
    private JPanel textPanel;
    private JPanel buttonsPanel;
    public StatConfirmPanel() {
        super();
        initialize();
    }
    private void initialize() {
        this.setLayout(new BorderLayout());
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        pointsLabel = new JLabel("",SwingConstants.CENTER);
        pointsLabel.setForeground(Color.ORANGE);
        textPanel.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        pointsLabel.setBorder(BorderFactory.createCompoundBorder(out,in));
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.setBorder(BorderFactory.createCompoundBorder(out,in));
        confirm = new JButton("Ok");
        cancel = new JButton("Отмена");
        textPanel.add(pointsLabel);
        buttonsPanel.add(confirm, BorderLayout.WEST);
        buttonsPanel.add(cancel, BorderLayout.EAST);
        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void showPoints(int points) {
        pointsLabel.setText("Очки: " + points);
    }
    public void setConfirmListener(ActionListener a) {
        confirm.addActionListener(a);
    }
    public void setCancelListener(ActionListener a) {
        cancel.addActionListener(a);
    }
}
