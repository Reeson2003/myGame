package ru.reeson2003.Game.view;

import ru.reeson2003.npcs.Parameters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 10.10.2016.
 */
public class StatEnterWindow extends JPanel{
    private static StatEnterWindow instance = null;
    private StatPanel strPanel;
    private StatPanel conPanel;
    private StatPanel aglPanel;
    private StatPanel intPanel;
    private StatPanel wisPanel;
    private StatConfirmPanel statConfirmPanel;

    int strength;
    int constitution;
    int agility;
    int intellect;
    int wisdom;
    int points;
    private StatEnterWindow() {
        super();
        initialize();
    }
    public static StatEnterWindow getInstance() {
        if (instance == null)
            instance = new StatEnterWindow();
        return instance;
    }
    private void initialize() {
        strPanel = new StatPanel("Сила");
        conPanel = new StatPanel("Выносливость");
        aglPanel = new StatPanel("Ловкость");
        intPanel = new StatPanel("Интеллект");
        wisPanel = new StatPanel("Мудрость");
        statConfirmPanel = new StatConfirmPanel();
        this.setLayout(new GridLayout(2,3,5,5));
        this.setBackground(Color.DARK_GRAY);
        Border out = BorderFactory.createLineBorder(Color.BLACK,2,false);
        Border in = BorderFactory.createLineBorder(Color.ORANGE,2,false);
        this.setBorder(BorderFactory.createCompoundBorder(out,in));
        this.add(strPanel);
        this.add(conPanel);
        this.add(aglPanel);
        this.add(intPanel);
        this.add(wisPanel);
        this.add(statConfirmPanel);
    }

    public void showStats(Parameters parameters) {
        strength = parameters.getStrength();
        constitution = parameters.getConstitution();
        agility = parameters.getAgility();
        intellect = parameters.getIntellect();
        wisdom = parameters.getWisdom();
        points = parameters.getSkillPoints();
        strPanel.showPoints(strength);
        conPanel.showPoints(constitution);
        aglPanel.showPoints(agility);
        intPanel.showPoints(intellect);
        wisPanel.showPoints(wisdom);
        statConfirmPanel.showPoints(points);

        strPanel.setPlusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getSkillPoints() > 0) {
                    parameters.addSkillPoints(-1);
                    parameters.addStrength(1);
                }
            }
        });
        strPanel.setMinusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getStrength() > strength) {
                    parameters.addSkillPoints(1);
                    parameters.addStrength(-1);
                }
            }
        });
        conPanel.setPlusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getSkillPoints() > 0) {
                    parameters.addSkillPoints(-1);
                    parameters.addConstitution(1);
                }
            }
        });
        conPanel.setMinusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getStrength() > strength) {
                    parameters.addSkillPoints(1);
                    parameters.addConstitution(-1);
                }
            }
        });
        aglPanel.setPlusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getSkillPoints() > 0) {
                    parameters.addSkillPoints(-1);
                    parameters.addAgility(1);
                }
            }
        });
        aglPanel.setMinusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getStrength() > strength) {
                    parameters.addSkillPoints(1);
                    parameters.addAgility(-1);
                }
            }
        });
        intPanel.setPlusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getSkillPoints() > 0) {
                    parameters.addSkillPoints(-1);
                    parameters.addIntellect(1);
                }
            }
        });
        intPanel.setMinusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getStrength() > strength) {
                    parameters.addSkillPoints(1);
                    parameters.addIntellect(-1);
                }
            }
        });
        wisPanel.setPlusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getSkillPoints() > 0) {
                    parameters.addSkillPoints(-1);
                    parameters.addWisdom(1);
                }
            }
        });
        wisPanel.setMinusButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parameters.getStrength() > strength) {
                    parameters.addSkillPoints(1);
                    parameters.addWisdom(-1);
                }
            }
        });

    }
}
