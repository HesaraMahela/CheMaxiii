import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

public class CanvasMouseAdapter extends MouseAdapter implements MouseMotionListener {
    private final CustomCanvas canvas;
    public CanvasMouseAdapter(CustomCanvas canvas) {
        this.canvas = canvas;
    }
    private Node hoveredNode;
    private Node prevDraggedNode;

    private Node selectedNode;

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (canvas.getNodeAt(x, y) != null){
            selectedNode = canvas.getNodeAt(x,y);
            canvas.repaint();
        }else {
            canvas.addNode(new Node(x, y, "c"));
            System.out.println("Mouse is clicked at position: (" + x + ", " + y + ")");
            super.mouseClicked(e);
        }
    }


    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //saySomething("dragged",e);
        if (canvas.getNodeAt(x, y) != null ){

            if(prevDraggedNode == null){
                prevDraggedNode = canvas.getNodeAt(x, y);

            }else {

                canvas.addLinker(new NodeLinker(prevDraggedNode,canvas.getNodeAt(x, y)));
            }

        }


    }

    void saySomething(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription
                + " (" + e.getX() + "," + e.getY() + ")"
                + " detected on "
                + e.getComponent().getClass().getName()
                + "\n");
    }



    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        System.out.println("entered");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        prevDraggedNode =null;
        System.out.println("Released");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }

    public Node getHoveredNode() {
        return hoveredNode;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        hoveredNode = canvas.getNodeAt(x, y); // Implement getNodeAt method in the Canvas class
        canvas.repaint(); // Repaint the canvas to update the circle position
    }

    public Node getSelectedNode() {
        return selectedNode;
    }
}
