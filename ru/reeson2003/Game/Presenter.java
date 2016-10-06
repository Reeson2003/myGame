package ru.reeson2003.Game;

import ru.reeson2003.map.Location;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Equip;
import ru.reeson2003.player.Parameters;
import ru.reeson2003.player.Player;
import ru.reeson2003.items.Item;
import ru.reeson2003.map.Map;

import java.util.Scanner;

/**
 * Created by Тоня on 04.10.2016.
 */
public class Presenter {
    private static Presenter instance = null;
    private Game game;
    private iView view;
    private String action;
    private Presenter(iView view){
        this.view = view;
        instance = this;
        this.action = null;
        view.addListener(this);
    }
    public static Presenter getInstance(iView view) {
        if(instance == null)
            return new Presenter(view);
        else
            return instance;
    }
    public void addGame(Game game) {
        this.game = game;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public String getChoise(String[] actions) {
        view.showDialog("Enter number:",actions);
        /*
        if(action == null)
            wait();
        */
        String result = action;
        action = null;
        return result;
    }
    public String getString(int length) {
        view.showLineDialog("Maximum " + length + " symbols", length);
        /*
        if(action == null)
            wait();
        */
        String result = action;
        action = null;
        return result;
    }
    public String getAction() {
        view.waitAction();
        /*
        if(action == null)
            wait();
        */
        String result = action;
        action = null;
        return result;
    }

    public void show(String msg) {
        view.show(msg);
    }
    public void show(Player player) {
        String result = player.getInfo();
        view.show(result + ": HP: 100%, MP: 100%");
    }
    public void show(Item item) {

    }
    public void show(Parameters parameters) {

    }
    public void show(Equip equip) {

    }
    public void show(Location location) {

    }
    public void show(Map map) {

    }
    public void show(Position position) {
        String result = position.getInfo();
        view.show(result);
    }


}
