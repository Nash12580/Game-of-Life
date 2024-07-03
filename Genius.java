import javax.management.RuntimeMBeanException;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class Genius {
    private GridPanel gridPanel;

    public Genius(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public void calculateNextGeneration() {
        gridPanel.calculateNextGeneration();
    }
}
