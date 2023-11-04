import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private CustomCanvas canvas;
    JMenu menu, submenu;
    JMenuItem i1, i2, i3, i4, i5;

    JMenuBar mb=new JMenuBar();

    public void setMenu(JFrame frame) {
        menu = new JMenu("Menu");
        submenu = new JMenu("Sub Menu");
        JMenuItem getFormula = new JMenuItem(" get formula");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        i5 = new JMenuItem("Item 5");

        getFormula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String formula = new formula().getFormula(canvas);
                JOptionPane.showMessageDialog(frame, "the formula is : "+ formula);
            }
        });


        menu.add(getFormula);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);
        frame.setJMenuBar(mb);
    }

    MainMenu(CustomCanvas canvas){
        this.canvas = canvas;
    }
}
