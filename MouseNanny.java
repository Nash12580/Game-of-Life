import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseNanny implements MouseListener {
    private final GridPanel gridPanel;
    private int row;
    private int col;
    public MouseNanny(GridPanel gridPanel){
        this.gridPanel = gridPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int size = gridPanel.getCellSize();
        row = e.getX()/ size;
        col = e.getY()/ size;
        System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
        System.out.println("Calculated cell: (" + row + ", " + col + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gridPanel.toggleCell(row, col);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
