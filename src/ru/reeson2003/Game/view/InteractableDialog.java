package ru.reeson2003.Game.view;

import ru.reeson2003.Game.controller.ObjectButtonListener;
import ru.reeson2003.tools.Interactable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 18.10.2016.
 */
public class InteractableDialog extends JDialog {
    private static InteractableDialog instance;
    private JButton activate;
    private JLabel textLabel;
    private JPanel buttonPanel;
    private JPanel textPanel;
    private ActionListener listener;

    private InteractableDialog() {
        super();
        initialize();
    }
    private void initialize() {
        activate = new JButton(" Выбрать ");
        activate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        activate.getAction();
        textLabel = new JLabel();
        textLabel.setForeground(Colors.FOREGROUND);
        textLabel.setBackground(Colors.BACKGROUND);
        buttonPanel = new JPanel();
        textPanel = new JPanel();
        textPanel.setBackground(Colors.BACKGROUND);
        buttonPanel.setBackground(Colors.BACKGROUND);
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT,2,false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN,2,false);
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(out,in));
        buttonPanel.add(activate);
        textPanel.setBorder(BorderFactory.createCompoundBorder(out,in));
        textPanel.add(textLabel);
        this.add(textPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
    }

    public static InteractableDialog getInstance() {
        if (instance == null) {
            instance = new InteractableDialog();
        }
        return instance;
    }

    public void showDialog(Interactable interactable) {
        if (listener != null) {
            activate.removeActionListener(listener);
        }
        listener = new ObjectButtonListener(interactable);
        activate.addActionListener(listener);
        textLabel.setText(interactable.getInfo());
        setModal(true);
        pack();
        setVisible(true);
    }

}
