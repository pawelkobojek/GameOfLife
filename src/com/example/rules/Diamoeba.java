package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Diamoeba implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (!isAlive && neighborsLiving > 4) || (isAlive && (neighborsLiving > 4 || neighborsLiving == 3));
    }
}
