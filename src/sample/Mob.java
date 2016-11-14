package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;


/**
 * Created by andre_000 on 17-Oct-16.
 */
public class Mob implements Attackable{

    Tower target = null;
    GameFieldController gameFieldController;
    double range = 20;
    double dp=10;
    double speed;
    private double hp = 100;
    private double x;
    private double y;


    @Override
    public double getX(){
        return x;
    }
    @Override
    public double getY(){
        return y;
    }

    @Override
    public double getHP() {
        return hp;
    }
    @Override
    public void damage(double dp){
        hp-=dp;
    }

    public Mob(int x, int y, GameFieldController gameFieldController){
        this.x = x;
        this.y=y;
        this.gameFieldController=gameFieldController;
    }

    public void progress(){
        if(target!=null){
            if (target.getDistanceTo(this)<range) {
                target.damage(dp);
                if (target.getHP()<=0){
                    target=null;
                }
            }
            else
            {
                double angle = (target.getX()-this.x)/target.getDistanceTo(this);
                x+=speed*Math.cos(angle);
                y+=speed*Math.sin(angle);
            }
        }
        else {
            target=findNextTarget();
            if(target!=null){
                if (target.getDistanceTo(this)<range) {
                    target.damage(dp);
                    if (target.getHP()<=0){
                        target=null;
                    }
                }
                else
                {
                    double angle = (target.getX()-this.x)/target.getDistanceTo(this);
                    x+=speed*Math.cos(angle);
                    y+=speed*Math.sin(angle);
                }
            }
            else {
                this.x+=speed;
            }
        }
    }
    Tower findNextTarget(){
        double minDist=0;
        Tower nextTarget=null;
        for(Tower tower:gameFieldController.getTowers()){
            if (tower.getHP()>0&&nextTarget==null||tower.getDistanceTo(this)<minDist){
                nextTarget = tower;
            }
        }
        return nextTarget;

    }
}
