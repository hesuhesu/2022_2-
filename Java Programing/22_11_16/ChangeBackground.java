package practice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangeBackground extends JFrame {

    private JButton button1;
    private JButton button2;
    private JPanel panel;
    MyListener listener = new MyListener();

    public ChangeBackground() {
          this.setSize(300, 200);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setTitle("이벤트 예제");
          panel = new JPanel();

          button1 = new JButton("노란색");
          button1.addActionListener(listener);
          panel.add(button1);
          button2 = new JButton("핑크색");
          button2.addActionListener(listener);

          panel.add(button2);
          this.add(panel);
          this.setVisible(true);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
               if (e.getSource() == button1) {
                      panel.setBackground(Color.YELLOW);
               } else if (e.getSource() == button2) {
                      panel.setBackground(Color.PINK);
               }
        }
   }


   public static void main(String[] args) {
	   ChangeBackground t = new ChangeBackground();
   }
}
