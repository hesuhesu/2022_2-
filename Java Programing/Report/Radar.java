/*
1) 버튼, 또는 마우스 클릭을 통해 레이더를 생성하고 삭제할 수 있도록 구현
 - 레이더의 개수는 최소 3개 이상 생성할 수 있도록 구현
 - 최대 개수는 자유롭게 하되 그래픽이 자연스러운 범위 내에서 생성하도록 할 것 

2) 각 레이더(원)는 프레임(또는 패널)내에서 이동해야 함
 - 방향은 자유롭게 움직이되 연속적인 움직임이 되도록 구현(특정 좌표에서 갑자기 관계 없는 위치에 나타나는 이동은 안됨)
 - 직선이나 곡선의 이동 궤적 모두 사용 가능

3) 레이더는 생성될 때 마다 다른 색상을 가지도록 구현할 것
 - 레이더 상에 나타나는 점은 다른 레이더의 색상을 반영할 것
 - 간혹 중복되는 색상은 무방함 

4) 각 레이더는 그림과 같이 상대 레이더의 위치가 자신의 중점을 기준으로 레이더 영역 내에 식별되는 색상으로 나타나도록 할 것
 - 거리는 수식으로 정교하게 계산하거나, 또는 적절하게 보이는 수준으로 하는 것 모두 사용 가능
 - 단 직관적으로 봤을 때 상대 레이더의 위치가 납득되는 수준으로 출력 되어야 함
 */

package first;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Radar extends JFrame {

	public Radar() {
		
		setSize(500,500);
		setTitle("Bouncing Ball");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("삭제");
		JPanel panel = new JPanel();

		panel.add(btn1);
		panel.add(btn2);
		add(panel);

	}

	public static void main(String args[]) {
		Radar R = new Radar();
	}
}
