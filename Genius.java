import javax.management.RuntimeMBeanException;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

/*@author Veer Bhagia*/
public class Genius {
    private static GridPanel gridPanel;

    public Genius(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    public void calculateNextGeneration() {
        gridPanel.calculateNextGeneration();
    }
}
