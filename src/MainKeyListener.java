import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainKeyListener implements KeyListener {
    private CustomCanvas canvas;

    public MainKeyListener(CustomCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Add a new item at a random position

            // Set the updated items on the canvas
            int number = (int) (Math.random() * 256);
            String num = String.valueOf(number);
            canvas.addNode(100, 100, num);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
