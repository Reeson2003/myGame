package ru.reeson2003.Game.model.npcs;

import ru.reeson2003.Game.model.tools.Interactable;
import ru.reeson2003.Game.model.map.Direction;
import ru.reeson2003.Game.model.map.Position;

/**
 * Created by Тоня on 01.10.2016.
 */
public abstract class Creature implements Interactable{
    protected String name = "";
    protected String info = "";
    protected Position position;
    protected Parameters parameters;
    protected Creature(String name, String info, Position position) {
        if (name != null)
            this.name = name;
        if (info != null)
            this.info = info;
        this.position = position;
        this.position.addObject(this);
    }

    public Position getPosition() {
        return position;
    }
    public void move(Direction direction) {
        setPosition(position.moveByDirection(direction));
    }
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
    public Parameters getParameters() {
        return parameters;
    }
    @Override
    public void setPosition(Position position) {
        this.position.removeObject(this);
        this.position = position;
        this.position.addObject(this);
    }
    @Override
    public String getInfo() {
        if(parameters != null)
            return (name + " " +
                "lvl: " + parameters.getLevel() +
                " HP: " + parameters.getMaximumHealth() +
                " MP: " + parameters.getMaximumMana() +
                " P.Atk: " + parameters.getPhysicalAttack() +
                " P.Def: " + parameters.getPhysicalDefence() +
                " Crt: " + parameters.getCriticalChance() +
                " Evs: " + parameters.getEvasion() +
                " Acc: " + parameters.getAccuracy() +
                " Asp: " + parameters.getAttackSpeed() +
                " HPr: " + parameters.getHealthRegen() +
                " MPr: " + parameters.getManaRegen());
        else
            return info;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
