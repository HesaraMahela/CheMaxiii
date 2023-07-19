import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

import static java.awt.Color.*;

public class ToolBarButtons extends JButton {



    public ToolBarButtons(String string){
        super(string);
        this.setMaximumSize(new Dimension(20,20));
        this.setMinimumSize(new Dimension(90,90));
        this.setBorder(new BasicBorders.ButtonBorder(cyan,black,white,yellow));

        // TODO: button size has to be fixed
    }

}
