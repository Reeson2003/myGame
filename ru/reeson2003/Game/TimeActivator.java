package ru.reeson2003.Game;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тоня on 08.10.2016.
 */
public class TimeActivator implements iTimeActivator {
    private long time = 0;
    private final long startTime;
    private List<iTimeActing> actingList;

    public TimeActivator() {
        this.actingList = new LinkedList<>();
        startTime = new Date().getTime();
    }

    public void addTimeListener(iTimeActing timeActing) {
        actingList.add(timeActing);
    }
    public void timeActivate() {
        this.time = new Date().getTime() - startTime;
        for (iTimeActing items :
                actingList) {
            items.timeActivate(time);
        }
    }

    @Override
    public void run() {
        while(true) {
            timeActivate();
        }
    }
}
