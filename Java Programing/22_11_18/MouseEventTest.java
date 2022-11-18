package practice1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MouseEventTest extends JFrame implements MouseListener, MouseMotionListener {
	public MouseEventTest() {
		setTitle("Mouse Event");
		setSize(300, 200);

		JPanel panel = new JPanel();
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mousePressed(MouseEvent e) {
		display("Mouse pressed (# of clicks: " + e.getClickCount() + ")", e);
	}
	public void mouseReleased(MouseEvent e) {
		display("Mouse released (# of clicks: " + e.getClickCount() + ")", e);
	}
	public void mouseEntered(MouseEvent e) {
		display("Mouse entered", e);
	}
	public void mouseExited(MouseEvent e) {
		display("Mouse exited", e);
	}
	public void mouseClicked(MouseEvent e) {
		display("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
	}
	public void mouseDragged(MouseEvent e) {
		display("Mouse dragged", e);
	}
	public void mouseMoved(MouseEvent e) {
		display("Mouse moved", e);
	}
	protected void display(String s, MouseEvent e) {
		System.out.println(s + " X=" + e.getX() + " Y=" + e.getY());
	}
	public static void main(String[] args) {
		MouseEventTest f = new MouseEventTest();
	}
}
