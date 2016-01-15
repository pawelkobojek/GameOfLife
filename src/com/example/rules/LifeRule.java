package com.example.rules;

/**
 * Created by pawelkobojek on 15.01.2016.
 */
public interface LifeRule {
    boolean shouldLive(boolean isAlive, int neighborsLiving);
}
