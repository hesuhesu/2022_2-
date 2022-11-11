package practice1;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	public MyFrame() {
		
		setSize(800,500);
		setTitle("BMI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		setLayout(new FlowLayout());
		
		JLabel hello = new JLabel("나의 치수는 얼마나 나올까?");
		panel1.add(hello);
		
		JLabel label1 = new JLabel("나의 체중(kg)");
		JLabel label2 = new JLabel("나의 키(m)");
		JTextField field1 = new JTextField(15);
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("BMI 확인하기");
		
		
		
		panel2.add(label1);
		panel2.add(field1);
		panel2.add(label2);
		panel2.add(field2);
		panel2.add(button);
		
		panel.add(panel1);
		panel.add(panel2);
		add(panel);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}