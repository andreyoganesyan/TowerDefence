package sample;

import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by andre_000 on 18-Nov-16.
 */
public abstract class GameObject extends Ellipse {


    abstract void progress();

    protected double hp;
    protected double x;
    protected double y;
    protected FillTransition attackedTransition;
    protected GameObject target = null;

    GameFieldController gameFieldController;


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getHP() {
        return hp;
    }

    public GameObject(double x, double y,double hp, double radius, Color bgColor, GameFieldController gameFieldController){
        super(x,y,radius,radius);
        this.x=x;
        this.y=y;
        this.hp=hp;
        this.gameFieldController = gameFieldController;
        setFill(bgColor);
        attackedTransition = new FillTransition(Duration.millis(100), this, Color.WHITE, bgColor);
    }

    public void damage(double dp){
        hp-=dp;
        attackedTransition.play();

        if (hp<0){
            gameFieldController.remove(this);
        }
    }


    double getDistanceTo(GameObject target){
        return Math.sqrt(Math.pow(this.x-target.getX(),2)+Math.pow(this.y-target.getY(),2));
    }
}
