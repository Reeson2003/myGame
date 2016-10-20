package ru.reeson2003.Game.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 19.10.2016.
 */
public class StatPanel extends JPanel {
    private JPanel textPanel;
    private JLabel statName;
    private JPanel buttonsPanel;
    private JLabel pointsAmount;
    private JButton plusButton;
    private boolean hasPlusListener = false;
    private JButton minusButton;
    private boolean hasMinusListener = false;

    public StatPanel() {
        super();
        initialize();
    }
    public StatPanel(String statName) {
        super();
        initialize();
        this.statName.setText(statName);
    }
    private void initialize() {
        this.setLayout(new BorderLayout());
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        statName = new JLabel("", SwingConstants.CENTER);
        statName.setForeground(Color.ORANGE);
        textPanel.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK, 2, false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE, 2, false);
        statName.setBorder(BorderFactory.createCompoundBorder(out, in));
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.setBorder(BorderFactory.createCompoundBorder(out, in));
        pointsAmount = new JLabel("", SwingConstants.CENTER);
        pointsAmount.setForeground(Color.ORANGE);
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        textPanel.add(statName);
        buttonsPanel.add(minusButton, BorderLayout.WEST);
        buttonsPanel.add(plusButton, BorderLayout.EAST);
        buttonsPanel.add(pointsAmount, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void setPlusButtonListener(ActionListener a) {
        if (!hasPlusListener) {
            plusButton.addActionListener(a);
            hasPlusListener = true;
        }
    }
    public void setMinusButtonListener(ActionListener a) {
        if (!hasMinusListener) {
            minusButton.addActionListener(a);
            hasMinusListener = true;
        }
    }

    public void showPoints(int points) {
        pointsAmount.setText(" " + points + " ");
    }

}
