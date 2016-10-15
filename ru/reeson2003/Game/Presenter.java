package ru.reeson2003.Game;

import ru.reeson2003.map.Location;
import ru.reeson2003.map.Position;
import ru.reeson2003.player.Equip;
import ru.reeson2003.npcs.Parameters;
import ru.reeson2003.player.Player;
import ru.reeson2003.items.Item;
import ru.reeson2003.map.Map;

/**
 * Created by Тоня on 04.10.2016.
 */
public class Presenter {
    private static Presenter instance = null;
    private Game game;
    private iView view;
    volatile private String keyAction;
    volatile private String chooseAction;
    private Presenter(iView view){
        this.view = view;
        instance = this;
        this.keyAction = "";
        this.chooseAction = "";
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

    synchronized public void setChooseAction(String chooseAction) {
        this.chooseAction = chooseAction;
    }
    synchronized public void setKeyAction(String keyAction) {
        this.keyAction = keyAction;
        //System.out.println(this.keyAction);

    }
    public String getChoise(String[] actions) {
        view.showDialog("Enter number:\n",actions);
        while (this.chooseAction.equals(""));

        String result = this.chooseAction;
        this.chooseAction = "";
        return result;
    }
    public String getString(String invitation, int length) {
        view.showLineDialog(invitation);
        while (this.keyAction.equals(""));

        String result = keyAction;
        this.keyAction = "";
        return result;
    }
    public String getString(String invitation) {
        view.showLineDialog(invitation);
        while (this.keyAction.equals(""));


        String result = keyAction;
        this.keyAction = "";
        return result;
    }
    public String getKeyAction() {
        view.waitAction();

        //while (keyAction.equals(""));

        String result = this.keyAction;
        this.keyAction = "";
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
        view.show(position);
    }


}
