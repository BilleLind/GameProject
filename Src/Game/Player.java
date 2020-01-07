package Game;

import java.util.Random;

public class Player {
    // the class where all instance variables and methods for the player class will be located here
    //included all the different starter bonuses

    private int health;
    private String name;
    private double chanceOfKilling; // these four is instead of the "old fashioned" damage :D
    private double chanceOfInjuring;
    private double chanceOfSubduing;
    private double chanceOfWinningOver;
    private double numberForChances;

    public int getHealth() {
        return health;
    }

    public double getNumberForChances() {
        return numberForChances;
    }

    public void setNumberForChances(double numberForChances) {
        this.numberForChances = numberForChances;
    }

    public double getChanceOfKilling() {
        return chanceOfKilling;
    }

    public double getChanceOfInjuring() {
        return chanceOfInjuring;
    }

    public double getChanceOfSubduing() {
        return chanceOfSubduing;
    }

    public double getChanceOfWinningOver() {
        return chanceOfWinningOver;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setChanceOfKilling(double chanceOfKilling) {
        this.chanceOfKilling = chanceOfKilling;
    }

    public void setChanceOfInjuring(double chanceOfInjuring) {
        this.chanceOfInjuring = chanceOfInjuring;
    }

    public void setChanceOfSubduing(double chanceOfSubduing) {
        this.chanceOfSubduing = chanceOfSubduing;
    }

    public void setChanceOfWinningOver(double chanceOfWinningOver) {
        this.chanceOfWinningOver = chanceOfWinningOver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
