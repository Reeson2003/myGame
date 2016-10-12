package ru.reeson2003.npcs;

import ru.reeson2003.Game.Fight;

import java.util.Date;
import java.util.Random;

/**
 * Created by Тоня on 09.10.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        Parameters p = getParameters("Reeson ", 30);
        Parameters m1 = getParameters("Monster1", 30);
        Parameters m2 = getParameters("Monster2", 30);
        Parameters m3 = getParameters("Monster3", 20);
        print(p);
        print(m1);
        print(m2);
        Fight fight1 = new Fight(p,m1);
        Fight fight2 = new Fight(p,m2);
        //Fight fight3 = new Fight(p,m3);
        /*
        for (int i = 0; i < 50; i++) {
            Parameters p1 = getParameters("Player" + "." +i,30);
            Parameters p2 = getParameters("Monster" + "." +i,30);
            Fight fight = new Fight(p1,p2);
        }
        */

    }

    public static Parameters getParameters(String name, int stats) {
        Random random = new Random();
        int points = stats;
        int str = random.nextInt(points);
        points -= str;
        int con = random.nextInt(points);
        points -= con;
        int agi = points;
        //System.out.println(str + " " + con + " " + agi);
        Parameters p = new Parameters(100000, str, con, agi, 0, 0);
        p.name = name;
        return p;
    }
    public static void print(Parameters p) {
        System.out.println(p.name + " " +
                "lvl: " + p.getLevel() +
                " HP: " + p.getMaximumHealth() +
                " MP: " + p.getMaximumMana() +
                " P.Atk: " + p.getPhysicalAttack() +
                " P.Def: " + p.getPhysicalDefence() +
                " Crt: " + p.getCriticalChance() +
                " Evs: " + p.getEvasion() +
                " Acc: " + p.getAccuracy() +
                " Asp: " + p.getAttackSpeed() +
                " HPr: " + p.getHealthRegen() +
                " MPr: " + p.getManaRegen());
    }

}
