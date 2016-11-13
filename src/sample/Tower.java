package sample;
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * Created by andre_000 on 17-Oct-16.
 */
public abstract class Tower extends Button implements Attackable {

    ArrayList<Tower> attackers = new ArrayList<Tower>();

    double x,y;
    double hp = 100;
    @Override
    public double getX(){
        return  x;
    }
    @Override
    public double getY(){
        return y;
    }
    @Override
    public double getHP(){
        return hp;
    }
    @Override
    public void  damage(double dp){
        hp-=dp;
        if (hp<=0){
            //destroy();
        }
    }


    public Tower(double x, double y){
        super("");
        this.x=x;
        this.y=y;

    }






}
