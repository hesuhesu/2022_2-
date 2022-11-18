package practice;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveCarMouse extends JFrame {

	int img_x=150, img_y=150;
	JButton button;

	public MoveCarMouse() {
		setSize(600, 300);
		button = new JButton("");
		ImageIcon icon = new ImageIcon("car.png");

		button.setIcon(icon);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		button.setLocation(img_x, img_y);
		button.setSize(200, 100);
		panel.add(button);
		panel.requestFocus();
		panel.setFocusable(true);
		panel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				button.setLocation(img_x, img_y);
			}
			public void mouseReleased(MouseEvent e) {	}
			public void mouseEntered(MouseEvent e) {	}
			public void mouseExited(MouseEvent e) {		}
			public void mouseClicked(MouseEvent e) {		}
		});
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MoveCarMouse f = new MoveCarMouse();
	}
}


