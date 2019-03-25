package model.role;


import model.equipment.Equipment;
import model.skill.Skill;
import model.weapon.IWeapon;

public class Hero implements IRole {

    private int life;
    private int level;

    private IWeapon iWeapon;
    private Skill skill;
    private Equipment equipment;

    @Override
    public int calculateAttack() {
        return 100;
    }

    @Override
    public String description() {
        return "骑士";
    }

    @Override
    public int calculateShield() {
        return 100;
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

    public void setLevel(int level) {
        this.level = level;
    }

}
