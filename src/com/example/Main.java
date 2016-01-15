package com.example;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int gameSize = 10;
        int runsPerProb = 100;
        int maxSteps = 100;
        if (args.length > 0) {
            gameSize = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            runsPerProb = Integer.parseInt(args[1]);
        }
        if (args.length > 2) {
            maxSteps = Integer.parseInt(args[2]);
        }
        for (float f = 0.01f; f <= 1.0f; f += 0.01f) {
            for (int i = 0; i < runsPerProb; ++i) {
                long epochs = new GameOfLife(gameSize, f).run(maxSteps);
                System.out.println(String.format("%d;%.2f;%d;%d", gameSize, f, epochs, maxSteps));
            }
        }
    }
}
