package com.example.rules;

/**
 * Created by trolley on 20.01.16.
 */
public class Gnarl implements LifeRule {
    @Override
    public boolean shouldLive(boolean isAlive, int neighborsLiving) {
        return neighborsLiving == 1;
    }
}
