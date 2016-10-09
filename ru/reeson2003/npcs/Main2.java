package ru.reeson2003.npcs;

import ru.reeson2003.Game.Fight;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Тоня on 09.10.2016.
 */
public class Main2 {
    public static void main(String[] args) {
        Random random = new Random(new Date().getTime());
        int points = 30;
        int str = random.nextInt(points);
        points -= str;
        int con = random.nextInt(points);
        points -= con;
        int agi = points;
        System.out.println(str + " " + con + " " + agi);
        Parameters p = new Parameters(10, str, con, agi, 0, 0);
        p.name = "Reeson ";
        points = 30;
        str = random.nextInt(points);
        points -= str;
        con = random.nextInt(points);
        points -= con;
        agi = points;
        System.out.println(str + " " + con + " " + agi);
        Parameters m = new Parameters(10, str, con, agi, 0, 0);
        m.name = "Monster";
        print(p);
        print(m);
        Fight fight = new Fight(p,m);
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (a != 9) {
            a = scanner.nextInt();
            if (a == 1)
                p.addHealth(20);
            if (a == 2)
                m.addHealth(20);
        }
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
