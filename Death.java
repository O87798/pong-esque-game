import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Death {

	public GamePanel panel;
	public Rectangle coll;
	public Ball ball;

	public Death(GamePanel panel) {
		this.panel = panel;
		ball = panel.ball;
	}

	public void update() {
		if (coll.intersects(ball.coll)) {
			panel.onDeath();
		}
	}

	public void initCollision() {
		coll = new Rectangle(0,panel.getHeight()-1,panel.getWidth(),1);
	}
}