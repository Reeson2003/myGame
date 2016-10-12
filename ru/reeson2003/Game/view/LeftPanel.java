package ru.reeson2003.Game.view;

import ru.reeson2003.Game.Interactable;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.util.List;

/**
 * Created by Тоня on 12.10.2016.
 */
public class LeftPanel extends JPanel {

    public LeftPanel(List<Interactable> objects) {
        initialize(objects);
    }

    private void initialize(List<Interactable> objects) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        this.setAlignmentY(JComponent.TOP_ALIGNMENT);
        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        addObjects(objects);
        this.setVisible(true);
    }

    private void addObjects(List<Interactable> objects) {
        for (Interactable i :
                objects) {
            String buttonName = i.getName();
            JButton button = new JButton(buttonName);
            button.setBackground(new Color(160,160,160));
            button.setBorder(BorderFactory.createLineBorder(new Color(0,100,120),1,false));


            //Icon buttonIcon = i.getIcon();
            //JButton button = new JButton(buttonIcon);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    i.interact(null, null);
                }
            });

            this.add(button);
        }
    }
}
