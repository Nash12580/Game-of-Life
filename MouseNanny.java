import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseNanny extends MouseAdapter {
    private final GridPanel gridPanel;
    public MouseNanny(GridPanel gridPanel){
        this.gridPanel = gridPanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int size = gridPanel.getCellSize();
        int col = e.getX() /size;
        int row = e.getY() / size;
        gridPanel.toggleCell(row, col);
    }


}
