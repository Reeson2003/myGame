package ru.reeson2003.Game;

import ru.reeson2003.npcs.Parameters;

import java.util.Date;
import java.util.Random;

/**
 * Created by Тоня on 09.10.2016.
 */
public class Fight implements Runnable {
    private static int dispersion = 40;
    Parameters opponent1;
    Parameters opponent2;
    Random random;

    public Fight(Parameters opponent1, Parameters opponent2) {
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;
        random = new Random();
        Thread thread = new Thread(this);
        thread.start();
    }

    public void fight() {
        Date date = new Date();
        long op1hit = date.getTime();
        long op2hit = date.getTime();
        long healthRegen = date.getTime();
        System.out.println(opponent1.name + " and " + opponent2.name + " fight!");
        while (opponent1.getHealth() >0 && opponent2.getHealth() >0) {
            date = new Date();
            if (date.getTime() - op1hit > opponent1.getAttackSpeed()) {
                hit(opponent1, opponent2);
                op1hit = date.getTime();
                System.out.println(opponent2.name + " " + opponent2.getHealth());
            }
            if (date.getTime() - op2hit > opponent2.getAttackSpeed()) {
                hit(opponent2, opponent1);
                op2hit = date.getTime();
                System.out.println(opponent1.name + " " + opponent1.getHealth());
            }
            if (date.getTime() - healthRegen > 2000) {
                //opponent1.addHealth(opponent1.getHealthRegen());
                //opponent2.addHealth(opponent2.getHealthRegen());
                healthRegen = date.getTime();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(opponent1.getHealth()>0)
            System.out.println(opponent1.name + " won " + opponent2.name);
        else if(opponent2.getHealth() >0)
            System.out.println(opponent2.name + " won " + opponent1.name);
        else
            System.out.println(opponent1.name + " draw " + opponent2.name);
        //System.out.println(opponent1.getHealth());
        //System.out.println(opponent2.getHealth());
    }

    private void hit(Parameters giveDamage, Parameters getDamage) {
        int damage = giveDamage.getPhysicalAttack() - getDamage.getPhysicalDefence()/10;
        if (damage < 2)
            damage = 2;
        int check = random.nextInt(100);
        if (check >=0 && check < giveDamage.getCriticalChance())
            damage *= 2;
        check = random.nextInt(100);
        if (check >=0 && check < getDamage.getEvasion() - giveDamage.getAccuracy()/10)
            damage = 0;
        damage = damage*(100 - dispersion/2 + random.nextInt(dispersion))/100;
        getDamage.addHealth(-damage);
        //System.out.println(giveDamage.name + " hits " +damage);
    }

    @Override
    public void run() {
        fight();
    }
}
