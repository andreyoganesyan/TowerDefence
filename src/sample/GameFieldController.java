package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameFieldController {

    final int NUM_ROWS = 8;
    final int NUM_COLUMNS = 12;
    ArrayList<Tower> towers = new ArrayList<Tower>();
    ArrayList<Mob> mobs = new ArrayList<Mob>();

    public ArrayList<Mob> getMobs() {
        return mobs;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    @FXML
    Pane rootPane;
    @FXML
    GridPane towerField;

    @FXML
    void doAction(){
        for(Mob mob:mobs){
            mob.progress();
        }
        for(Tower tower:towers){
            tower.progress();
        }
    }
    @FXML
    void initialize(){
        GameFieldController gameFieldController = this;
        Mob mob = new Mob(320, 120, gameFieldController);
        rootPane.getChildren().add(mob);
        mob = new Mob(310, 50, gameFieldController);
        rootPane.getChildren().add(mob);
        mob = new Mob(300, 400, gameFieldController);
        rootPane.getChildren().add(mob);
        mob = new Mob(290, 320, gameFieldController);
        rootPane.getChildren().add(mob);
        mob = new Mob(330, 220, gameFieldController);
        rootPane.getChildren().add(mob);
        for (int i = 0; i<NUM_COLUMNS; i++){
            for (int j = 0; j<NUM_ROWS; j++){
                Button newButton = new Button();
                newButton.setFocusTraversable(false);
                newButton.getStyleClass().add("wouldbetower");
                newButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                       TowerChoiceMenu towerChoiceMenu = new TowerChoiceMenu(newButton, gameFieldController);
                        rootPane.getChildren().add(towerChoiceMenu);
                        towerChoiceMenu.setLayoutX(newButton.getLayoutX()+newButton.getParent().getLayoutX()-towerChoiceMenu.getPrefWidth()*0.7/2);
                        towerChoiceMenu.setLayoutY(newButton.getLayoutY()+newButton.getParent().getLayoutY()-towerChoiceMenu.getPrefHeight()*0.7/2);
                    }
                });
                //towerFieldArray[i][j] = newButton;
                towerField.getChildren().add(newButton);
                towerField.setColumnIndex(newButton, i);
                towerField.setRowIndex(newButton, j);
            }
        }
        Timeline timeline = new Timeline( new KeyFrame(
                Duration.millis(16),
                ae -> doAction()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void remove(GameObject gameObject){
        if (gameObject instanceof Mob){
            rootPane.getChildren().remove(gameObject);
            mobs.remove(gameObject);
        }
        if (gameObject instanceof Tower){
            Button newButton = getTowerFieldButton(gameObject.getX()-gameObject.getRadiusX(),
                    gameObject.getY()-gameObject.getRadiusY(),
                    towerField.getRowIndex(gameObject), towerField.getColumnIndex(gameObject));
            towerField.getChildren().add(newButton);
            towerField.setColumnIndex(newButton, towerField.getColumnIndex(gameObject));
            towerField.setRowIndex(newButton, towerField.getRowIndex(gameObject));
            towerField.getChildren().remove(gameObject);
            towers.remove(gameObject);

        }
    }

    private Button getTowerFieldButton(double layoutX, double layoutY, int rowIndex, int columnIndex){
        Button newButton = new Button();
        newButton.setFocusTraversable(false);
        newButton.getStyleClass().add("wouldbetower");
        GameFieldController gameFieldController = this;
        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TowerChoiceMenu towerChoiceMenu = new TowerChoiceMenu(newButton, gameFieldController);
                rootPane.getChildren().add(towerChoiceMenu);
                towerChoiceMenu.setLayoutX(newButton.getLayoutX()+newButton.getParent().getLayoutX()-towerChoiceMenu.getPrefWidth()*0.7/2);
                towerChoiceMenu.setLayoutY(newButton.getLayoutY()+newButton.getParent().getLayoutY()-towerChoiceMenu.getPrefHeight()*0.7/2);

            }
        });
        return newButton;
    }

}
