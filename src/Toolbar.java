import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {


    private ToolBarButtons selectedButton;
    public Toolbar() {
        super(new GridLayout(10,2,5,9));
        addButtons();
    }

    private void addButtons(){
        // TODO : this buttons should be a class with minimum with
        ToolBarButtons B1 = new ToolBarButtons("1");
        ToolBarButtons B2 = new ToolBarButtons("2");
        ToolBarButtons B3 = new ToolBarButtons("3");
        this.add(B1);
        this.add(B2);
        this.add(B3);

    }


}
