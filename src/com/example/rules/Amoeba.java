package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Amoeba implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (isAlive && (neighborsLiving == 1 || neighborsLiving == 3 || neighborsLiving == 5 || neighborsLiving == 8)) ||
                (!isAlive && (neighborsLiving % 2 == 1 && neighborsLiving > 2));
    }
}
