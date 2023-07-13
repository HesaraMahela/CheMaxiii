import java.awt.*;

public class Node {
    public int x;
    public int y;
    public String symbol;
    public Color color;
    public Font font;

    public Node(int x, int y, String symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = Color.black;
        this.font = new Font("TimesRoman", Font.PLAIN, 32);

    }
    public void draw(Graphics2D g){
        g.setColor(this.color);
        g.setFont(this.font);
        g.drawString(this.symbol,this.x,this.y);
    }
}
