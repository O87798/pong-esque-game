import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

	static JFrame frame;
	static GamePanel panel;

	public static void main(String[] args) throws InterruptedException {
		frame = new JFrame("idk what this is");
		frame.setSize(300,300);

		panel = new GamePanel();

		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

		//put one time operations here (before game loop starts)
		panel.racquetInit();
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.initColl();

		//game loop
		while (true) {
			panel.move();
			panel.repaint();
			Thread.sleep(10);
		}
	}

	public static void onDeath() {
		JLabel deathMSG = new JLabel("You Died :(",JLabel.CENTER);
		deathMSG.setFont(new Font(deathMSG.getFont().getName(), Font.PLAIN, 50));
		panel.add(deathMSG);
		frame.add(panel);
		frame.setVisible(true);
	}
}