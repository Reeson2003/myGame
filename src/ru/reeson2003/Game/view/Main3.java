package ru.reeson2003.Game.view;


import ru.reeson2003.npcs.Parameters;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Тоня on 10.10.2016.
 */
public class Main3 {
    public static void main(String[] args) throws IOException {

        Parameters parameters = new Parameters(1000d, 5, 10, 4, 1, 2);

        JFrame frame = new JFrame();
        StatEnterWindow statEnterWindow = new StatEnterWindow();
        frame.add(statEnterWindow);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        statEnterWindow.showStats(parameters);
        frame.pack();
        frame.setVisible(true);
    }
}
