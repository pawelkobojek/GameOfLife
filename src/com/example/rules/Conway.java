package com.example.rules;

/**
 * Created by pawelkobojek on 15.01.2016.
 */
public class Conway implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        if (!isAlive) {
            return neighborsLiving == 3;
        } else {
            return ((neighborsLiving == 3) || (neighborsLiving == 2));
        }
    }
}
