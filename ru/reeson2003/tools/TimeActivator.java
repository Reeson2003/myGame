package ru.reeson2003.tools;

import java.util.*;

/**
 * Created by Тоня on 08.10.2016.
 */
public class TimeActivator implements Runnable {
    private long time = 0;
    private final long startTime;
    private List<iTimeActing> actingList;
    private static TimeActivator timeActivator;

    private TimeActivator() {
        this.actingList = new LinkedList<>();
        startTime = new Date().getTime();
        Thread thread = new Thread(this);
        thread.start();
    }

    public static TimeActivator getInstance() {
        if (timeActivator == null) {
            timeActivator = new TimeActivator();
        }
        return timeActivator;
    }

    public void addTimeListener(iTimeActing timeActing) {
        synchronized (actingList) {
            actingList.add(timeActing);
        }
    }
    public void timeActivate() {
        synchronized (actingList) {
            this.time = new Date().getTime() - startTime;
            for (iTimeActing items :
                    actingList) {
                items.timeActivate(time);
            }
        }
    }

    public void run() {
        while(true) {
            timeActivate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
