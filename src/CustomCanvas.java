import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class CustomCanvas extends JPanel{
// TODO: fix the center of positioning 

    public ArrayList<Node> nodes = new ArrayList<Node>();
    public ArrayList<NodeLinker> Linkers = new ArrayList<NodeLinker>();

    public Toolbar toolbar;

    public Node getNodeAt(int x, int y) {
        //System.out.println("JJJJJJJ");
        for (Node node : nodes) {
            int nodeX = node.getX();
            int nodeY = node.getY();
            int distanceSquared = (x - nodeX) * (x - nodeX) + (y - nodeY) * (y - nodeY);
            if (distanceSquared <= node.getRadius() * node.getRadius()) {
                return node;
            }
        }
        return null;
    }

    public void addNode(int x, int y , String name){
        nodes.add(new Node(x,y, name));
        repaint();
    }

    public void addNode(Node N){
        nodes.add(N);
        repaint();
    }

    public void addLinker(NodeLinker L){
        Linkers.add(L);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the canvas
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, getWidth(), getHeight());


        if (nodes != null){
            for (Node node : nodes) {
                node.draw(g2D);
            }
        }
        if (Linkers != null){
            for (NodeLinker L : Linkers) {
                L.draw(g2D);
            }
        }

        // Draw circle around the hovered node
        CanvasMouseAdapter mouseListener = (CanvasMouseAdapter) getMouseListeners()[0];
        Node hoveredNode = mouseListener.getHoveredNode();
        Node selectedNode = mouseListener.getSelectedNode();
        if (hoveredNode != null) {
            int x = hoveredNode.getX();
            int y = hoveredNode.getY();
            int radius = hoveredNode.getRadius();

            g.setColor(Color.BLUE);
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);


        }

        if (selectedNode != null){
            int x = selectedNode.getX();
            int y = selectedNode.getY();
            int radius = selectedNode.getRadius();
            g.setColor(Color.GREEN);
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        }

    }


    public void addTextNode(int x, int y) {
        final JTextField[] textField = {new JTextField()};
        textField[0].setBounds(x, y, 100, 25);
        textField[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField[0].getText();
                addNode(new Node(textField[0].getX(), textField[0].getY(), text));
                remove(textField[0]);
                textField[0] = null;
                repaint();
            }
        });
        add(textField[0]);
        textField[0].requestFocus();
    }

    public ToolBarButton getSelectedButton() {
        return toolbar.getSelectedButton();
    }
    public void setToolbar(Toolbar toolbar){
        this.toolbar =toolbar;
    }
}