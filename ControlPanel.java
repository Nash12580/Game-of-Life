import javax.swing.*;
import java.awt.*;


public class ControlPanel extends JPanel {
    public ControlPanel(GridPanel grid) {
        setBackground(Color.BLUE);
        JButton clear = new JButton("Clear");
        JButton next = new JButton("Next");
        add(clear);
        add(next);
        Nanny n1 = new Nanny(grid);
        clear.addActionListener(n1);
        next.addActionListener(n1);
    }
}
