package sample;

import javafx.scene.paint.Color;

/**
 * Created by andre_000 on 22-Nov-16.
 */
public class ThickMob extends Mob{

    private final static double HP = 150;
    private final static double SPEED = 0.7;
    public ThickMob(double x, double y, GameFieldController gameFieldController){
        super (x, y, gameFieldController, HP, SPEED);
        getStyleClass().add("thickmob");
        setStroke(Color.BLACK);
        setStrokeWidth(1.5);
    }
}
