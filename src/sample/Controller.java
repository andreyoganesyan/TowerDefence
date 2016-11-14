package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Controller {

    final int NUM_ROWS = 8;
    final int NUM_COLUMNS = 12;
    Button[][] towerFieldArray = new Button[NUM_COLUMNS][NUM_ROWS];

    @FXML
    Pane rootPane;
    @FXML
    GridPane towerField;

    @FXML
    void doAction(){

    }
    @FXML
    void initialize(){
        for (int i = 0; i<NUM_COLUMNS; i++){
            for (int j = 0; j<NUM_ROWS; j++){
                Button newButton = new Button();
                newButton.setFocusTraversable(false);
                newButton.getStyleClass().add("wouldbetower");
                newButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Ellipse ellipse = new Ellipse(); {
                            ellipse.setCenterX(newButton.getLayoutX()+newButton.getParent().getLayoutX()+newButton.getPrefWidth()/2);
                            ellipse.setCenterY(newButton.getLayoutY()+newButton.getParent().getLayoutY()+newButton.getPrefHeight()/2);
                            ellipse.setRadiusX(50.0f);
                            ellipse.setRadiusY(50.0f);
                            ellipse.setFill(Color.WHITE);
                            ScaleTransition st = new ScaleTransition(Duration.millis(200), ellipse);
                            st.setFromX(0.1);
                            st.setFromY(0.1);
                            st.setToX(1);
                            st.setToY(1);
                            st.play();
                        }
                        rootPane.getChildren().add(ellipse);
                        ellipse.setOnMouseExited(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                rootPane.getChildren().remove(ellipse);
                            }
                        });
                    }
                });
                towerFieldArray[i][j] = newButton;
                towerField.getChildren().add(newButton);
                towerField.setColumnIndex(newButton, i);
                towerField.setRowIndex(newButton, j);
            }
        }
    }
}
