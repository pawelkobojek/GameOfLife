package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Maze implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (isAlive && neighborsLiving < 6) || (!isAlive && neighborsLiving == 3);
    }
}
