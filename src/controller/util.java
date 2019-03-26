package controller;

import model.enemy.Enemy;
import model.equipment.Equipment;
import model.role.IRole;
import model.role.RoleFactory;
import model.skill.Skill;
import model.weapon.IWeapon;
import model.weapon.gun.DoubleMirrorDecorator;
import model.weapon.gun.Gun;
import model.weapon.sword.BlueSwordDecorator;
import model.weapon.sword.RedSwardDecorator;
import model.weapon.sword.Sword;

import java.util.*;


public class util {
    private String equipments[] ={"不选择装备","头盔","盔甲","组合"};
    int count = 0;

    public Skill getSkill(List<String> skillNameList){
        Skill skill=new Skill(skillNameList.get(0),100);
        if (skillNameList.size()>1){
            for (int i = 1; i <skillNameList.size() ; i++) {
                Skill skill1=new Skill(skillNameList.get(i),100);
                skill.add(skill1);
            }
        }
        return skill;
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


    //    private String weapons[] ={"不使用剑","剑","装配1个红宝石配件","装配2个红宝石配件",
//            "装配1个蓝宝石配件","装配2个蓝宝石配件","装配蓝宝石和红宝石各一个"};
    public IWeapon getSword(int weaponIndex) {
        switch (weaponIndex) {
            case 0:
                return new Sword();
            case 1:
                return new RedSwardDecorator(new Sword());
            case 2:
                return new RedSwardDecorator(new RedSwardDecorator(new Sword()));
            case 3:
                return new BlueSwordDecorator(new Sword());
            case 4:
                return new BlueSwordDecorator(new BlueSwordDecorator(new Sword()));
            case 5:
                return new BlueSwordDecorator(new RedSwardDecorator(new Sword()));
        }
        return null;
    }


    //    private String weapons[] ={"不使用枪","枪","装配二倍镜","装配四倍镜"};
    public IWeapon getGun(int weaponIndex){
        switch (weaponIndex) {
            case 0:
                return new Gun();
            case 1:
                return new DoubleMirrorDecorator(new Gun());
            case 2:
                return new DoubleMirrorDecorator(new Gun());
        }
        return null;
    }


    //创建Enemy
    public Enemy createEnemy(String name){
        Random random = new Random();
        int enemyHurt = random.nextInt(1000) ;
        int enemyLife = random.nextInt(1000) ;
        return new Enemy(name,enemyHurt,enemyLife);
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
        if (totalProtect+role.getLife()>enemy.getHurt()){
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
            //失败,重新再来
            role =new RoleFactory().getRole(role.getName());
        }

    }

}
