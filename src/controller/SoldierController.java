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
import view.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class SoldierController implements Initializable {

    private Main application;
    public void setApp(Main application){
        this.application = application;
    }

    private util util =new util();
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

    //    private String equipments[] ={"不选择装备","装备1","装备2","组合"};
    private Equipment equipment;
    private IWeapon weapon;
    private Skill skill;
    private int count;
    private int temp;
    private IRole role =new RoleFactory().getRole("soldier");

    @FXML
    public void fight(ActionEvent event) {

        //每一次随机初始化一个敌人
        count = count+1;
        Enemy enemy;
        if (count==0){
            enemy=new Enemy("罪犯",10,10);
        }else {
            enemy= util.createEnemy("罪犯");
        }

        actionTarget.setText(util.getRoleInfo(role));
        actionTargetEnemy.setText(util.getEnemyInfo(enemy));

        int weaponIndex =weaponComboBox.getSelectionModel().getSelectedIndex();
        if(weaponIndex!=0){
            weapon = util.getGun(weaponIndex);
        }
        int equipmentIndex = equipmentComboBox.getSelectionModel().getSelectedIndex();
        if (equipmentIndex!=0){
            equipment = util.getEquipment(equipmentIndex);
        }

        int skillIndex=skillComboBox.getSelectionModel().getSelectedIndex();
        if (skillIndex!=0){
            skill =getSkill(skillIndex);
        }
        util.getResult(skill,weapon,role,enemy,equipment);

        if (role.getLevel()==2){
            temp= temp+1;
            if (temp==1){
                skillComboBox.getItems().addAll(
                        "二级风技能伤害100",
                        "二级火技能伤害90",
                        "一级风技能，二级火技能伤害140",
                        "二级风技能，一级火技能伤害150",
                        "二级风技能，二级火技能伤害190"
                );
            }
        }
    }

    public Skill getSkill(int skillIndex) {
        switch (skillIndex) {
            case 1:
                return role.getSkill("windOne");
            case 2:
                return role.getSkill("fireOne");
            case 3:
                return role.getSkill("windOneAndFireOne");
            case 4:
                return role.getSkill("windTwo");
            case 5:
                return role.getSkill("fireTwo");
            case 6:
                return role.getSkill("windOneAndFireTwo");
            case 7:
                return role.getSkill("windTwoAndFireTwo");
            case 8:
                return role.getSkill("WindTwoAndFireTwo");
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
