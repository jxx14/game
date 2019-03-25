package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import model.role.IRole;
import view.Main;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class RoleViewController implements Initializable {
    @FXML
    private ToggleGroup myToggleGroup;
    private IRole role;
    private FightController fightController =new FightController();

    public static Map<String, IRole> dataMap = new HashMap<String, IRole>();
    public static Map<String, IRole> data = new HashMap<String, IRole>();


    private Main application;
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    public void choiceRole(ActionEvent event) {

        String roleKind = myToggleGroup.getSelectedToggle().getUserData().toString();

        if (roleKind.equalsIgnoreCase("hero")){
            application.goToHero();
        }else {
            application.goToSoldier();
        }

        role =  fightController.creatRole(roleKind);

        data.put("role",role);

//        if (roleKind.equalsIgnoreCase("soldier")){
//            SoldierController soldierController=(SoldierController) StageManager.CONTROLLER.get("SoliderController");
//            soldierController.setRole(role);
//        }else {
//            HeroController heroController =(HeroController) StageManager.CONTROLLER.get("HeroController");
//            heroController.setRole(role);
//        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}