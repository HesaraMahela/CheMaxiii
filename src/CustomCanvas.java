import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class CustomCanvas extends JPanel{
// TODO: fix the center of positioning 

    private ArrayList<Node> nodes = new ArrayList<Node>();
    private ArrayList<NodeLinker> Linkers = new ArrayList<NodeLinker>();

    public Toolbar toolbar;

    private NodeLinker tempLinker;


    public Node getNodeAt(int x, int y) {

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
    public NodeLinker getLinkerBetween(Node prev, Node  next) {
            NodeLinker temp = new NodeLinker(prev,next);
        for (NodeLinker linker : Linkers) {
            if (temp.node1==linker.node1 && temp.node2==linker.node2 ) {
                return linker;
            }else if (temp.node1==linker.node2 && temp.node2==linker.node1 ) {
                return linker;
            }
        }
        return null;
    }

    public void addNode(int x, int y , String name){
        nodes.add(new Node(x,y, name));
        System.out.println("node was added");
        repaint();
    }

    public void addNode(Node N){
        nodes.add(N);
        repaint();
    }

    public void addLinker(NodeLinker L){
        if(L.node1 != L.node2){
            Linkers.add(L);
            repaint();
        }

        //System.out.println("nodeLinker was added");
        System.out.println(Linkers.size());

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

        if(tempLinker!=null){
            tempLinker.draw(g2D);
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

    public void removeTempNodeLinker(){
        // Calculate index of last element
        int index = Linkers.size() - 1;

        // Delete last element by passing index
        Linkers.remove(index);
    }

    public void setTempLinker(NodeLinker temp){
        this.tempLinker =  temp;

    }

    public void unsetTempLinker() {
        tempLinker =null;
        repaint();
    }

    public ArrayList<Node> getNodes(){
        // pass data to formula
        return nodes;
    }

    public ArrayList<NodeLinker> getLinks(){
        // pass data to formula
        return Linkers;
    }

}