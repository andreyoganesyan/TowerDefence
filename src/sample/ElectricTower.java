package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by andre_000 on 21-Nov-16.
 */
public class ElectricTower extends Tower{
    ArrayList<ElectricTower> connectedTowers = new ArrayList<ElectricTower>();
    private static final double RANGE=100;
    private static final double DP = 35;
    private static final double HP = 100;
    int charge = 100;
    private static final Color BG_COLOR = Color.AQUA;

    @Override
    void progress() {

    }
    public ElectricTower(double x, double y, GameFieldController gameFieldController){
        super(x, y, HP, BG_COLOR,  gameFieldController);

        gameFieldController.getTowers().add(this);
        this.getStyleClass().add("electrictower");
    }
}
