package practice1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	Font f1, f2;

	public MyPanel() {
		f1 = new Font("Serif", Font.PLAIN, 20);
		f2 = new Font("San Serif", Font.BOLD, 20);
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setFont(f1);
		g.drawString("Serif 20 points PLAIN", 10, 50);
		g.setFont(f2);
		g.drawString("SanSerif 20 points BOLD", 10, 70);
		
		Dimension d = getSize();
		int gWidth = d.width/3;
		int gHeigth = d.height/3;

	}
}

public class drawTest extends JFrame {
	public drawTest() {
		setSize(500, 200);
		setTitle("draw Test");
		JPanel panel = new MyPanel();
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		drawTest s = new drawTest();
	}
}