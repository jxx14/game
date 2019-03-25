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
import model.weapon.gun.DoubleMirrorDecorator;
import model.weapon.gun.Gun;
import view.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
    private int count;
    RoleFactory factory =new RoleFactory();
    private IRole role =factory.getRole("soldier");

    @FXML
    public void fight(ActionEvent event) {

        //每一次随机初始化一个敌人
        count = count+1;
        Enemy enemy;
        if (count==0){
            enemy=new Enemy("罪犯",10,10);
        }else {
            enemy=fightController.creatEnemy("罪犯");
        }

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

        public IWeapon getWeapon(String weaponName){
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
