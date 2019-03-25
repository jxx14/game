package model.role;

//军人
public class Soldier implements IRole {


    private int life;
    private int level;
    private int hurt;
    private int Shield;

    public Soldier(int life, int level, int hurt, int shield) {
        this.life = life;
        this.level = level;
        this.hurt = hurt;
        Shield = shield;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "soldier";
    }

    @Override
    public int getHurt() {
        return hurt;
    }

    @Override
    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    @Override
    public int getShield() {
        return Shield;
    }

    public void setShield(int shield) {
        Shield = shield;
    }

}
