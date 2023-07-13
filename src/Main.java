import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Che Maxii");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //add mainMenu
        MainMenu mainMenu = new MainMenu();
        mainMenu.setMenu(frame);

        // Create the canvas
        CustomCanvas canvas = new CustomCanvas();
        canvas.setBounds(20,20,420,420);

        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        canvas.setLocation(200,200);

        frame.add(canvas, BorderLayout.CENTER);


        Node N1 =new Node(100,300,"c");
        Node N2 =new Node(300,300,"c");
        canvas.addNode(N1);
        canvas.addNode(N2);
        NodeLinker L1 = new NodeLinker(N1,N2);
        canvas.addLinker(L1);

        // Set the preferred size of the canvas
        canvas.setPreferredSize(new Dimension(300, 300));

        // Add key listener to the frame
        canvas.addMouseListener(new MouseAdapter() { // TODO:make a different class to handle all key and mouse events
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                canvas.addNode(new Node(x,y,"C"));
                System.out.println("Mouse clicked at position: (" + x + ", " + y + ")");
            }
        });
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Check if the Space key is pressed
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // Add a new item at a random position

                    // Set the updated items on the canvas
                   int number =(int) (Math.random() * 256);
                   String num= String.valueOf(number);
                   canvas.addNode(100,100,num);

                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not used
            }
        });

        // Enable key events for the frame
        frame.setFocusable(true);
        frame.requestFocus();

        // Pack the frame and make it visible
        frame.setMinimumSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);
    }
}







