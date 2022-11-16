package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventTest4 extends JFrame {
	private JButton button;
	private JLabel label;

	int counter=0;

	public EventTest4() {
		this.setSize(400, 150);
		this.setTitle("이벤트 예제");

		JPanel panel = new JPanel(); 
		button = new JButton("증가");
		label = new JLabel("현재의 카운터값:  "+counter);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				label.setText("현재의 카운터값:  "+counter);
			}
		});


		panel.add(label);
		panel.add(button);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		EventTest4 f = new EventTest4();
	}
}
