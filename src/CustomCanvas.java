import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class CustomCanvas extends JPanel{


    private ArrayList<Node> nodes = new ArrayList<Node>();
    private ArrayList<NodeLinker> Linkers = new ArrayList<NodeLinker>();

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
    }

}