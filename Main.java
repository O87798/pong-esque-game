import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("idk what this is");
		frame.setSize(300,300);

		GamePanel panel = new GamePanel();

		frame.add(panel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);

		//put one time operations here (before game loop starts)
		panel.racquetInit();
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		panel.initColl();

		while (true) {
			panel.move();
			panel.repaint();
			Thread.sleep(10);
		}
	}
}