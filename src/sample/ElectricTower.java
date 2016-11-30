package sample;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by andre_000 on 21-Nov-16.
 */
public class ElectricTower extends Tower{
    ArrayList<ElectricTower> connectedTowers = new ArrayList<ElectricTower>();
    private static final double RANGE=70;
    private static final double DP = 35;
    private static final double HP = 100;
    private static final double MAX_CHARGE=300;
    double charge = 50;
    private static final Color BG_COLOR = Color.AQUA;

    @Override
    void progress() {
        charge= Math.min((charge+3), MAX_CHARGE);
        dropShadow.setRadius(10*charge/MAX_CHARGE);

    }
    public ElectricTower(double x, double y, GameFieldController gameFieldController){
        super(x, y, HP, BG_COLOR,  gameFieldController);

        this.getStyleClass().add("electrictower");

    }
    @Override
    public void damage(double dp){
        hp-=dp;
        attackedTransition.play();
        for(Mob mob:gameFieldController.mobs){
            if (getDistanceTo(mob)<=RANGE){
                mob.damage(dp*(1-getDistanceTo(mob)/RANGE));
                charge=Math.max(0,charge-dp);
                gameFieldController.rageMeter-=0.001;
            }
        }

        if (hp<0){
            for(Mob mob:gameFieldController.mobs){
                if (getDistanceTo(mob)<=RANGE){
                    mob.damage((50+charge)*(1-getDistanceTo(mob)/RANGE));
                }
            }
            gameFieldController.remove(this);
        }
    }
}
