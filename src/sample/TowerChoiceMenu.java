package sample;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

/**
 * Created by andre_000 on 21-Nov-16.
 */
public class TowerChoiceMenu extends Pane{
    public TowerChoiceMenu(Button button, GameFieldController gameFieldController){
        TowerChoiceMenu towerChoiceMenu = this;
        this.setPrefHeight(75);
        this.setPrefWidth(75);
        Ellipse ellipse = new Ellipse();
        {
            ellipse.setCenterX(42);
            ellipse.setCenterY(45);
            ellipse.setRadiusX(30.0f);
            ellipse.setRadiusY(30.0f);
            ellipse.setFill(Color.WHITE);
        }
        getChildren().add(ellipse);
        GridPane towerField= gameFieldController.towerField;

        Pane rootPane= gameFieldController.rootPane;
        Button redButton = new Button();
        redButton.getStyleClass().add("redbutton");
        redButton.setLayoutX(27);
        redButton.setLayoutY(0);



        redButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameFieldController.money>=30) {
                    gameFieldController.money-=30;
                    SiegeTower newTower = new SiegeTower(button.getLayoutX() + button.getPrefWidth() / 2 + button.getParent().getLayoutX(), button.getLayoutY() + button.getPrefHeight() / 2 + button.getParent().getLayoutY(), gameFieldController);

                    towerField.getChildren().add(newTower);
                    towerField.setRowIndex(newTower, towerField.getRowIndex(button));
                    towerField.setColumnIndex(newTower, towerField.getColumnIndex(button));
                    towerField.getChildren().remove(button);
                    towerChoiceMenu.setOnMouseExited(null);
                    rootPane.getChildren().remove(towerChoiceMenu);
                }
            }
        });

        Button blueButton = new Button();
        blueButton.getStyleClass().add("bluebutton");
        blueButton.setLayoutX(0);
        blueButton.setLayoutY(45);
        blueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameFieldController.money>=30) {
                    gameFieldController.money-=30;
                    ElectricTower newTower = new ElectricTower(button.getLayoutX()+button.getPrefWidth()/2+button.getParent().getLayoutX(), button.getLayoutY()+button.getPrefHeight()/2+button.getParent().getLayoutY(), gameFieldController);

                    towerField.getChildren().add(newTower);
                    towerField.setRowIndex(newTower, towerField.getRowIndex(button));
                    towerField.setColumnIndex(newTower, towerField.getColumnIndex(button));
                        towerField.getChildren().remove(button);
                    towerChoiceMenu.setOnMouseExited(null);
                    rootPane.getChildren().remove(towerChoiceMenu);
                }
            }
        });
        Button greenButton = new Button();
        greenButton.setLayoutX(54);
        greenButton.setLayoutY(45);
        greenButton.getStyleClass().add("greenbutton");
        greenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gameFieldController.money>=30) {
                    gameFieldController.money -= 30;
                    SniperTower newTower = new SniperTower(button.getLayoutX() + button.getPrefWidth() / 2 + button.getParent().getLayoutX(), button.getLayoutY() + button.getPrefHeight() / 2 + button.getParent().getLayoutY(), gameFieldController);

                    towerField.getChildren().add(newTower);
                    towerField.setRowIndex(newTower, towerField.getRowIndex(button));
                    towerField.setColumnIndex(newTower, towerField.getColumnIndex(button));
                    towerField.getChildren().remove(button);
                    towerChoiceMenu.setOnMouseExited(null);
                    rootPane.getChildren().remove(towerChoiceMenu);
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                rootPane.getChildren().remove(towerChoiceMenu);
            }
        });

        getChildren().add(greenButton);
        getChildren().add(blueButton);
        getChildren().add(redButton);
        FadeTransition ft = new FadeTransition(Duration.millis(200), this);
        ft.setFromValue(0);
        ft.setToValue(1);
        ScaleTransition st = new ScaleTransition(Duration.millis(200), this);
        st.setFromX(0.5);
        st.setFromY(0.5);
        st.setToX(0.7);
        st.setToY(0.7);
        st.play();
        ft.play();
    }
}
