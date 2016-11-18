package sample;

import javafx.animation.FillTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;


/**
 * Created by andre_000 on 17-Oct-16.
 */
public class Mob extends GameObject{

    private final static double RADIUS = 10;
    private final static double HP = 100;
    private static final double DP = 35;
    private static final double RANGE = 20;


    double speed = 5;
    private static final Color BG_COLOR = Color.RED;



    public Mob(int x, int y, GameFieldController gameFieldController){
        super(x,y, HP, RADIUS, BG_COLOR, gameFieldController);
        this.getStyleClass().add("mob");
        gameFieldController.getMobs().add(this);

    }

    public void progress(){

        if(target!=null){
            if (target.getHP()<=0){
                target=null;
            } else {
                if (target.getDistanceTo(this)<RANGE) {
                    target.damage(DP);
                }
                else
                {
                    stepTo(target.getX(), target.getY());
                }
            }
        }
        else {
            target=findNextTarget();
            if(target==null)
            {
                this.x+=speed;
                setCenterX(x);
            }
        }
    }
    Tower findNextTarget(){
        double minDist=0;
        Tower nextTarget=null;
        for(Tower tower:gameFieldController.getTowers()){
            if (nextTarget==null||getDistanceTo(tower)<minDist){
                nextTarget = tower;
                minDist = getDistanceTo(tower);
            }
        }
        return nextTarget;

    }
    void stepTo(double x, double y){
        double angle = Math.acos((target.getX()-this.x)/target.getDistanceTo(this));

        this.x+=speed*Math.cos(angle);
        this.y+=speed*Math.sin(angle)*(y<this.y?-1:1);
        setCenterX(this.x);
        setCenterY(this.y);
    }
}
