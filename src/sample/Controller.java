package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {

    final int NUM_ROWS = 8;
    final int NUM_COLUMNS = 8;
    Button[][] towerFieldArray = new Button[NUM_COLUMNS][NUM_ROWS];

    @FXML
    GridPane towerField;

    @FXML
    void doAction(){

    }
    @FXML
    void initialize(){
        for (int i = 0; i<NUM_COLUMNS; i++){
            for (int j = 0; j<NUM_ROWS; j++){
                Button newButton = new Button("");
                newButton.setFocusTraversable(false);
                newButton.getStyleClass().add("wouldbetower");
                towerFieldArray[i][j] = newButton;
                towerField.getChildren().add(newButton);
                towerField.setColumnIndex(newButton, i);
                towerField.setRowIndex(newButton, j);
            }
        }

    }
}
