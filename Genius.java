import javax.management.RuntimeMBeanException;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class Genius {
    private static GridPanel gridPanel;

    public Genius(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public static void calculateNextGeneration() {
        int rows = gridPanel.getRows();
        int columns = gridPanel.getColumns();
        boolean[][] currentBoard = gridPanel.getGrid();
        boolean[][] nextBoard = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int liveNeighbors = countLiveNeighbors(currentBoard, row, column);
                // Apply Conway's rules
                if (currentBoard[row][column]) { // Cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextBoard[row][column] = false; // Cell dies
                    } else {
                        nextBoard[row][column] = true; // Cell lives
                    }
                } else { // Cell is dead
                    if (liveNeighbors == 3) {
                        nextBoard[row][column] = true; // Cell becomes alive
                    }
                }
            }
        }
        gridPanel.setGrid(nextBoard);
    }

    private static int countLiveNeighbors(boolean[][] board, int row, int col) {
        int liveNeighbors = 0;
        int rows = board.length;
        int columns = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue; // Skip the cell itself
                }

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    if (board[newRow][newCol]) {
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }
}