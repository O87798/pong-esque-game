import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {

	static boolean isDead = false;

	//all things we want to render/update
	//essentially all game objects go here
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Death death = new Death(this);

	public void racquetInit() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
	}

	public void initColl() {
		ball.initCollision();
		racquet.initCollision();
		death.initCollision();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		//put render thingies here
		ball.paint(g2d);
		racquet.paint(g2d);
	}

	public void move() {
		//put general physics/move methods here
		ball.move();
		racquet.move();
		death.update();
	}

	public void onDeath() {
		if (!isDead) {
			Main.onDeath();
			isDead = true;
		}
	}
}