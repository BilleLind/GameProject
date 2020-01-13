package Game;

import java.util.Scanner;

public class Creature {
    //super class for all the different adversaries that the player will be fighting or encountering

    public int health;
    public int attack=1;
    public int defence;
    public String name;
    boolean inUse = false;






    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean isInUse() {
        return inUse;
    }


    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean opponentAlive() {
        return health >0 ;
}

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean getInUse() {
        return inUse;    }
}
