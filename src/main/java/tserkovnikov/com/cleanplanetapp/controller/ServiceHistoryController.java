package tserkovnikov.com.cleanplanetapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.model.PartnerServiceHistory;
import tserkovnikov.com.cleanplanetapp.service.ServiceHistoryService;

import java.util.List;

@Component
public class ServiceHistoryController {

    @FXML
    private Label partnerNameLabel;

    @FXML
    private TableView<PartnerServiceHistory> historyTable;

    @FXML
    private TableColumn<PartnerServiceHistory, String> serviceNameColumn;

    @FXML
    private TableColumn<PartnerServiceHistory, Integer> quantityColumn;

    @FXML
    private TableColumn<PartnerServiceHistory, String> dateColumn;

    private final ServiceHistoryService serviceHistoryService;

    public ServiceHistoryController(ServiceHistoryService serviceHistoryService) {
        this.serviceHistoryService = serviceHistoryService;
    }

    private Partner partner;


    public void setPartner(Partner partner) {
        this.partner = partner;
        loadHistory();
    }

    @FXML
    private void initialize() {
        serviceNameColumn.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("serviceDate"));
    }

    private void loadHistory() {
        if (partner == null) return;
        partnerNameLabel.setText("История услуг: " + partner.getName());

        List<PartnerServiceHistory> history = serviceHistoryService.getByPartner(partner.getId());
        historyTable.getItems().setAll(history);
    }

    @FXML
    private void onBack(ActionEvent event) {
        ((Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow()).close();
    }
}
