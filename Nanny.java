import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nanny implements ActionListener {
    Grid grid = new Grid();

    public void Nanny (Grid g) {
        grid = g;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")){
            grid.reset();
            grid.repaint();
        } else if (e.getActionCommand().equals("Start")){
            grid.setStart(1);
        } else if (e.getActionCommand().equals("Stop")) {
            grid.setStart(0);
        } else if (e.getActionCommand().equals("Next")) {
            Genius.calculateNextGeneration(grid.get());
            grid.repaint();
        } else if (e.getActionCommand().equals("Lexicon")){

        } else if (e.getActionCommand().equals("Explanation")){

        } else if (e.getSource() instanceof Cell){
            grid.toggleCell();
        }
    }
}
