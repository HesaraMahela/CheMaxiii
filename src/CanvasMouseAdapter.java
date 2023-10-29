import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasMouseAdapter extends MouseAdapter implements MouseMotionListener, KeyListener {
    private final CustomCanvas canvas;

    public CanvasMouseAdapter(CustomCanvas canvas) {
        this.canvas = canvas;
    }

    private Node hoveredNode;
    private Node prevDraggedNode;

    private Node selectedNode;

    private boolean textToolSelected = false;
    private JTextField tempTextField;


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO: get the selected button and then perform the actions regarding to the selected button
        int x = e.getX();
        int y = e.getY();
        if (canvas.getNodeAt(x, y) != null) {
            selectedNode = canvas.getNodeAt(x, y);
            canvas.repaint();

        } else if (canvas.getSelectedButton() != null) {

            String selectedButtonText = canvas.getSelectedButton().getText();
            if (selectedButtonText.equals("Text Tool") && tempTextField == null) {
                // todo : select tool is not working
                tempTextField = new JTextField();
                tempTextField.setBounds(x, y, 100, 25);
                tempTextField.addKeyListener(this);
                canvas.add(tempTextField);
                tempTextField.requestFocus();
                textToolSelected = true;
            }
        }
    }


    public void mouseDragged(MouseEvent e) {
        //TODO: when dragging it is better to see it temporally
        int x = e.getX();
        int y = e.getY();

        if (canvas.getSelectedButton() != null) {
            String selectedButtonText = canvas.getSelectedButton().getText();
            if (selectedButtonText.equals("----")) {
                drawLinker(x, y);
                temporaryDraw(x,y);
            } else if (selectedButtonText.equals("rectangle")) {
                // TODO: overload the drawLinker method to plot different linkers for that linker class has to be modified
            }
        }else {

        }


    }

    private void temporaryDraw(int x, int y){
        // drawing the linker
        if (canvas.getNodeAt(x, y) == null ){

            if(prevDraggedNode != null) { // if first node was not selected
//                System.out.println("drawing the linker");
                NodeLinker tempLinker = new NodeLinker(prevDraggedNode, new Node(x, y, ""));
                canvas.setTempLinker(tempLinker);
                canvas.repaint();
            }
            // TODO : removing the temporary linker has to be fixed when drag stops
        }
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
        canvas.unsetTempLinker();

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (textToolSelected && e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = tempTextField.getText();
            canvas.addNode(new Node(tempTextField.getX(), tempTextField.getY(), text));
            canvas.remove(tempTextField);
            tempTextField = null;
            textToolSelected = false; // TODO: is this useless??
            canvas.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void drawLinker(int x, int y){
        if (canvas.getNodeAt(x, y) != null ){

            if(prevDraggedNode == null){ // if first node was not selected
                prevDraggedNode = canvas.getNodeAt(x, y);

            }else {
                // addLinker checks is the link between same node
                // get linker and check is the linker is added previously then add
                if(canvas.getLinkerBetween(prevDraggedNode,canvas.getNodeAt(x, y)) ==null){
                    canvas.addLinker(new NodeLinker(prevDraggedNode,canvas.getNodeAt(x, y)));
                }

            }

        }
    }

}
