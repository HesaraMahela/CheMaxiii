import javax.swing.*;
import java.awt.*;

public class MainMenu {
    JMenu menu, submenu;
    JMenuItem i1, i2, i3, i4, i5;

    JMenuBar mb=new JMenuBar();

    public void setMenu(JFrame frame) {
        menu = new JMenu("Menu");
        submenu = new JMenu("Sub Menu");
        i1 = new JMenuItem("Item 1");
        i2 = new JMenuItem("Item 2");
        i3 = new JMenuItem("Item 3");
        i4 = new JMenuItem("Item 4");
        i5 = new JMenuItem("Item 5");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        submenu.add(i4);
        submenu.add(i5);
        menu.add(submenu);
        mb.add(menu);
        frame.setJMenuBar(mb);
    }
}
