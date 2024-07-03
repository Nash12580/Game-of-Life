import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Nanny implements ActionListener {

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
            case "Next":
                gridPanel.calculateNextGeneration();
                gridPanel.repaint();
                break;
            default:
                break;
        }
    }
}
