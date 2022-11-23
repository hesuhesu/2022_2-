package practice1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame_Graphic extends JFrame {

	class MyPanel extends JPanel {
		protected void paintComponent(Graphics g) {		// (1)
			super.paintComponent(g);	
			g.drawOval(60, 50, 60, 60);			// (2)
			g.drawRect(120, 50, 60, 60);			// (3)
			g.setColor(Color.BLUE);
			g.fillOval(180, 50, 60, 60);
			g.fillRect(240, 50, 60, 60);
		}
	}
	public MyFrame_Graphic() {
		setTitle("Basic Painting");
		setSize(600, 200);
		add(new MyPanel());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MyFrame_Graphic f = new MyFrame_Graphic();
	}
}
