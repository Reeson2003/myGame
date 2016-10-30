package ru.reeson2003.Game.view;

import ru.reeson2003.Game.model.Game;
import ru.reeson2003.npcs.Parameters;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Тоня on 10.10.2016.
 */
public class StatEnterWindow extends JPanel {
    private StatPanel strPanel;
    private StatPanel conPanel;
    private StatPanel aglPanel;
    private StatPanel intPanel;
    private StatPanel wisPanel;
    private StatConfirmPanel statConfirmPanel;

    private static int strength = -1;
    private static int constitution = -1;
    private static int agility = -1;
    private static int intellect = -1;
    private static int wisdom = -1;
    private static int points = -1;

    public StatEnterWindow() {
        super();
        initialize();
    }

    //    public static StatEnterWindow getInstance() {
//        if (instance == null)
//            instance = new StatEnterWindow();
//        return instance;
//    }
    private void initialize() {
        strPanel = new StatPanel("Сила");
        conPanel = new StatPanel("Выносливость");
        aglPanel = new StatPanel("Ловкость");
        intPanel = new StatPanel("Интеллект");
        wisPanel = new StatPanel("Мудрость");
        statConfirmPanel = new StatConfirmPanel();
        this.setLayout(new GridLayout(2, 3, 5, 5));
        this.setBackground(Colors.BACKGROUND);
        Border out = BorderFactory.createLineBorder(Colors.BORDER_OUT, 2, false);
        Border in = BorderFactory.createLineBorder(Colors.BORDER_IN, 2, false);
        this.setBorder(BorderFactory.createCompoundBorder(out, in));
        this.add(strPanel);
        this.add(conPanel);
        this.add(aglPanel);
        this.add(intPanel);
        this.add(wisPanel);
        this.add(statConfirmPanel);
    }

    public void showStats(final Parameters parameters) {
        if (strength < 0)
            strength = parameters.getStrength();
        if (constitution < 0)
            constitution = parameters.getConstitution();
        if (agility < 0)
            agility = parameters.getAgility();
        if (intellect < 0)
            intellect = parameters.getIntellect();
        if (wisdom < 0)
            wisdom = parameters.getWisdom();
        if (points < 0)
            points = parameters.getSkillPoints();
        strPanel.showPoints(parameters.getStrength());
        conPanel.showPoints(parameters.getConstitution());
        aglPanel.showPoints(parameters.getAgility());
        intPanel.showPoints(parameters.getIntellect());
        wisPanel.showPoints(parameters.getWisdom());
        statConfirmPanel.showPoints(parameters.getSkillPoints());

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
                if (parameters.getStrength() > 0) {
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
                if (parameters.getConstitution() > 0) {
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
                if (parameters.getAgility() > 0) {
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
                if (parameters.getIntellect() > 0) {
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
                if (parameters.getWisdom() > 0) {
                    parameters.addSkillPoints(1);
                    parameters.addWisdom(-1);
                }
            }
        });

        statConfirmPanel.setConfirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strength = -1;
                constitution = -1;
                agility = -1;
                intellect = -1;
                wisdom = -1;
                points = -1;
                Game.getInstance().refreshIcon();
            }
        });
        statConfirmPanel.setCancelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (strength >= 0) {
                    parameters.setStrength(strength);
                    strength = -1;
                }
                if (constitution >= 0) {
                    parameters.setConstitution(constitution);
                    constitution = -1;
                }
                if (agility >= 0) {
                    parameters.setAgility(agility);
                    agility = -1;
                }
                if (intellect >= 0) {
                    parameters.setIntellect(intellect);
                    intellect = -1;
                }
                if (wisdom >= 0) {
                    parameters.setWisdom(wisdom);
                    wisdom = -1;
                }
                if (points >= 0) {
                    parameters.setSkillPoints(points);
                    points = -1;
                }
                Game.getInstance().refreshIcon();
            }
        });
    }
}
