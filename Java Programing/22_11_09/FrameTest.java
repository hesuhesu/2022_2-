package practice1;

import javax.swing.*;

public class FrameTest {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Frame Test");
		f.setTitle("MyFrame");
		f.setSize(300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
