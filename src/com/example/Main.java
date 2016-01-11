package com.example;

public class Main {
    public static void main(String[] args) {
        int gameSize = 10;
        if (args.length > 0) {
            gameSize = Integer.parseInt(args[0]);
        }
        long epochs = new GameOfLife(gameSize).run();
        System.out.println("Population died after " + epochs + " epoch(s)");
    }
}
