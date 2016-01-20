package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Stain implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (!isAlive && neighborsLiving != 1 && neighborsLiving != 4) ||
                (isAlive && (neighborsLiving == 3 || neighborsLiving > 5));
    }
}
