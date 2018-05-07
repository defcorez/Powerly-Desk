package ru.mrsnuff.powerly.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.mrsnuff.powerly.Powerly;
import ru.mrsnuff.powerly.model.Computer;
import ru.mrsnuff.powerly.utils.H2DB;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    private ObservableList<Computer> computersData = FXCollections.observableArrayList();
    public ObservableList<Computer> getComputersData() {
        return computersData;
    }

    @FXML private TableView<Computer> tableComputers;
    @FXML private TableColumn<Computer, String> nameColumn;
    @FXML private TableColumn<Computer, String> ipColumn;
    @FXML private TableColumn<Computer, String> statusColumn;

    @FXML
    private void initialize() throws SQLException {
        instance = this;

        nameColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("name"));
        ipColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("ip"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("status"));

        tableComputers.setItems(computersData);

        H2DB.initTable();
    }

    @FXML
    public void openAdder() throws IOException {
        Powerly.getInstance().showAdder();
    }

    @FXML
    public void removeComputer() {
        int selectedIndex = tableComputers.getSelectionModel().getFocusedIndex();
        if (selectedIndex >= 0) {
            H2DB.removeComputer(tableComputers.getItems().get(selectedIndex).getName());

            tableComputers.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Powerly.getInstance().getPrimaryStage());
            alert.setTitle("Внимание");
            alert.setHeaderText("Компьютер не выбран");
            alert.setContentText("Перед удалением компьютера его необходимо выбрать");

            alert.showAndWait();
        }
    }
}
