import java.awt.*;

public class NodeLinker {
    Node node1;
    Node node2;
    public String bondType;
    public Color color;
    public Font font;

    public int thickness;
    public int length;

    public NodeLinker(Node node1,Node node2){
        this.color=Color.black;
        this.node1 = node1;
        this.node2 =node2;
        this.bondType ="----";

    }
    public NodeLinker(Node node1,Node node2, String bondType){
        this.color=Color.black;
        this.node1 = node1;
        this.node2 =node2;
        this.bondType =bondType;
    }

    public NodeLinker(Node N,int len,int angel){
        this.node1 =N;

    }
    public void draw(Graphics2D g){
        g.setColor(this.color);
        if(this.bondType.equals("----")){
            g.drawLine(node1.x + 12, node1.y-5, node2.x - 5, node2.y-5);

        }else if (this.bondType.equals("triangle")){
            int[] x = new int[]{node1.x + 12, node2.x -12,node2.x -12 };
            int[] y = new int[]{node1.y + 12, node2.y +12,node2.y -12 };
            System.out.println(node1.x );
            g.drawPolygon(x, y, 3);
        }

    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public boolean isIncluded(Node node){
        return this.node1 == node || this.node2 ==node;
    }

    public Node otherNode(Node node){
        if(this.node2 == node) {
            return node1;
        }else if(this.node1 == node) {
            return node2;
        }
        return null;
    }
}
