package sample;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

/**
 * Created by andre_000 on 21-Nov-16.
 */
public class TowerChoiceMenu extends StackPane{
    public TowerChoiceMenu(Button button, GameFieldController gameFieldController){
        this.setPrefHeight(50);
        this.setPrefWidth(50);
        Ellipse ellipse = new Ellipse();
        {
            ellipse.setCenterX(50);
            ellipse.setCenterY(50);
            ellipse.setRadiusX(50.0f);
            ellipse.setRadiusY(50.0f);
            ellipse.setFill(Color.WHITE);
        }
        GridPane towerField= gameFieldController.towerField;
        Button redButton = new Button();

        redButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SiegeTower newTower = new SiegeTower(button.getLayoutX()+button.getPrefWidth()/2+button.getParent().getLayoutX(), button.getLayoutY()+button.getPrefHeight()/2+button.getParent().getLayoutY(), gameFieldController);

                towerField.getChildren().add(newTower);
                towerField.setRowIndex(newTower, towerField.getRowIndex(button));
                towerField.setColumnIndex(newTower, towerField.getColumnIndex(button));
                towerField.getChildren().remove(button);
            }
        });

        Button blueButton = new Button();
        blueButton.getStyleClass().add("bluebutton");
        blueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ElectricTower newTower = new ElectricTower(button.getLayoutX()+button.getPrefWidth()/2+button.getParent().getLayoutX(), button.getLayoutY()+button.getPrefHeight()/2+button.getParent().getLayoutY(), gameFieldController);

                towerField.getChildren().add(newTower);
                towerField.setRowIndex(newTower, towerField.getRowIndex(button));
                towerField.setColumnIndex(newTower, towerField.getColumnIndex(button));
                towerField.getChildren().remove(button);
            }
        });

        ScaleTransition st = new ScaleTransition(Duration.millis(200), this);
        st.setFromX(0.1);
        st.setFromY(0.1);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }
}
