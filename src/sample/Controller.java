package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.scene.control.Button;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class Controller {
    DirectoryChooser directoryChooser = new DirectoryChooser();
    @FXML
    private TableView<TestFile> tableView;
    @FXML
    public Button directory;
    @FXML
    private TableColumn<Object, Object> FileNameColumn;
    @FXML
    private TableColumn<Object, Object> ActualClassColumn;
    @FXML
    private TableColumn<Object, Object> SpamProbabilityColumn;
    @FXML
    private TextField precision;
    @FXML
    private TextField accuracy;

    public void display() throws FileNotFoundException {
        Main.displayDirectoryChooser();

        FileNameColumn.setCellValueFactory(new PropertyValueFactory<>("filename"));
        ActualClassColumn.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        SpamProbabilityColumn.setCellValueFactory(new PropertyValueFactory<>("spamProbRounded"));
        tableView.setItems(DataSource.getAllFiles());

        precision.setText(Float.toString(DataSource.getPrecision()));
        accuracy.setText(Float.toString(DataSource.getAccuracy()));
    }
}
