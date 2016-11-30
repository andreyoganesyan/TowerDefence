package sample;

import javafx.scene.paint.Color;

/**
 * Created by andre_000 on 22-Nov-16.
 */
public class StubbornMob extends Mob {
    public StubbornMob(double x, double y, GameFieldController gameFieldController){
        super(x,y,gameFieldController);

        getStyleClass().add("stubbornmob");
        setStroke(Color.YELLOW);
        setStrokeWidth(2);
    }
    @Override
    public void progress(){
        x+=speed;
        setCenterX(x);
        if (x>1000){
            gameFieldController.attackCastle();
            gameFieldController.toBeRemoved.add(this);
        }
    }
}
