package tserkovnikov.com.cleanplanetapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.service.PartnerService;

import java.util.ArrayList;
import java.util.List;

@Component
public class PartnerFormController {

    @FXML private Label formTitle;
    @FXML private TextField nameField;
    @FXML private ComboBox<String> typeComboBox;
    @FXML private TextField ratingField;
    @FXML private TextField addressField;
    @FXML private TextField directorField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;

    private final List<String> typeOfPartner = List.of("Корпоративный", "Розничный");

    private final PartnerService partnerService;
    private Partner partner;

    private PartnerListController parentController;

    public PartnerFormController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @FXML
    public void initialize() {
        typeComboBox.getItems().addAll(typeOfPartner);
    }

    public void setPartner(Partner partner) {
        this.partner = partner;

        if (partner != null) {
            formTitle.setText("Редактирование партнёра");
            nameField.setText(partner.getName());
            typeComboBox.setValue(partner.getType());
            ratingField.setText(String.valueOf(partner.getRating()));
            addressField.setText(partner.getAddress());
            directorField.setText(partner.getDirector());
            phoneField.setText(partner.getPhone());
            emailField.setText(partner.getEmail());
        } else {
            formTitle.setText("Добавление партнёра");
        }
    }

    public void setParentController(PartnerListController parentController) {
        this.parentController = parentController;
    }

    public void onSave(ActionEvent event) {
        try {
            if (nameField.getText().isEmpty() || typeComboBox.getValue() == null) {
                throw new IllegalArgumentException("Заполните обязательные поля!");
            }

            int rating = Integer.parseInt(ratingField.getText());
            if (rating < 0) throw new IllegalArgumentException("Рейтинг должен быть неотрицательным!");

            Partner partner = new Partner();

            partner.setName(nameField.getText());
            partner.setType(typeComboBox.getValue());
            partner.setRating(rating);
            partner.setAddress(addressField.getText());
            partner.setDirector(directorField.getText());
            partner.setPhone(phoneField.getText());
            partner.setEmail(emailField.getText());

            partnerService.save(partner);
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
