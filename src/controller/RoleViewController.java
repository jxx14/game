package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import view.Main;

import java.net.URL;
import java.util.ResourceBundle;


public class RoleViewController implements Initializable {
    @FXML
    private ToggleGroup myToggleGroup;

    private Main application;
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    public void choiceRole(ActionEvent event) {
        if (myToggleGroup.getSelectedToggle().getUserData().toString().equalsIgnoreCase("hero")){
            application.goToHero();
        }else {
            application.goToSoldier();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}