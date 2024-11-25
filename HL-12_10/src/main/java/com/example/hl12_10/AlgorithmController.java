package com.example.hl12_10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AlgorithmController {
    @FXML
    private ComboBox algorithmBox = new ComboBox();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Algorithm, String> typeColumn;
    @FXML
    private TableColumn<Algorithm, String> timeColumn;
    @FXML
    private TableColumn<Algorithm, String> memoryColumn;
    @FXML
    private Button loadFileButton;
    @FXML
    private Button runButton;


    private final ObservableList<Algorithm> algorithmData = FXCollections.observableArrayList();
    private final AlgorithmLibrary library = new AlgorithmLibrary();

    @FXML
    private void initialize(){
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<>("memory"));

        tableView.setItems(algorithmData);

        loadFileButton.setOnAction(event -> loadData());
        runButton.setOnAction(event -> runHandle());
    }

    private void loadData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open data to sort");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.txt"));
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        if (file != null) {
            algorithmData.clear();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        //store data into some array?
                    }
                    // ??
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }



    }

    @FXML
    protected void runHandle() {
        String selectedAlgorithm = algorithmBox.getId(); //?

    }
}