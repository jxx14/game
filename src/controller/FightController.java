package controller;

import model.enemy.Enemy;
import model.equipment.Equipment;
import model.role.IRole;
import model.role.RoleFactory;
import model.skill.Skill;
import model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FightController {
    private String equipments[] ={"不选择装备","头盔","盔甲","组合"};
    int count = 0;

    //创建Enemy
    public Enemy creatEnemy(String name){
        Random random = new Random();
        int enemyHurt = random.nextInt(100) ;
        int enemyLife = random.nextInt(100) ;
        return new Enemy(name,enemyHurt,enemyLife);
    }


//    //已知用户角色类型创建角色，在选择角色类型后初始化角色
//    public IRole creatRole(String roleKind){
//        RoleFactory roleFactory = new RoleFactory();
//        return roleFactory.getRole(roleKind);
//    }

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
        return iRole.getShield()+protect;
    }

    //计算攻击值
    public int calculateHurt(Skill skill, IRole iRole, IWeapon weapon){
        int hurt = 0;
        if (skill!=null){
            hurt =hurt + skill.getHurt();
        }
        if (weapon!=null){
            hurt =hurt+weapon.calculateAttack();
        }
        return iRole.getHurt()+hurt;
    }

    //读取要显示的角色信息
    public  String getRoleInfo(IRole role){
        return "我方属性：血量"+role.getLife()+
                ";等级"+role.getLevel()+
                ";攻击力"+role.getHurt()+
                ";防御"+role.getShield();
    }
    //读取要显示的enemy信息
    public  String getEnemyInfo(Enemy enemy){
        return enemy.getName()+"：攻击"+enemy.getHurt()+"；血量"+enemy.getLife();
    }

    //计算战斗结果
    public void getResult(Skill skill, IWeapon weapon, IRole role, Enemy enemy, Equipment equipment){
        int totalHurt = calculateHurt(skill,role,weapon);
        int totalProtect = calculateProtect(equipment,role);
        //保证自己的安全
        if (totalProtect>enemy.getHurt()){
            //如果敌人死掉获得敌人的生命力
            role.setLife(role.getLife()+enemy.getLife());
            if (totalHurt<enemy.getLife()){
                //如果敌人没有死掉，减掉敌人的攻击值
                role.setLife(role.getLife()-enemy.getHurt());
            }

            if(role.getLife()>1000){
                count = count + 1;
                role.setLevel(2);
                if (count==2){
                    role.setHurt(role.getHurt()*2);
                    role.setShield(role.getShield()*2);
                }
            }
        }else {
            //自己失败,重新再来
            RoleFactory factory =new RoleFactory();
            role =factory.getRole(role.getName());;
        }

    }

    public Equipment getEquipment(int equipmentIndex){
        List<String> equipmentList =new ArrayList<>();
        if (equipmentIndex==3){
            equipmentList.add(equipments[1]);
            equipmentList.add(equipments[2]);
        }else {
            equipmentList.add(equipments[equipmentIndex]);
        }
        return getEquipment(equipmentList);
    }
}
