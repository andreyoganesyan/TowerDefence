package sample;

import javafx.scene.paint.Color;

/**
 * Created by andre_000 on 21-Nov-16.
 */
public class SiegeTower extends Tower{


    private static final double RANGE=50;
    private static final double DP = 20;
    private static final double HP = 100;
    private static final Color BG_COLOR = Color.RED;
    private static final double MAX_CHARGE = 50;



    SiegeTower(double x, double y, GameFieldController gameFieldController){
        super(x, y, HP, BG_COLOR,  gameFieldController);
        charge=50;

    }
    @Override
    public void progress(){
        charge= Math.min((charge+4), MAX_CHARGE);
        dropShadow.setRadius(10*charge/MAX_CHARGE);
        if(target!=null){
            if(charge==MAX_CHARGE) {
                target.damage(DP);
                charge=0;
                if (target.getHP() <= 0) {
                    target = null;
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
