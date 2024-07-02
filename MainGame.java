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
        JLabel name  = new JLabel("Conway's Game of Life");
        BorderLayout b = new BorderLayout();
        setLayout(b);
        GridPanel grid = new GridPanel(20, 10);
        //ControlPanel controls = new ControlPanel();
        add(name, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);
        //add(grid, BorderLayout.SOUTH);1
    }

}
