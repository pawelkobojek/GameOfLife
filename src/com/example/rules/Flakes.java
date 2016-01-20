package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Flakes implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return (isAlive) || (!isAlive && neighborsLiving == 1);
    }
}
