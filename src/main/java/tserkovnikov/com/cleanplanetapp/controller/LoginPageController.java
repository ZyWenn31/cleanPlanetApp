package tserkovnikov.com.cleanplanetapp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.configuration.FXMLConfiguration;
import tserkovnikov.com.cleanplanetapp.model.Employee;
import tserkovnikov.com.cleanplanetapp.service.EmployeeService;
import tserkovnikov.com.cleanplanetapp.util.LoginInfo;

import java.io.IOException;

@Component
public class LoginPageController {

    private final FXMLConfiguration fxmlConfiguration;
    private final EmployeeService employeeService;

    @FXML
    private Label welcomeText;

    @FXML
    private Button myBtn;

    public LoginPageController(FXMLConfiguration fxmlConfiguration, EmployeeService employeeService) {
        this.fxmlConfiguration = fxmlConfiguration;
        this.employeeService = employeeService;
    }

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Label waring;

    @FXML
    public void initialize() {
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {

        Employee employee = employeeService.getByNameAndPassword(login.getText(), password.getText());
        if (employee == null) {
            waring.visibleProperty().set(true);
            return;
        }

        LoginInfo.setLoginUserPosition(employee.getPosition());
        LoginInfo.setLoginUserId(employee.getId());

        Stage stage2 = (Stage) myBtn.getScene().getWindow();
        Stage stage = fxmlConfiguration.helloPageFXNLLoader();

        stage.show();
        stage2.close();
    }
}
