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

    @FXML //error checking
    private static boolean foundFile = false;

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
    public void loadData() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Data to Sort");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(tableView.getScene().getWindow());

        if (file != null) {

            data.clear();

            if (file.length() == 0) {
                AlertMessage.showAlert("no data");
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    String[] values = line.split(","); // Split by commas
                    for (String value : values) {
                        data.add(value.trim()); // Add each value to the list
                    }
                }
            } catch (FileNotFoundException e) {
                AlertMessage.showAlert("file missing");
            } catch (IOException e) {
                AlertMessage.showAlert("incorrect data");
            }

            System.out.println("Size of data: " + data.size());

            foundFile = true;
        }
    }




    @FXML
    protected void runHandle() { //Run the algorithm with the data loaded, check if data is loaded in or not
        String selectedAlgorithm = (String) algorithmBox.getValue();

        if (selectedAlgorithm != null && foundFile) { //check and activate an algorithm

            List<String> outputData;

            System.gc();
            long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long startTime = System.nanoTime();

            switch (selectedAlgorithm) {
                case "BubbleSort":
                    outputData = library.bubbleSort(data);
                    break;
                case "HeapSort":
                    outputData = library.heapSort(data);
                    break;
                case "QuickSort":
                    outputData = library.quickSort(data);
                    break;
                case "InsertionSort":
                    outputData = library.insertionSort(data);
                    break;
                case "SelectionSort":
                    outputData = library.selectionSort(data);
                    break;
                case "MergeSort":
                    outputData = library.mergeSort(data);
                    break;
                default:
                    AlertMessage.showAlert("No algorithm selected");
                    return;
            }

            // Baigiam matuot
            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long endTime = System.nanoTime();

            // Skaičiuojam laika ir atminti
            long memoryUsed = endMemory - startMemory;
            long timeTaken = (endTime - startTime); // Laikas nanosekundėmis

            System.out.println("Atmintis:" + memoryUsed);
            System.out.println("Laikas:" + timeTaken);
            // Įrašome rezultatą
            algorithmData.add(new AlgorithmData(selectedAlgorithm, timeTaken, memoryUsed));


            inputOutputData.clear(); // Išvalome seną informaciją

            for (int i = 0; i < data.size(); i++) { //~~! what is this doing exactly and how?
                String inputRow = data.get(i);
                String outputRow = i < outputData.size() ? outputData.get(i) : "";
                inputOutputData.add(new InputOutputData(inputRow, outputRow));
            }

            tableView1.refresh();

        } else if (!foundFile) {
            AlertMessage.showAlert("file missing");
        }
        else AlertMessage.showAlert("no algorithm");
    }
}