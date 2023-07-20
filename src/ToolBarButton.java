import javax.swing.*;
import java.awt.*;

public class ToolBarButton extends JButton {
    public final Toolbar Toolbar;


    public ToolBarButton(String string, Toolbar toolbar){
        super(string);
        Toolbar = toolbar;
        this.setMaximumSize(new Dimension(20,20));
        this.setMinimumSize(new Dimension(90,90));
       // this.setBorder(new BasicBorders.ButtonBorder(cyan,black,white,yellow));
        this.addActionListener(Toolbar);


        // TODO: button size has to be fixed
    }

}
