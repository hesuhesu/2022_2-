package practice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ball {
	int x, y, xInc, yInc, diameter;
	final Random r = new Random();
	Color color;

	public Ball(int d) { // (1)
		this.diameter = d;

		x = (int) (Math.random() * (BouncingBall.WIDTH - d) + 3);
		y = (int) (Math.random() * (BouncingBall.HEIGHT - d) + 3);
		xInc = (int) (Math.random() * 5 + 1);
		yInc = (int) (Math.random() * 5 + 1);
		color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
	}
	public void paint(Graphics g) { // (2)
		if (x < 0 || x > (BouncingBall.WIDTH - diameter))
			xInc = -xInc;
		if (y < 0 || y > (BouncingBall.HEIGHT - diameter))
			yInc = -yInc;
		x += xInc;
		y += yInc;
		g.setColor(color);
		g.fillOval(x, y, diameter, diameter);
	}
}
public class BouncingBall extends JFrame implements ActionListener {
	static final int WIDTH = 600;
	static final int HEIGHT = 200;
	private static final int PERIOD = 10;

	class MyPanel extends JPanel {
		public Ball basket[] = new Ball[10]; // (3)

		public MyPanel() {
			for (int i = 0; i < 10; i++)
				basket[i] = new Ball((int) (30 + 30 * Math.random()));

		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Ball b : basket) {
				b.paint(g);
			}
		}
	}
	public BouncingBall() {
		MyPanel panel = new MyPanel();

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(panel);
		pack();							
		setTitle("Bouncing Ball");
		Timer timer = new Timer(PERIOD, this);
		timer.start();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		repaint();
	}

	public static void main(String[] args) {
		BouncingBall f = new BouncingBall();
	}
}
