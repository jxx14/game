package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import model.enemy.Enemy;
import model.equipment.Equipment;
import model.role.Hero;
import model.role.IRole;
import model.role.Soldier;
import model.skill.Skill;
import model.weapon.IWeapon;
import model.weapon.gun.DoubleMirrorDecorator;
import model.weapon.gun.Gun;
import view.Main;

import java.net.URL;
import java.util.*;

/*1 main里面初始化选择角色页面
  2 再roleController里面得到选择的角色，可以作为全局变量
  3 在roleController里将角色初始化，设置标签，然后调用main里面的函数
  4 在main里面跳转至game页面，页面最上方添加

* */
public class SoldierController implements Initializable {

    private Main application;
    public void setApp(Main application){
        this.application = application;
    }

    private FightController fightController =new FightController();
    @FXML
    private ComboBox skillComboBox;
    @FXML
    private ComboBox weaponComboBox;
    @FXML
    private ComboBox equipmentComboBox;
    @FXML
    private Text actionTarget;
    @FXML
    private Text actionTargetEnemy;

    private String skills[] ={"不选择技能","风","火","组合"};
    private String weapons[] ={"不使用枪","枪","装配二倍镜","装配四倍镜"};
    private String equipments[] ={"不选择装备","装备1","装备2","组合"};
    private Equipment equipment;
    private IWeapon weapon;
    private Skill skill;
    private IRole role =new Soldier();


    @FXML
    public void fight(ActionEvent event) {

        //每一次随机初始化一个敌人
        Random random = new Random();
        int enemyHurt = random.nextInt(100) ;
        int enemyLife = random.nextInt(100) ;
        Enemy enemy=new Enemy("罪犯",enemyHurt,enemyLife);

        actionTarget.setText(fightController.getRoleInfo(role));
        actionTargetEnemy.setText(fightController.getEnemyInfo(enemy));

        int weaponIndex =weaponComboBox.getSelectionModel().getSelectedIndex();
        if(weaponIndex!=0){
            weapon = getWeapon(weapons[weaponIndex]);
        }
        int equipmentIndex = equipmentComboBox.getSelectionModel().getSelectedIndex();
        if (equipmentIndex!=0){
            equipment = getEquipment(equipmentIndex);
        }

        int skillIndex=skillComboBox.getSelectionModel().getSelectedIndex();
        if (skillIndex!=0){
            skill = getSkill(skillIndex);
        }
        getResult(skill,weapon,role,enemy);
    }


    //计算战斗结果
    public void getResult(Skill skill,IWeapon weapon,IRole role,Enemy enemy){
        int totalHurt = fightController.calculateHurt(skill,role,weapon);
        int totalProtect = fightController.calculateProtect(equipment,role);
        //保证自己的安全
        if (totalProtect>enemy.getHurt()){
            //如果敌人死掉获得敌人的生命力
            role.setLife(role.getLife()+enemy.getLife());
            if (totalHurt<enemy.getLife()){
                //如果敌人没有死掉，减掉敌人的攻击值
                role.setLife(role.getLife()-enemy.getHurt());
            }

            if(role.getLife()>1000){
                role.setLevel(2);
            }
        }else {
            //自己失败,重新再来
            role=new Hero();
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
        return fightController.getEquipment(equipmentList);
    }


    public Skill getSkill(int skillIndex) {
        List<String> skillList =new ArrayList<>();
        if(skillIndex==3){
            skillList.add(skills[1]);
            skillList.add(skills[2]);
        }else {
            skillList.add(skills[skillIndex]);
        }
        return fightController.getSkill(skillList);
    }


        public IWeapon getWeapon(String weaponName){
        //武器是装饰者模式，传过来的参数是一个名字，根据传过来的名字进行ifelse选择创建武器
        if (weaponName.equalsIgnoreCase("枪")){
            return new Gun();
        }else if (weaponName.equalsIgnoreCase("装配二倍镜")){
            return new DoubleMirrorDecorator(new Gun());
        }else {
            return new DoubleMirrorDecorator(new Gun());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
