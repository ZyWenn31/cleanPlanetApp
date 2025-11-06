package tserkovnikov.com.cleanplanetapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.model.Employee;
import tserkovnikov.com.cleanplanetapp.service.EmployeeService;

import java.util.List;

@Component
public class UserFormController {
    @FXML private Label formTitle;
    @FXML private TextField nameField;
    @FXML private ComboBox<String> typeComboBox;
    @FXML private TextField accessField;
    @FXML private ComboBox<Boolean> healthField;
    @FXML private TextField passwordField;

    private final List<Boolean> typeOfHealth = List.of(Boolean.TRUE, Boolean.FALSE);
    private final List<String> typeOfPosition = List.of("Рабочий", "Менеджер", "Технолог", "Администратор");

    private final EmployeeService employeeService;

    public UserFormController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll(typeOfPosition);
        healthField.getItems().addAll(typeOfHealth);
    }

    public void onSave(ActionEvent event) {
        try {
            if (nameField.getText().isEmpty() || typeComboBox.getValue() == null || accessField.getText().isEmpty() || healthField.getValue() == null || passwordField.getText().isEmpty()) {
                throw new IllegalArgumentException("Заполните обязательные поля!");
            }

            Employee employee = new Employee();

            employee.setFullName(nameField.getText());
            employee.setPosition(typeComboBox.getValue());
            employee.setAccessCard(accessField.getText());
            employee.setHealthOk(healthField.getValue());
            employee.setPassword(passwordField.getText());

            employeeService.save(employee);
            //parentController.refreshTable();
            ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();

        } catch (NumberFormatException e) {
            showError("Рейтинг должен быть числом!");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Ошибка сохранения: " + e.getMessage());
        }
    }

    public void onCancel(ActionEvent event) {
        ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
        alert.setHeaderText("Ошибка");
        alert.showAndWait();
    }
}
