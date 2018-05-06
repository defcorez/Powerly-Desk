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

import java.io.IOException;

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
    private void initialize() {
        instance = this;

        nameColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("name"));
        ipColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("ip"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Computer, String>("status"));

        tableComputers.setItems(computersData);

        computersData.add(new Computer("Основной", "192.168.1.100", "Online", "123", "123"));
        computersData.add(new Computer("Соседний", "192.168.1.101", "Offline", "123", "123"));
        computersData.add(new Computer("Домашний сервер", "192.168.1.102", "Online", "123", "123"));
    }

    @FXML
    public void openAdder() throws IOException {
        Powerly.getInstance().showAdder();
    }

    @FXML
    public void removeComputer() {
        int selectedIndex = tableComputers.getSelectionModel().getFocusedIndex();
        if (selectedIndex >= 0) {
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
