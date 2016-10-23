package sample;

import java.util.ArrayList;

/**
 * Created by andre_000 on 23-Oct-16.
 */
public class GameField {
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    ArrayList<Mob> mobs = new ArrayList<Mob>();
    Obstacle[][] obstacleGrid;

    public GameField(int numRows, int numColumns, double width, double height){
        obstacleGrid = new Obstacle[numColumns][numRows];

    }
}
