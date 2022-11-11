package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	double weight, height;
	
	JTextField field1 = new JTextField(15);
	JTextField field2 = new JTextField(15);
	
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			weight = Double.parseDouble(field1.getText());
			height = Double.parseDouble(field2.getText());
			double bmi = weight / Math.pow(height, 2);
			JOptionPane.showMessageDialog(null, "BMI는 : " + bmi);
			
		}
	}
	
	public MyFrame() {
		
		setSize(700,250);
		setTitle("BMI");
		
		setLayout(null);
		
	
		JLabel hello = new JLabel("나의 BMI?");
		JLabel label1 = new JLabel("나의 체중(kg)");
		JLabel label2 = new JLabel("나의 키(m)");
		JButton button = new JButton("BMI 확인하기");
		button.addActionListener(new MyListener());
		
		
		add(hello);
		add(label1);
		add(field1);
		add(label2);
		add(field2);
		add(button);
		
		
		hello.setBounds(30,30,70,30);
		label1.setBounds(30,60,200,30);
		field1.setBounds(120,60,200,30);
		label2.setBounds(30,90,200,30);
		field2.setBounds(120,90,200,30);
		button.setBounds(120,120,200,30);
		
	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		MyFrame F = new MyFrame();
	}

}
