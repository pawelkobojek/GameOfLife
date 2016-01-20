package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class ThreeByFour implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (neighborsLiving == 3 || neighborsLiving == 4);
    }
}
