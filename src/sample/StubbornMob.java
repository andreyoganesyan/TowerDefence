package sample;

/**
 * Created by andre_000 on 22-Nov-16.
 */
public class StubbornMob extends Mob {
    public StubbornMob(double x, double y, GameFieldController gameFieldController){
        super(x,y,gameFieldController);

        getStyleClass().add("stubbornmob");
    }
    @Override
    public void progress(){
        x+=speed;
        setCenterX(x);
    }
}
