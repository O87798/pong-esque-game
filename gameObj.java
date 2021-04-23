import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class gameObj {

	public int x = 0;
	public int xa;
	public int y = 0;
	public int ya;
	public int width = 30;
	public int height = 30;
	public GamePanel panel;
	public Rectangle coll;

	public gameObj(GamePanel panel) {
		this.panel = panel;
	}

	public void move() {
		coll.setBounds(x,y,width,height);
		x = x + xa;
		y = y + ya;
	}

	public void paint(Graphics g) {

	}

	public void initCollision() {
		coll = new Rectangle(x,y,width,height);
	}
}