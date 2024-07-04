import javax.swing.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
/*@author Nashali Vicente
* @author Veer Bhagia*/
public class GridPanel extends JPanel {
    private boolean[][] grid;
    private final int rows;
    private final int columns;
    private int size;

    public GridPanel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new boolean[rows][columns];
        size = 20;
        setBackground(new Color(78, 114, 142));
        setPreferredSize(new Dimension(columns * size, rows * size));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        size = Math.max(panelWidth / columns, panelHeight / rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]) {
                    g.setColor(Color.YELLOW);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * size, i * size, size, size);
                g.setColor(Color.GRAY);
                g.drawRect(j * size, i * size, size, size);
            }
        }
    }

    public void randomizeGrid() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }
        repaint();
    }

    public Boolean getCellVal(int row, int column) {
        return grid[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean[][] getGrid() {
        return grid;
    }


    public int getCellSize(){
        return size;
    }


    public void setGrid(boolean[][] newGrid) {
        this.grid = newGrid;
        repaint();
    }

    public void toggleCell(int row, int col) {
        if (row >= 0 && col >= 0 && row < rows && col < columns) {
            grid[row][col] = !grid[row][col];
            repaint();
        } else {
            throw new RuntimeException("Cell is out of bounds");
        }
    }

    public int countLiveNeighbors(int row, int col) {
        int neighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < columns && grid[r][c]) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    public void calculateNextGeneration() {
        boolean[][] nextBoard = new boolean[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int liveNeighbors = countLiveNeighbors(row, col);
                // Apply Conway's rules
                if (grid[row][col]) { // Cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextBoard[row][col] = false; // Cell dies
                    } else {
                        nextBoard[row][col] = true; // Cell lives
                    }
                } else { // Cell is dead
                    if (liveNeighbors == 3) {
                        nextBoard[row][col] = true; // Cell becomes alive
                    }
                }
            }
        }
        setGrid(nextBoard);
    }

    public void erase() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = false;
            }
        }
        repaint();
    }
}

