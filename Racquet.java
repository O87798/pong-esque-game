import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Racquet {

	static int x = 50;
	static int xa = 0;
	static int y = 230;
	static int width = 60;
	static int height = 10;
	public static GamePanel panel;
	public static Rectangle coll;

	public Racquet(GamePanel panel) {
		this.panel = panel;
	}

	public void initCollision() {
		coll = new Rectangle(x,y,width,height);
	}

	public static void move() {
		if (x + xa > 0 && x + xa < panel.getWidth() - 60) {
			x = x + xa;
		}

		coll.setBounds(x,y,width,height);

	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
		}
	}

	public static void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}