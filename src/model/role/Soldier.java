package model.role;

import model.equipment.Equipment;
import model.skill.Skill;
import model.weapon.IWeapon;

//军人
public class Soldier implements IRole {

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

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

//    @Override
//    public IWeapon getiWeapon() {
//        return iWeapon;
//    }
//
//    @Override
//    public void setiWeapon(IWeapon iWeapon) {
//        this.iWeapon = iWeapon;
//    }
//
//    @Override
//    public Skill getSkill() {
//        return skill;
//    }
//
//    @Override
//    public void setSkill(Skill skill) {
//        this.skill = skill;
//    }
//
//    @Override
//    public Equipment getEquipment() {
//        return equipment;
//    }
//
//    @Override
//    public void setEquipment(Equipment equipment) {
//        this.equipment = equipment;
//    }
}
