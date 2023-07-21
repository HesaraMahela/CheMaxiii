import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Toolbar extends JPanel implements ActionListener {
    ArrayList<ToolBarButton> barButtons = new ArrayList<ToolBarButton>();

    private ToolBarButton selectedButton;
    public Toolbar() {
        super(new GridLayout(10,2,5,9));
        addButtons();
    }

    private void addButtons(){
        // TODO : this buttons should be a class with minimum with
        ToolBarButton B1 = new ToolBarButton("Text Tool", this);
        ToolBarButton B2 = new ToolBarButton("rectangle", this);
        ToolBarButton B3 = new ToolBarButton("----", this);

        barButtons.add(B1);
        barButtons.add(B2);
        barButtons.add(B3);
        displayButtons();

    }

    private void displayButtons(){
        for (ToolBarButton button: barButtons) {
            this.add(button);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (ToolBarButton button: barButtons) {
            if (e.getSource() == button){
                selectedButton =button;
                selectedButton.setBackground(Color.red);
                // this selectedButton will be asked by the mouse adapter and perform the relevant task
            }else {
                button.setBackground(Color.white);
                // TODO: fix this to make the colour normal
            }

        }
    }



    public ToolBarButton getSelectedButton(){
        return selectedButton;
    }
}
