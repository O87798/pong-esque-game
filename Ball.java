import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ball {

	static int x = 0;
	static int y = 0;
	static int xa = 1;
	static int ya = 1;
	static int ballHeight = 30;
	static int ballWidth = 30;
	public static GamePanel panel;
	public static Racquet racquet;
	public static Rectangle coll;

	public Ball(GamePanel panel) {
		this.panel = panel;
		racquet = panel.racquet;
	}

	public void initCollision() {
		coll = new Rectangle(x,y,ballWidth,ballHeight);
	}

	public static void move() {

		if (x + xa < 0)
			xa = 1;
		if (x + xa > panel.getWidth() - ballWidth)
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > panel.getHeight() - ballHeight) {
			ya = 0;
			xa = 0;
		}

		x = x + xa;
		y = y + ya;

		coll.setBounds(x,y+ballHeight,ballWidth,1);

		if (coll.intersects(racquet.coll)) {
			ya = -1;
		}
	}

	public static void paint(Graphics g) {
		g.fillOval(x,y,ballHeight,ballWidth);
	}
}