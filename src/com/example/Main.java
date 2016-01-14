package com.example;

public class Main {
    public static void main(String[] args) {
        int gameSize = 10;
        float initialLivingProbability = 0.5f;
        if (args.length > 0) {
            gameSize = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            initialLivingProbability = Float.parseFloat(args[1]);
        }
        long epochs = new GameOfLife(gameSize, initialLivingProbability).run();
        System.out.println("Population died after " + epochs + " epoch(s)");
    }
}
