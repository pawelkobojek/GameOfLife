package com.example;

import com.example.rules.Conway;
import com.example.rules.LifeRule;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        int gameSize = 10;
        int runsPerProb = 100;
        int maxSteps = 100;
        float prob = 0.5f;
        boolean verbose = false;
        LifeRule lifeRule = new Conway();
        if (args.length > 0) {
            gameSize = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            runsPerProb = Integer.parseInt(args[1]);
        }
        if (args.length > 2) {
            maxSteps = Integer.parseInt(args[2]);
        }
        if (args.length > 3) {
            lifeRule = getRuleByName(args[3]);
        }
        if (args.length > 4) {
            verbose = true;
        }
        if (args.length > 5) {
            prob = Float.parseFloat(args[5]);
        }
        if (!verbose) {
            for (float f = 0.01f; f <= 1.0f; f += 0.01f) {
                for (int i = 0; i < runsPerProb; ++i) {
                    long epochs = new GameOfLife(gameSize, f, lifeRule).run(maxSteps, verbose);
                    System.out.println(String.format("%d;%.2f;%d;%d", gameSize, f, epochs, maxSteps));
                }
            }
        } else {
            new GameOfLife(gameSize, prob, lifeRule).run(maxSteps, verbose);
        }
    }

    public static LifeRule getRuleByName(String ruleName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (LifeRule) Class.forName("com.example.rules." + ruleName).getConstructor().newInstance();
    }
}
