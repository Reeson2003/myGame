package ru.reeson2003.npcs;

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
    public void addMana(int mana) {
        if(this.mana + mana <= this.maximumMana && this.mana+mana >=0)
            this.mana += mana;
        else if(this.mana + mana > this.maximumMana)
            this.mana = maximumMana;
        else if(this.mana+mana <0)
            this.mana = 0;
    }

    public Parameters(int experience, int strength,
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
        addExperience(experience);
        calcParameters();
        this.health = getMaximumHealth();
        this.mana = getMaximumMana();
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
            this.expCoeff = this.expCoeff * 11 / 10;
            this.expToNextLevel += this.expCoeff;
            addExperience(experience);
        }
    }

    public void calcParameters() {
        this.maximumHealth = 100 + level*5 + constitution*5;
        this.maximumMana = 100 + level*5 + intellect*5;
        this.healthRegen = 1 + constitution*8/10;
        this.manaRegen = 1 + intellect*8/10;

        this.physicalAttack = 5 + strength*8/10;
        this.physicalDefence = 5 + constitution*8/10;
        this.criticalChance = 5 + agility*8/10;
        this.atackSpeed = 10000/(5 + agility*8/10);
        this.evasion = 5 + agility*8/10;
        this.accuracy = 5 + agility*8/10;
    }

    private void levelUp() {
        level++;
        calcParameters();
        //System.out.println("Level UP!");
    }
}
