package doit;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseReport extends JFrame implements MouseListener, MouseMotionListener{
	
	int img_x=150, img_y=150;
	
	JButton button = new JButton("날라댕긴다");
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("마우스 클릭한 위치 :  X=" + img_x + " Y=" + img_y);
			
		}
	}
	
	public MouseReport() {
		
		
		setLayout(null); // new GridLayout(2,1)
		setSize(500,500);
		
		
		JPanel panelup = new JPanel();
		JPanel paneldown = new JPanel();
		
		panelup.setBackground(new Color(0,255,255));
		paneldown.setBackground(new Color(255,255,255));
		
		panelup.setBounds(0,0,2000,550);
		paneldown.setBounds(0,550,2000,550);
		
	
		button.setBounds(200,200,1000,1000);
		button.addActionListener(new MyListener());
		panelup.add(button);
		
		add(panelup);
		add(paneldown);
		
		PointerInfo M_pointer = MouseInfo.getPointerInfo();
		
		
		panelup.addMouseListener(this);
		panelup.addMouseMotionListener(this);
		paneldown.addMouseListener(this);
		paneldown.addMouseMotionListener(this);
		
		
		/*panelup.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				System.out.println(e);
			}
		});*/
		
		
		
		
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void mousePressed(MouseEvent e) {
		
		
				button.setLocation(img_x, img_y);
	}
	public void mouseReleased(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {

		
		
	}
	public void mouseClicked(MouseEvent e) {
		img_x = e.getX();
		img_y = e.getY();
		
		System.out.println("x축 : "+img_x+" / y축 : "+img_y);
	}
	public void mouseMoved(MouseEvent e) {
		
	}
	public void mouseDragged(MouseEvent e) {
		
		img_x = e.getX();
		img_y = e.getY();
		button.setLocation(img_x, img_y);
		display("마우스 드래그 위치 : ", e);
	}
	protected void display(String s, MouseEvent e) {
		System.out.println(s + " X=" + e.getX() + " Y=" + e.getY());
	}
	
	
	public static void main(String[] args) {
		MouseReport M = new MouseReport();
		
	}	
}
