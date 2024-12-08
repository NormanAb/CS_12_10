package com.example.hl12_10;

import Utilities.AlertMessage;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmController {
    @FXML
    private ComboBox algorithmBox = new ComboBox();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<AlgorithmData, String> typeColumn;
    @FXML
    private TableColumn<AlgorithmData, String> timeColumn;
    @FXML
    private TableColumn<AlgorithmData, String> memoryColumn;
    @FXML
    private TableView tableView1;
    @FXML
    private TableColumn<AlgorithmData, String> inputColumn;
    @FXML
    private TableColumn<AlgorithmData, String> outputColumn;

    @FXML
    private Button loadFileButton;
    @FXML
    private Button runButton;


    private final ObservableList<AlgorithmData> algorithmData = FXCollections.observableArrayList();
    private final ObservableList<InputOutputData> inputOutputData = FXCollections.observableArrayList();
    private final AlgorithmLibrary library = new AlgorithmLibrary();
    private final List<String> data = new ArrayList<>();


    @FXML
    private void initialize(){
        algorithmBox.setItems(FXCollections.observableArrayList("BubbleSort", "HeapSort", "QuickSort", "InsertionSort", "SelectionSort", "MergeSort"));


        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("timeTaken"));
        memoryColumn.setCellValueFactory(new PropertyValueFactory<>("memoryTaken"));
        tableView.setItems(algorithmData);


        inputColumn.setCellValueFactory(new PropertyValueFactory<>("inputData"));
        outputColumn.setCellValueFactory(new PropertyValueFactory<>("outputData"));
        tableView1.setItems(inputOutputData);

        loadFileButton.setOnAction(event -> loadData());
        runButton.setOnAction(event -> runHandle());
    }

    @FXML
    public void loadData() { //take in data from a csv file
        String temp;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open data to sort");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("text files", "*.csv"));
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        if (file != null) {
            data.clear();

            if (file.length() ==0) {
                AlertMessage.showAlert("incorrect data");
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    data.add(line.trim());
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                AlertMessage.showAlert("file missing");
                throw new RuntimeException(e);
            } catch (IOException e) {
                AlertMessage.showAlert("incorrect data");
                throw new RuntimeException(e);
            }
        }
    }




    @FXML
    protected void runHandle() { //Run the algorithm with the data loaded, check if data is loaded in or not
        String selectedAlgorithm = (String) algorithmBox.getValue(); //?

        if (selectedAlgorithm != null) { //check and activate an algorithm

            List<String> inputData = new ArrayList<>(data);
            List<String> outputData = new ArrayList<>(data); //Change outputData with algorithm selected

            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            switch (selectedAlgorithm) {
                case "BubbleSort":
                    library.bubbleSort(outputData, outputData.size());
                    break;
                case "HeapSort":
                    library.heapSort(outputData);
                    break;
                case "QuickSort":
                    library.quickSort(outputData);
                    break;
                case "InsertionSort":
                    library.insertionSort(outputData);
                    break;
                case "SelectionSort":
                    library.selectionSort(outputData);
                    break;
                case "MergeSort":
                    library.mergeSort(outputData);
                    break;
            }

            //??????????

            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long endTime = System.currentTimeMillis();

            long memoryUsed = endMemory - startMemory;
            long timeTaken = endTime - startTime;

            algorithmData.add(new AlgorithmData(selectedAlgorithm, timeTaken, memoryUsed));

            inputOutputData.clear(); //reset table after iteration

            for (int i = 0; i < inputData.size(); i++) {
                String inputRow = inputData.get(i);
                String outputRow = i < outputData.size() ? outputData.get(i) : "";
                inputOutputData.add(new InputOutputData(inputRow, outputRow));
            }
        }
        else {
            AlertMessage.showAlert("no algorithm selected");
        }
    }
}