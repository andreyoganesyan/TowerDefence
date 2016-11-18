package sample;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by andre_000 on 17-Oct-16.
 */
public abstract class Tower extends GameObject {

    private static final double RADIUS=15;


    public Tower(double x, double y, double hp, Color bgColor, GameFieldController gameFieldController){
        super(x,y,hp,RADIUS, bgColor, gameFieldController);
        this.x=x;
        this.y=y;
    }

}
