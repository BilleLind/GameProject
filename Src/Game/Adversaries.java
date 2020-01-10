package Game;

public class Adversaries {
    //super class for all the different adversaries that the player will be fighting or encountering

private int hp;
private int damage;
private int atk;
private int def;
private String name;

public Adversaries(String name,int hp, int damage, int atk, int def ) {
    this.name =name;
    this.hp = hp;
    this.atk = atk;
    this.damage =damage;
    this.def =def;
}
    public int getAtk() {
        return atk;
    }

    public int getDamage() {
        return damage;
    }

    public int getDef() {
        return def;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }
}
