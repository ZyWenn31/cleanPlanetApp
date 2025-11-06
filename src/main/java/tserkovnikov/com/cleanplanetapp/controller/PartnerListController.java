package tserkovnikov.com.cleanplanetapp.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.configuration.FXMLConfiguration;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.service.PartnerService;
import tserkovnikov.com.cleanplanetapp.service.ServiceHistoryService;

import java.io.IOException;
import java.util.List;

@Component
public class PartnerListController {
    private final ApplicationContext applicationContext;
    @FXML private TableView<Partner> partnerTable;
    @FXML private TableColumn<Partner, Long> idColumn;
    @FXML private TableColumn<Partner, String> nameColumn;
    @FXML private TableColumn<Partner, String> typeColumn;
    @FXML private TableColumn<Partner, Integer> ratingColumn;
    @FXML private TableColumn<Partner, String> addressColumn;
    @FXML private TableColumn<Partner, String> directorColumn;
    @FXML private TableColumn<Partner, String> phoneColumn;
    @FXML private TableColumn<Partner, String> emailColumn;

    private final PartnerService partnerService;
    private final FXMLConfiguration fxmlConfiguration;

    public PartnerListController(ApplicationContext applicationContext, PartnerService partnerService, FXMLConfiguration fxmlConfiguration) {
        this.applicationContext = applicationContext;
        this.partnerService = partnerService;
        this.fxmlConfiguration = fxmlConfiguration;
    }

    @FXML
    public void initialize() {
        // Привязываем столбцы к полям модели Partner
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Загружаем данные в таблицу
        refreshTable();
    }

    /**
     * Загружает список партнеров из базы данных и отображает в таблице.
     */
    public void refreshTable() {
        List<Partner> partners = partnerService.getAll();
        partnerTable.getItems().setAll(partners);
    }

    public void onAddPartner(ActionEvent event) throws IOException {
        openForm(null);
    }

    public void onEditPartner(ActionEvent event) throws IOException {
        Partner selected = partnerTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Выберите партнёра для редактирования.");
            return;
        }
        openForm(selected);
    }

    public void onDeletePartner(ActionEvent event) {
        Partner selected = partnerTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Выберите партнёра для удаления.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Удалить выбранного партнёра?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Подтверждение удаления");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                partnerService.delete(selected.getId());
                refreshTable();
            }
        });
    }

    @FXML
    public void updateTable(){
        refreshTable();
    }

    private void openForm(Partner partner) throws IOException {
        Stage stage = fxmlConfiguration.PartnerFormFXNLLoader();

        if (partner == null){
            stage.setTitle("Добавление партнёра");
        }else {
//            stage.setTitle("Редактирование партнёра");
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tserkovnikov/com/cleanplanetapp/partner-form.fxml"));
//            loader.setControllerFactory(applicationContext::getBean); // если используешь Spring
//
//            // Получаем контроллер после загрузки
//            PartnerFormController controller = loader.getController();
//            controller.setPartner(partner);
        }

        stage.show();
    }

    @FXML
    public void onViewHistory() {
        Partner selectedPartner = partnerTable.getSelectionModel().getSelectedItem();

        if (selectedPartner == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Партнёр не выбран");
            alert.setContentText("Пожалуйста, выберите партнёра из списка, чтобы просмотреть историю услуг.");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tserkovnikov/com/cleanplanetapp/partner_service_history.fxml"));
            loader.setControllerFactory(applicationContext::getBean); // если используешь Spring

// Сначала загружаем FXML
            Parent root = loader.load();

// Получаем контроллер после загрузки
            ServiceHistoryController controller = loader.getController();
            controller.setPartner(selectedPartner);

// Создаём и показываем Stage
            Stage stage = fxmlConfiguration.getHistory(); // или новый Stage
            stage.setScene(new Scene(root));
            stage.setTitle("История услуг партнёра");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка загрузки");
            alert.setHeaderText("Не удалось открыть историю");
            alert.setContentText("Произошла ошибка при открытии окна истории услуг.");
            alert.showAndWait();
        }
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
