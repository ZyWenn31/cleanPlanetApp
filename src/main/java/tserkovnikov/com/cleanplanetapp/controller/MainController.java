package tserkovnikov.com.cleanplanetapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.configuration.FXMLConfiguration;
import tserkovnikov.com.cleanplanetapp.util.LoginInfo;

@Component
public class MainController {

    private final FXMLConfiguration fxmlConfiguration;

    public MainController(FXMLConfiguration fxmlConfiguration) {
        this.fxmlConfiguration = fxmlConfiguration;
    }

    public void onOpenPartners(ActionEvent event) throws Exception {
       Stage stage = fxmlConfiguration.PartnerListFXNLLoader();
       stage.show();
       ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    private Button partnerBtn;

    @FXML
    private Button userBtn;

    public void onOpenUsers(ActionEvent event) throws Exception {
        Stage stage = fxmlConfiguration.getAllUsers();
        stage.show();
        ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    public void initialize() {
        if (LoginInfo.getLoginUserPosition().equals("Администратор")){
            userBtn.visibleProperty().set(true);
            partnerBtn.visibleProperty().set(false);
        } else {
            userBtn.visibleProperty().set(false);
            partnerBtn.visibleProperty().set(true);
        }
    }

    public void onExit(ActionEvent event) {
        ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }
}