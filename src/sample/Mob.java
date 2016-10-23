package sample;

/**
 * Created by andre_000 on 17-Oct-16.
 */
public class Mob extends GameObject {

    public Mob(int x, int y){
        super(x,y);
    }

    void findNextTarget(){

    }

    @Override
    void targetDestroyed() {
        findNextTarget();
    }
}
