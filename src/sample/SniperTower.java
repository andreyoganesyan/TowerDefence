package sample;

/**
 * Created by andre_000 on 14-Nov-16.
 */
public class SniperTower extends Tower{


    double range=100;
    double dp = 35;
    Mob target=null;
    GameFieldController gameFieldController;

    SniperTower(double x, double y, GameFieldController gameFieldController){
        super(x, y);
        this.gameFieldController=gameFieldController;
        this.getStyleClass().add("snipertower");
    }
    @Override
    public void progress(){
        if(target!=null){
            target.damage(dp);
            if (target.getHP()<=0){
                target=null;
            }
        }
        else {
            target=findNextTarget();
            if(target!=null){
                target.damage(dp);
                if (target.getHP()<=0){
                    target=null;
                }

            }
        }
    }

    Mob findNextTarget(){

        Mob nextTarget=null;
        for(Mob mob:gameFieldController.getMobs()){
            if (mob.getHP()>0&&getDistanceTo(mob)<=range&&(nextTarget==null||nextTarget.getX()<mob.getX())){
                nextTarget=mob;
            }
        }
        return nextTarget;
    }



}
