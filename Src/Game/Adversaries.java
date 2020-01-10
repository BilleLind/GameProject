package Game;

public class Adversaries {
    //super class for all the different adversaries that the player will be fighting or encountering

private int hp;

private int atk;
private int def;
private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
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

public boolean opponentAlive() {
        return hp >0;
}




}
