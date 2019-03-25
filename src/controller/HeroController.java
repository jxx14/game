package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import model.enemy.Enemy;
import model.equipment.Equipment;
import model.role.IRole;
import model.role.RoleFactory;
import model.skill.Skill;
import model.weapon.IWeapon;
import model.weapon.sword.BlueSwordDecorator;
import model.weapon.sword.RedSwardDecorator;
import model.weapon.sword.Sword;
import view.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class HeroController implements Initializable {
    private Equipment equipment;
    private IWeapon weapon;
    private Skill skill;
    private int count;
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
    private Main application;
    RoleFactory factory =new RoleFactory();

    private IRole role =factory.getRole("soldier");
    public void setApp(Main application){
        this.application = application;
    }

//    Map<String, IRole> data = RoleViewController.data;// 调用上一个controller
    private FightController fightController =new FightController();

    private String skills[] ={"不选择技能","风","土","组合"};
    private String weapons[] ={"不使用剑","剑","装配1个红宝石配件","装配2个红宝石配件",
            "装配1个蓝宝石配件","装配2个蓝宝石配件","装配蓝宝石和红宝石各一个"};

    @FXML
    public void fight(ActionEvent event) {
        count = count+1;
        //每一次随机初始化一个敌人
        Enemy enemy;
        if (count==0){
            enemy=new Enemy("罪犯",10,10);
        }else {
            enemy=fightController.creatEnemy("罪犯");
        }

        actionTarget.setText(fightController.getRoleInfo(role));
        actionTargetEnemy.setText(fightController.getEnemyInfo(enemy));

        actionTarget.setText(fightController.getRoleInfo(role));
        actionTargetEnemy.setText(fightController.getEnemyInfo(enemy));

        int weaponIndex =weaponComboBox.getSelectionModel().getSelectedIndex();
        if(weaponIndex!=0){
            weapon = getWeapon(weapons[weaponIndex]);
        }
        int equipmentIndex = equipmentComboBox.getSelectionModel().getSelectedIndex();
        if (equipmentIndex!=0){
            equipment = fightController.getEquipment(equipmentIndex);
        }

        int skillIndex=skillComboBox.getSelectionModel().getSelectedIndex();
        if (skillIndex!=0){
            skill = getSkill(skillIndex);
        }
        fightController.getResult(skill,weapon,role,enemy,equipment);

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

    public IWeapon getWeapon(String weaponName) {
        switch (weaponName) {
            case "剑":
                return new Sword();
            case "装配1个红宝石配件":
                return new RedSwardDecorator(new Sword());
            case "装配2个红宝石配件":
                return new RedSwardDecorator(new RedSwardDecorator(new Sword()));
            case "装配1个蓝宝石配件":
                return new BlueSwordDecorator(new Sword());
            case "装配2个蓝宝石配件":
                return new BlueSwordDecorator(new BlueSwordDecorator(new Sword()));
            case "装配蓝宝石和红宝石各一个":
                return new BlueSwordDecorator(new RedSwardDecorator(new Sword()));

        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
