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
    private List<iTimeActing> toRemove;
    private List<iTimeActing> toAdd;

    private TimeActivator() {
        this.actingList = new LinkedList<>();
        toRemove = new LinkedList<>();
        toAdd = new LinkedList<>();
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
        synchronized (toAdd) {
            toAdd.add(timeActing);
        }
    }

    public void removeTimeListener(iTimeActing timeActing) {
        synchronized (toRemove) {
            toRemove.add(timeActing);
        }
    }

    public void timeActivate() {
        this.time = new Date().getTime() - startTime;
        synchronized (actingList) {
            synchronized (toAdd) {
                actingList.addAll(toAdd);
                toAdd.clear();
            }
            for (iTimeActing items :
                    actingList) {
                items.timeActivate(time);
            }
            synchronized (toRemove){
                actingList.removeAll(toRemove);
                toRemove.clear();
            }
        }
    }

    public void run() {
        while (true) {
            timeActivate();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
