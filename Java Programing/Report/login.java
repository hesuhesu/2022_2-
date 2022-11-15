package practice1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login extends JFrame{
	public login() {
		
		JTextField field1 = new JTextField(10);
		JTextField field2 = new JTextField(10);
		
		class MyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				if (field1.getText().equals("test1") && field2.getText().equals("1234")) { // 단순하게 하나만 로그인 할 수 있는 id, pw를 생성했습니다.
					JOptionPane.showMessageDialog(null, "Welcome");
				}
				else {
					JOptionPane.showMessageDialog(null, "You failed to log in");
				}
				
			}
		}
		
		
		setSize(800,500);
		setTitle("Login Test");
		
		setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("ID : ");
		
		JLabel label2 = new JLabel("PassWord : ");
		
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
