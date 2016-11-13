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

    private Tower target = null;
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

    public Mob(int x, int y){
        this.x = x;
        this.y=y;
    }

    void findNextTarget(){

    }
}
