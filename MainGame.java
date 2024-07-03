import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame{
    public static void main(String[] args) {
        MainGame app = new MainGame();
        app.setSize(900,900);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public MainGame(){

        JLabel name = new JLabel("Conway's Game of Life");
        name.setFont(new Font("Arial", Font.BOLD, 36));
        setLayout(new BorderLayout());
        GridPanel grid = new GridPanel(24, 35);
        ControlPanel controls = new ControlPanel(grid);
        add(name, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);

        grid.randomizeGrid();
        grid.addMouseListener(new MouseNanny(grid));
    }

}
