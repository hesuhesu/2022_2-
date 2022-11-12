package practice1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login extends JFrame{
	public login() {
		
		class MyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You failed to log in");
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("manson23", "1234");
		
		
		setSize(800,500);
		setTitle("Login Test");
		
		setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("ID : ");
		JTextField field1 = new JTextField(10);
		JLabel label2 = new JLabel("PassWord : ");
		JTextField field2 = new JTextField(10);
		JButton button = new JButton("Login");
		button.addActionListener(new MyListener());
		
		
		add(label1);
		add(field1);
		add(label2);
		add(field2);
		add(button);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		login f = new login();
	}
}