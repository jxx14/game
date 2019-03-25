package model.enemy;

public class Enemy {
    private String name;
    private int hurt;
    private int life;

    public Enemy(String name, int hurt,int life) {
        this.name = name;
        this.hurt = hurt;
        this.life = life;
    }

    public int getLife(){
        return life;
    }
    public String getName() {
        return name;
    }

    public int getHurt() {
        return hurt;
    }

}
