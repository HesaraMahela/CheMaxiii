import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {
//initializing of the item happens hear
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("CheMaxiii");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout borderLayout =new BorderLayout(10,10);
        frame.setLayout(borderLayout);
        //add mainMenu
        MainMenu mainMenu = new MainMenu();
        mainMenu.setMenu(frame);

        // Create the canvas
        CustomCanvas canvas = new CustomCanvas();
        canvas.setBounds(20,20,420,420);

        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        canvas.setLocation(200,200);

        frame.add(canvas, BorderLayout.CENTER);

        // add a label TEMP
        //JLabel label = new JLabel("Tool bar");
        Toolbar toolbar = new Toolbar();
        JLabel top_label = new JLabel("future something");
        frame.add(top_label,BorderLayout.NORTH);
        canvas.setToolbar(toolbar);
        frame.add(toolbar,BorderLayout.WEST);



        Node N1 =new Node(100,300,"c");
        Node N2 =new Node(300,300,"c");
        canvas.addNode(N1);
        canvas.addNode(N2);
        //NodeLinker L1 = new NodeLinker(N1,N2);
        //canvas.addLinker(L1);

        // Set the preferred size of the canvas
        canvas.setPreferredSize(new Dimension(300, 300));

        // Add key listener to the frame
        CanvasMouseAdapter mouseAdapter = new CanvasMouseAdapter(canvas); // both mouse and  key listener
        canvas.addMouseListener(mouseAdapter);
        canvas.addMouseMotionListener(mouseAdapter);
        frame.addKeyListener(new MainKeyListener(canvas));

        // Enable key events for the frame
        frame.setFocusable(true);
        frame.requestFocus();

        // Pack the frame and make it visible
        frame.setMinimumSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);
    }
}







