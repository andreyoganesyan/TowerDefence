package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * Created by andre_000 on 14-Nov-16.
 */
public class SniperTower extends Tower{


    private static final double RANGE=100;
    private static final double DP = 35;
    private static final double HP = 100;
    private static final Color BG_COLOR = Color.GREEN;


    SniperTower(double x, double y, GameFieldController gameFieldController){
        super(x, y, HP, BG_COLOR,  gameFieldController);

        gameFieldController.getTowers().add(this);
        this.getStyleClass().add("snipertower");
        charge=50;
    }
    @Override
    public void progress(){
        charge= Math.min((charge+4), 100);
        if(target!=null){
            if(charge==100) {
                target.damage(DP);
                charge=0;
                if (target.getHP() <= 0) {
                    target = null;
                    gameFieldController.rageMeter+=0.05;
                }
            }
        }
        else {
            target=findNextTarget();
            if(target!=null){
                if(charge==100) {
                    charge=0;
                    target.damage(DP);
                    if (target.getHP() <= 0) {
                        target = null;
                        gameFieldController.rageMeter+=0.001;
                    }
                }

            }
        }
    }

    Mob findNextTarget(){

        Mob nextTarget=null;
        for(Mob mob:gameFieldController.getMobs()){
            if (mob.getHP()>0&&getDistanceTo(mob)<=RANGE&&(nextTarget==null||nextTarget.getX()<mob.getX())){
                nextTarget=mob;
            }
        }
        return nextTarget;
    }



}
