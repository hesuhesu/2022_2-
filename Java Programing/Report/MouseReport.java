package doit;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseReport extends JFrame{
	
	int img_x=150, img_y=150;
	JButton button;

	
	
	
	public MouseReport() {
		
		
		setLayout(null); // new GridLayout(2,1)
		setSize(500,500);
		
		JPanel panelup = new JPanel();
		JPanel paneldown = new JPanel();
		
		panelup.setBackground(new Color(0,255,255));
		paneldown.setBackground(new Color(255,255,255));
		
		panelup.setBounds(0,0,0,0);
		
		
		add(panelup);
		add(paneldown);
		add(button);
		
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void mousePressed(MouseReport e) {
		img_x = e.getX();
		img_y = e.getY();
		button.setLocation(img_x, img_y);
		display("Mouse pressed (# of clicks: " + e.getComponentCount() + ")", e);
	}
	public void mouseReleased(MouseReport e) {
		display("Mouse released (# of clicks: " + e.getComponentCount() + ")", e);
	}
	public void mouseEntered(MouseReport e) {
		display("Mouse entered", e);
	}
	public void mouseExited(MouseReport e) {
		display("Mouse exited", e);
	}
	public void mouseClicked(MouseReport e) {
		display("Mouse clicked (# of clicks: " + e.getComponentCount() + ")", e);
	}
	public void mouseDragged(MouseReport e) {
		display("Mouse dragged", e);
	}
	public void mouseMoved(MouseReport e) {
		display("Mouse moved", e);
	}
	protected void display(String s, MouseReport e) {
		System.out.println(s + " X=" + e.getX() + " Y=" + e.getY());
	}
	
	
	
	
	
	public static void main(String[] args) {
		MouseReport M = new MouseReport();
		
	}	
}
