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
    public void draw(Graphics g){
        g.setColor(this.color);
        g.setFont(this.font);
        //Dimension corr = CenteredCoordinates(g,this.x,this.y);
        g.drawString(this.symbol,this.x,this.y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return 30;
    }
//    private Dimension getStringWidthHeight(Graphics g){
//        int width = g.getFontMetrics().stringWidth(this.symbol);
//        int height = g.getFontMetrics().getHeight();
//        return new Dimension(width,height);
//    }
//    public Dimension CenteredCoordinates(Graphics g, int x,int y){
//        Dimension d =  getStringWidthHeight(g);
//        System.out.println(d);
//        return  new Dimension(x-5,y+10);
//    }
}
