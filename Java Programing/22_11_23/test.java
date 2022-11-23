package newnew;

/****************************************************************/
/* test */
/* */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
* Summary description for test
*
*/
public class test extends JFrame
{
// Variables declaration
private JPanel contentPane;
//-----
private JButton jButton1;
private JPanel jPanel1;
//-----
private JPanel jPanel2;
//-----
// End of variables declaration

int x = 10;
int y = 10;
int s_x = 10;
int s_y = 10;
int width = 80;
int height = 20;
public test()
{
super();
initializeComponent();


this.setVisible(true);
}

private void initializeComponent()
{
contentPane = (JPanel)this.getContentPane();
//-----
jButton1 = new JButton();
jPanel1 = new JPanel();
//-----
jPanel2 = new JPanel();
//-----

//
// contentPane
//
contentPane.setLayout(null);
addComponent(contentPane, jPanel1, 4,7,353,100);
addComponent(contentPane, jPanel2, 6,116,352,100);
//
// jButton1
//
jButton1.setText("jButton1");
jButton1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
jButton1_actionPerformed(e);
}



});
//
// jPanel1
//

jButton1.addMouseMotionListener(new MouseMotionAdapter() {


public void mouseDown( MouseEvent ev, int x,int y){
System.out.println(x);


}


public void mouseDragged(MouseEvent ev) {
int tem_x = ev.getX()-(width/2); // 이벤트 발생 좌표값중 x값 추출
int tem_y = ev.getY()-(height/2); // 이벤트 발생 좌표값중 y값 추출..


System.out.println(ev.getX());


// 마우스 포인터가 버튼 영역 안 여부 판단 후 버튼 위치 재지정...

x= x+tem_x;
y= y+tem_y;
jButton1.setBounds(x, y, width, height);
if(y>90){
addComponent(jPanel2, jButton1, x,200,73,25);
}


}
});



jPanel1.setLayout(null);
jPanel1.setBackground(new Color(204, 204, 255));
addComponent(jPanel1, jButton1, 5,7,73,25);
//
// jPanel2
//
jPanel2.setLayout(null);
jPanel2.setBackground(new Color(153, 153, 255));
//
// test
//
this.setTitle("test - extends JFrame");
this.setLocation(new Point(0, 0));
this.setSize(new Dimension(371, 259));


}

/** Add Component Without a Layout Manager (Absolute Positioning) */
private void addComponent(Container container,Component c,int x,int y,int width,int height)
{
c.setBounds(x,y,width,height);
container.add(c);
}

//
// TODO: Add any appropriate code in the following Event Handling Methods
//
private void jButton1_actionPerformed(ActionEvent e)
{
System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
// TODO: Add any handling code here

}

public static void main(String[] args)
{
JFrame.setDefaultLookAndFeelDecorated(true);
JDialog.setDefaultLookAndFeelDecorated(true);
try
{
UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
}
catch (Exception ex)
{
System.out.println("Failed loading L&F: ");
System.out.println(ex);
}
new test();
}
}