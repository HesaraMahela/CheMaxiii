import java.awt.*;

public class NodeLinker {
    Node node1;
    Node node2;
    public String symbol;
    public Color color;
    public Font font;

    public int thickness;
    public int length;

    public NodeLinker(Node node1,Node node2){
        this.color=Color.black;
        this.node1 = node1;
        this.node2 =node2;
    }
    public NodeLinker(Node N,int len,int angel){
        this.node1 =N;

    }
    public void draw(Graphics2D g){
        g.setColor(this.color);
        g.drawLine(node1.x, node1.y, node2.x, node2.y);
    }

}
