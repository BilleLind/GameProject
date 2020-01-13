package Game;

import java.util.Random;

public class Player extends Creature {
    // the class where all instance variables and methods for the player class will be located here
    //included all the different starter bonuses

    private int health;
    private String name;
    private int attack=1;
    private int defence;
    private int weapon;
    private int equipment;
    private int bornWithTalent;
    private int coins;

    public Player(int health, String name, int attack, int defence, int weapon, int equipment, int bornWithTalent, int coins) {
        this.health = health;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.weapon = weapon;
        this.equipment = equipment;
        this.bornWithTalent = bornWithTalent;
        this.coins= coins;
    }
    public Player() {

    }



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
        return attack+getWeapon();
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
