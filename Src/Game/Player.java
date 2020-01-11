package Game;

import java.util.Random;

public class Player {
    // the class where all instance variables and methods for the player class will be located here
    //included all the different starter bonuses

    private int health;
    private String name;
    private int attack;
    private int defence;
    private int weapon;
    private int equipment;
    private int bornWithTalent;
    private int coins;

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getEquipment() {
        return equipment;
    }

    public int getBornWithTalent() {
        return bornWithTalent;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public void setBornWithTalent(int bornWithTalent) {
        this.bornWithTalent = bornWithTalent;
    }

    public boolean isAlive() {
        return health >0;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
