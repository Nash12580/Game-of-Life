import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nanny implements ActionListener {

    GridPanel grid = new GridPanel();

    private GridPanel gridPanel;


    public Nanny(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Clear":
                gridPanel.erase();
                gridPanel.repaint();
                break;
            case "Start":
                // Start logic (could involve starting a timer for continuous generation updates)
                break;
            case "Stop":
                // Stop logic (could involve stopping a timer for continuous generation updates)
                break;
            case "Next":
                gridPanel.calculateNextGeneration();
                gridPanel.repaint();
                break;
            case "Lexicon":
                // Lexicon logic
                break;
            case "Explanation":
                // Explanation logic
                break;
            default:
                if (e.getSource() instanceof Cell) {
                    Cell cell = (Cell) e.getSource();
                    gridPanel.toggleCell(cell.getRow(), cell.getColumn());
                    gridPanel.repaint();
                }
                break;
        }
    }
}

