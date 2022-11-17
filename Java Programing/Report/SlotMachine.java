package practice;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlotMachine extends JFrame{
	public SlotMachine() {
		
		JLabel J1 = new JLabel();
		JLabel J2 = new JLabel();
		JLabel J3 = new JLabel();
		
		
		class MyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int computer = random.nextInt(10); 
				int computer2 = random.nextInt(10); 
				int computer3 = random.nextInt(10); 
				J1.setText(""+computer);
				J2.setText(""+computer2);
				J3.setText(""+computer3);
			}
		}
		
		
		setSize(800,500);
		setTitle("My Game");
		
		setLayout(null);
		
		JButton button = new JButton("스핀");
		button.addActionListener(new MyListener());
		
		// 폰트 지정
		Font font = new Font("", Font.BOLD, 50);
		font = new Font("궁서체", Font.BOLD, 50);
		J1.setFont(font);
		J2.setFont(font);
		J3.setFont(font);
		
		add(J1);
		add(J2);
		add(J3);
		add(button);
		
		J1.setBounds(90,60,30,50);
		J2.setBounds(150,60,30,50);
		J3.setBounds(210,60,30,50);
		button.setBounds(45, 150, 240,30);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		SlotMachine f = new SlotMachine();
	}
}