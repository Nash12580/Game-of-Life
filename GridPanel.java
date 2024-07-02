import javax.management.RuntimeMBeanException;
import javax.swing.*;
import java.awt.*;
public class GridPanel extends JPanel{
    private boolean[][] grid;
    private int rows;
    private int columns;

    public GridPanel(int rows, int columns){
        setBackground(new Color(78,114,142));
        this.rows = rows;
        this.columns = columns;
        grid = new boolean[rows][columns];
    }

    public Boolean getCellVal(int row, int column){
        return grid[row][column];
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public boolean[][] getGrid(){
        return grid;
    }

    public void toggleCell(int row, int column){
        if(row < 0 || column < 0) {
            throw new RuntimeException("Cell is out of bound");
        }else if(row >= rows || column >= columns){
            throw new RuntimeException("index out of range");
        }else grid[row][column] = !grid[row][column];
    }

    public void erase(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                grid[i][j] = false;
            }
        }
    }


}
