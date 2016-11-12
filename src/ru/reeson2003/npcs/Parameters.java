package ru.reeson2003.npcs;

import ru.reeson2003.Game.view.View;

/**
 * Created by Тоня on 04.10.2016.
 */
public class Parameters {
    public String name;

    private int level;
    private int experience;
    private int expToNextLevel;
    private int expCoeff;
    private int skillPoints;

    private int strength;
    private int constitution;
    private int agility;
    private int wisdom;
    private int intellect;

    private int maximumHealth;
    private int health;
    private int maximumMana;
    private int mana;
    private int healthRegen;
    private int manaRegen;

    private int physicalAttack;
    private int physicalDefence;
    private int criticalChance;
    private int atackSpeed;
    private int evasion;
    private int accuracy;

    public Parameters(double experience, int strength,
                      int constitution, int agility,
                      int wisdom, int intellect) {
        this.level = 0;
        this.expCoeff = 15;
        this.expToNextLevel = this.expCoeff;
        this.skillPoints = 0;
        this.strength = strength;
        this.constitution = constitution;
        this.agility = agility;
        this.wisdom = wisdom;
        this.intellect = intellect;
        addExperience((int)experience);
        calcParameters();
        this.health = getMaximumHealth();
        this.mana = getMaximumMana();
    }
    public Parameters(int level, int strength,
                      int constitution, int agility,
                      int wisdom, int intellect) {
        this.level = level;
        calcExpToNextLevel(this.level);
        this.skillPoints = 0;
        this.strength = strength;
        this.constitution = constitution;
        this.agility = agility;
        this.wisdom = wisdom;
        this.intellect = intellect;
        calcParameters();
        this.health = getMaximumHealth();
        this.mana = getMaximumMana();
    }



    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public int getExpToNextLevel() {
        return expToNextLevel;
    }
    public int getSkillPoints() {
        return skillPoints;
    }
    public int getMaximumHealth() {
        return maximumHealth;
    }
    public int getHealth() {
        return health;
    }
    public int getMaximumMana() {
        return maximumMana;
    }
    public int getMana() {
        return mana;
    }
    public int getStrength() {
        return strength;
    }
    public int getConstitution() {
        return constitution;
    }
    public int getAgility() {
        return agility;
    }
    public int getWisdom() {
        return wisdom;
    }
    public int getIntellect() {
        return intellect;
    }
    public int getPhysicalAttack() {
        return physicalAttack;
    }
    public int getPhysicalDefence() {
        return physicalDefence;
    }
    public int getCriticalChance() {
        return criticalChance;
    }
    public int getEvasion() {
        return evasion;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getAttackSpeed() {
        return atackSpeed;
    }
    public int getHealthRegen() {
        return healthRegen;
    }
    public int getManaRegen() {
        return manaRegen;
    }

    synchronized public void addHealth(int health) {
        if(this.health + health <= this.maximumHealth && this.health+health >=0)
            this.health += health;
        else if(this.health + health > this.maximumHealth)
            this.health = maximumHealth;
        else if(this.health+health <0)
            this.health = 0;
    }
    synchronized public void addMana(int mana) {
        if(this.mana + mana <= this.maximumMana && this.mana+mana >=0)
            this.mana += mana;
        else if(this.mana + mana > this.maximumMana)
            this.mana = maximumMana;
        else if(this.mana+mana <0)
            this.mana = 0;
    }
    public void addSkillPoints(int skillPoints) {
        this.skillPoints += skillPoints;
    }
    public void addStrength(int strength) {
        this.strength += strength;
        calcParameters();
        View.getInstance().show(this);
    }
    public void addConstitution(int constitution) {
        this.constitution += constitution;
        calcParameters();
        View.getInstance().show(this);
    }
    public void addAgility(int agility) {
        this.agility += agility;
        calcParameters();
        View.getInstance().show(this);
    }
    public void addIntellect(int intellect) {
        this.intellect += intellect;
        calcParameters();
        View.getInstance().show(this);
    }
    public void addWisdom(int wisdom) {
        this.wisdom += wisdom;
        calcParameters();
        View.getInstance().show(this);
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void addExperience (int experience) {
        if (this.experience + experience < expToNextLevel) {
            //System.out.println("exp: " + experience);
            this.experience += experience;
        } else {
            //System.out.println("Exp: " + experience + ", lvl: " + level + ", xp t.n.l: " + expToNextLevel);
            experience -= (expToNextLevel - this.experience);
            levelUp();
            skillPoints++;
            if(level%5 == 0)
                skillPoints++;
            expCoeff = expCoeff * 11 / 10;
            expToNextLevel += expCoeff;
            addExperience(experience);
        }
    }
    public void calcParameters() {
        ParametersStrategy strategy = SimpleParametersStrategy.getInstance();
        this.maximumHealth = strategy.getMaximumHealth(level,strength,constitution,agility,intellect,wisdom);
        this.maximumMana = strategy.getMaximumMana(level,strength,constitution,agility,intellect,wisdom);
        this.healthRegen = strategy.getHealthRegen(level,strength,constitution,agility,intellect,wisdom);
        this.manaRegen = strategy.getManaRegen(level,strength,constitution,agility,intellect,wisdom);

        this.physicalAttack = strategy.getPhysicalAttack(level,strength,constitution,agility,intellect,wisdom);
        this.physicalDefence = strategy.getPhysicalDefence(level,strength,constitution,agility,intellect,wisdom);
        this.criticalChance = strategy.getCriticalChance(level,strength,constitution,agility,intellect,wisdom);
        this.atackSpeed = strategy.getAttackSpeed(level,strength,constitution,agility,intellect,wisdom);
        this.evasion = strategy.getEvasion(level,strength,constitution,agility,intellect,wisdom);
        this.accuracy = strategy.getAccuracy(level,strength,constitution,agility,intellect,wisdom);
    }
    private void levelUp() {
        level++;
        calcParameters();
        //System.out.println("Level UP!");
    }
    private void calcExpToNextLevel(int level) {
        for (int i = 0; i< level; i++) {
            expCoeff = expCoeff*11/10;
            expToNextLevel += expCoeff;
        }
    }

}
