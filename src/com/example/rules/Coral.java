package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Coral implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (!isAlive && neighborsLiving > 3) || (isAlive && neighborsLiving == 3);
    }
}
