package sample;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre_000 on 17-Oct-16.
 */
public abstract class GameObject {

    ArrayList<GameObject> attackers = new ArrayList<GameObject>();

    double x,y;
    double hp = 100;

    public double getX(){
        return  x;
    }

    public double getY(){
        return y;
    }

    public double getHP(){
        return hp;
    }

    public void  damage(double dp){
        hp-=dp;
        if (hp<=0){
            destroy();
        }
    }

    abstract void targetDestroyed();
    void destroy() {
        for (GameObject attacker : attackers) {
            attacker.targetDestroyed();
        }
    }

//    public GameObject(){
//
//    }
    public GameObject(double x, double y){
        this.x=x;
        this.y=y;
    }


}
