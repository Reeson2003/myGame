package ru.reeson2003.npcs;

/**
 * Created by User on 12.11.2016.
 */
public class SimpleParametersStrategy implements ParametersStrategy {
    private static ParametersStrategy parametersStrategy = null;
    public static ParametersStrategy getInstance() {
        if (parametersStrategy == null)
            parametersStrategy = new SimpleParametersStrategy();
        return parametersStrategy;
    }
    private SimpleParametersStrategy() {

    }

    @Override
    public int getMaximumHealth(int lvl, int str, int con, int agl, int itl, int wit) {
        return 100 + lvl*5 + con*5;
    }
    @Override
    public int getHealthRegen(int lvl, int str, int con, int agl, int itl, int wit) {
        return 1 + con*8/10;
    }
    @Override
    public int getMaximumMana(int lvl, int str, int con, int agl, int itl, int wit) {
        return 100 + lvl*5 + wit*5;
    }
    @Override
    public int getManaRegen(int lvl, int str, int con, int agl, int itl, int wit) {
        return 1 + itl*8/10;
    }
    @Override
    public int getPhysicalAttack(int lvl, int str, int con, int agl, int itl, int wit) {
        return 5 + str*8/10;
    }
    @Override
    public int getPhysicalDefence(int lvl, int str, int con, int agl, int itl, int wit) {
        return 5 + con*8/10;
    }
    @Override
    public int getCriticalChance(int lvl, int str, int con, int agl, int itl, int wit) {
        return 5 + agl*8/10;
    }
    @Override
    public int getAttackSpeed(int lvl, int str, int con, int agl, int itl, int wit) {
        return 10000/(5 + agl*8/10);
    }
    @Override
    public int getEvasion(int lvl, int str, int con, int agl, int itl, int wit) {
        return 5 + agl*8/10;
    }
    @Override
    public int getAccuracy(int lvl, int str, int con, int agl, int itl, int wit) {
        return 5 + agl*8/10;
    }
}
