package model.role;

import model.equipment.Equipment;
import model.skill.Skill;
import model.weapon.IWeapon;

/*
https://www.cnblogs.com/zzhangkuoo/articles/9199371.html
需求：角色类型系统
*/
public interface IRole {
    /**
     * 计算攻击力
     */
    public int calculateAttack();

    /**
     * 角色的描述
     */
    public String description();

    /**
     * 计算防御值
     */
    public int calculateShield();


    public int getLife();
    public void setLife(int life);

    public int getLevel() ;
    public void setLevel(int level);
//
//    public IWeapon getiWeapon();
//    public void setiWeapon(IWeapon iWeapon);
//
//    public Skill getSkill() ;
//    public void setSkill(Skill skill);
//
//    public Equipment getEquipment() ;
//    public void setEquipment(Equipment equipment);

}
