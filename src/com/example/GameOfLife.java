package com.example;

import java.util.Base64;
import java.util.Random;

/**
 * Created by Paweł Kobojek on 07.01.2016.
 */
public class GameOfLife {

    int[][] board;
    int rows, cols;
    private int livingCount;
    private CycleDetector<String> cycleDetector;
    private boolean hasLoop;
    private int afterBeingStable;

    public GameOfLife(int size) {
        this(size, 0.5f);
    }

    public GameOfLife(int size, float initialProbability) {
        this.board = new int[size][size];
        this.rows = size;
        this.cols = size;

        Random rand = new Random();
        cycleDetector = new CycleDetector<>();

        this.livingCount = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                float random = rand.nextFloat();
                this.board[i][j] = random < initialProbability ? 1 : 0;
                this.livingCount += this.board[i][j];
            }
        }
        afterBeingStable = 0;
    }

    private boolean lifeRule(boolean isAlive, int neighborsLiving) {
        if (!isAlive) {
            return neighborsLiving == 3;
        } else {
            return ((neighborsLiving == 3) || (neighborsLiving == 2));
        }
    }

    public void step() {
        int[][] oldBoard = board.clone();
        livingCount = 0;
        byte[] hashData = new byte[this.rows * this.cols];
        int k = 0;
        for (int x = 0; x < rows; ++x) {
            for (int y = 0; y < cols; ++y) {
                int neighborsLiving = -oldBoard[x][y];
                for (int i = -1; i < 2; ++i) {
                    for (int j = -1; j < 2; ++j) {
                        if ((x + i < rows) && (y + j < cols) && (x + i >= 0) && (y + j >= 0)) {
                            neighborsLiving += oldBoard[x + i][y + j];
                        }
                    }
                }
                board[x][y] = this.lifeRule(oldBoard[x][y] == 1, neighborsLiving) ? 1 : 0;
                livingCount += board[x][y];
                hashData[k++] = (byte) board[x][y];
            }
        }
        hasLoop = cycleDetector.addNext(Base64.getEncoder().encodeToString(hashData));
        if (hasLoop)
            afterBeingStable++;
    }

    public void prettyPrint(long iter) {
        System.out.printf("[%5d]\n", iter);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int symbol = board[i][j];
                System.out.print(symbol == 1 ? '\u2588' : ' ');
            }
            System.out.println();
        }
    }

    /**
     * Runs Game of Life until it has stagnated
     *
     * @return
     */
    public long run() {
        return run(-1);
    }

    /**
     * Performs maxSteps Game of Life iterations
     *
     * @param maxSteps Maximum number of state
     * @return Number of iteration before Game of Life has achieved stable state (or == maxState)
     */
    public long run(int maxSteps) {
        long i = 0;
        // prettyPrint();
//        prettyPrint(i);
        while (!isStable() && maxSteps-- != 0) {
            ++i;
            //System.out.printf("[%5d] Total living: %d\n", i, livingCount);
            //System.out.println("Mink: " + mink());
            // Following code is clearing the console
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
//            prettyPrint(i);
//            sleep(500);
            step();
        }
        return i;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Computes Minkowski dimension for the board - possible stagnation indicator
     *
     * @return Minkowski dimension value for current population
     */
    public double mink() {
        return Math.log(getLivingCount()) / (-(Math.log(1.0f / (cols * rows))));
    }

    public int getLivingCount() {
        return livingCount;
    }

    /**
     * Checks whether the game has achieved stable state
     * TODO - Figure out how to and implement this method
     *
     * @return true if Game of Life has stagnated, false otherwise
     */
    public boolean isStable() {
        return getLivingCount() == 0;
    }
}
