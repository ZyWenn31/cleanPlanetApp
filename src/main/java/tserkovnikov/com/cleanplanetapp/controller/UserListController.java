package tserkovnikov.com.cleanplanetapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.configuration.FXMLConfiguration;
import tserkovnikov.com.cleanplanetapp.model.Employee;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.service.EmployeeService;

import java.io.IOException;
import java.util.List;

@Component
public class UserListController {

    @FXML private TableView<Employee> userTable;
    @FXML private TableColumn<Employee, Long> idColumn;
    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> positionColumn;
    @FXML private TableColumn<Employee, String> passwordColumn;

    private final EmployeeService employeeService;
    private final FXMLConfiguration fxmlConfiguration;

    public UserListController(EmployeeService employeeService, FXMLConfiguration fxmlConfiguration) {
        this.employeeService = employeeService;
        this.fxmlConfiguration = fxmlConfiguration;
    }


    @FXML
    public void initialize() {
        // Привязываем столбцы к полям модели Partner
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        // Загружаем данные в таблицу
        refreshTable();
    }

    /**
     * Загружает список партнеров из базы данных и отображает в таблице.
     */
    public void refreshTable() {
        List<Employee> employees = employeeService.getAll();
        userTable.getItems().setAll(employees);
    }

    private void openForm() throws IOException {
        Stage stage = fxmlConfiguration.getUserForm();

        stage.show();
    }

    public void onAddPartner(ActionEvent event) throws IOException {
        openForm();
    }

    public void onDeletePartner(ActionEvent event) {
        Employee selected = userTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Выберите пользователя для удаления.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Удалить выбранного пользователя?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Подтверждение удаления");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                employeeService.delete(selected.getId());
                refreshTable();
            }
        });
    }

    @FXML
    public void updateTable(){
        refreshTable();
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK).showAndWait();
    }

    public void onBackClicked(ActionEvent event) throws IOException {
        Stage stage = fxmlConfiguration.helloPageFXNLLoader();
        stage.show();
        ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }
}
