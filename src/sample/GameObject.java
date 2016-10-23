package sample;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andre_000 on 17-Oct-16.
 */
public abstract class GameObject {

    ArrayList<GameObject> attackers = new ArrayList<GameObject>();

    int x,y;
    double hp = 100;

    public int getX(){
        return  x;
    }

    public int getY(){
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
    public GameObject(int x, int y){
        this.x=x;
        this.y=y;
    }


}
