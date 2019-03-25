package controller;

import model.enemy.Enemy;
import model.equipment.Equipment;
import model.role.IRole;
import model.role.RoleFactory;
import model.skill.Skill;
import model.weapon.IWeapon;

import java.util.List;


public class FightController {

    //1已知用户角色类型创建角色，在选择角色类型后初始化角色
    public IRole creatRole(String roleKind){
        RoleFactory roleFactory = new RoleFactory();
        return roleFactory.getRole(roleKind);
    }

    // 得到装备
    public Equipment getEquipment(List<String> equipmentList){
        Equipment equipment=new Equipment(equipmentList.get(0));
        if (equipmentList.size()>1){
            for (int i = 1; i <equipmentList.size() ; i++) {
                Equipment equipment1=new Equipment(equipmentList.get(i) );
                equipment.add(equipment1);
            }
        }
        return equipment;
    }

    public Skill getSkill(List<String> skillList){
        Skill skill=new Skill(skillList.get(0) );
        if (skillList.size()>1){
            for (int i = 1; i <skillList.size() ; i++) {
                Skill skill1=new Skill(skillList.get(i));
                skill.add(skill1);
            }
        }
        return skill;
    }

    //计算防御值
    public int calculateProtect(Equipment equipment, IRole iRole){
        int protect = 0;
        if(equipment!=null){
            protect = protect + equipment.getProtect();
        }
        return iRole.calculateShield()+protect;
    }

    //计算攻击值
    public int calculateHurt(Skill skill,IRole iRole,IWeapon weapon){
        int hurt = 0;
        if (skill!=null){
            hurt =hurt + skill.getHurt();
        }
        if (weapon!=null){
            hurt =hurt+weapon.calculateAttack();
        }
        return iRole.calculateAttack()+hurt;
    }

    //读取要显示的角色信息
    public  String getRoleInfo(IRole role){
        return "我方属性：血量"+role.getLife()+
                ";等级"+role.getLevel()+
                ";攻击力"+role.calculateAttack()+
                ";防御"+role.calculateShield();
    }
    //读取要显示的enemy信息
    public  String getEnemyInfo(Enemy enemy){
        return enemy.getName()+"：攻击"+enemy.getHurt()+"；血量"+enemy.getLife();
    }

//
//    //技能升级
//    public void upGradeSkills(Skill skill){
//        if (skill!=null){
//            for (Skill s:skill) {
//
//            }
//        }
//    }
}
