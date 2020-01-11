package Game;

public class Adversaries {
    //super class for all the different adversaries that the player will be fighting or encountering

private int hp;

private int atk;
private int def;
private String name;
private int initialized=0;
private int killed=1;

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

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public void setInitialized(int initialized) {
        this.initialized = initialized;
    }

    public int getInitialized() {
        return initialized;
    }

    public int getKilled() {
        return killed;
    }

    public boolean opponentInitialized() {
        return initialized ==1;
    }

    public boolean opponentKilled() {
        return killed==0;
    }

    public boolean opponentAlive() {
        return hp >0 || opponentKilled();
}




}
