package ru.reeson2003.Game.model.npcs;

/**
 * Created by User on 12.11.2016.
 */
public interface ParametersStrategy {
    int getMaximumHealth(int lvl, int str, int con, int agl, int itl, int wit);
    int getHealthRegen(int lvl, int str, int con, int agl, int itl, int wit);
    int getMaximumMana(int lvl, int str, int con, int agl, int itl, int wit);
    int getManaRegen(int lvl, int str, int con, int agl, int itl, int wit);
    int getPhysicalAttack(int lvl, int str, int con, int agl, int itl, int wit);
    int getPhysicalDefence(int lvl, int str, int con, int agl, int itl, int wit);
    int getCriticalChance(int lvl, int str, int con, int agl, int itl, int wit);
    int getAttackSpeed(int lvl, int str, int con, int agl, int itl, int wit);
    int getEvasion(int lvl, int str, int con, int agl, int itl, int wit);
    int getAccuracy(int lvl, int str, int con, int agl, int itl, int wit);
}
