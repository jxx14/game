package view;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.HeroController;
import controller.RoleViewController;
import controller.SoldierController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 400.0;
    private final double MINIMUM_WINDOW_HEIGHT = 400.0;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Game");
        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
        goToChoiceRole();
        stage.show();

    }

    public void goToChoiceRole(){
        try {
            RoleViewController roleViewController = (RoleViewController) replaceSceneContent("role.fxml");
            roleViewController.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void goToHero(){
        stage.setTitle("Hero");
        try {
            HeroController heroController = (HeroController) replaceSceneContent("hero.fxml");
            heroController.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void goToSoldier(){
        stage.setTitle("Soldier");
        try {
            SoldierController soldierController = (SoldierController) replaceSceneContent("soldier.fxml");
            soldierController.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        GridPane page;
        try {
            page = (GridPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page ,400, 400);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
