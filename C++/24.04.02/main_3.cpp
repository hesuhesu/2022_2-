#include <iostream>

using namespace std;

class remoteControl {
	bool on = true;
	int channel = 100;
	int volume = 10;
public :
	void setChannel(int channel) { this->channel = channel; }
	int getChannel() {
		return channel;
	}
	void poweron() { on = true; }
	void poweroff() { on = false; }
	void increaseChannel() { channel++; }
	void decreaseChannel() { channel--; }
	void increaseVolume() { volume++; }
	void decreaseVolume() { volume--; }
};

int main() {
	
	remoteControl controller[3];

	controller[0].setChannel(50);
	controller[2].setChannel(20);

	for (int i = 0; i < 3; i++) {
		cout << i << " 컨트롤러의 채널은 : " << controller[i].getChannel() << "\n";
	}

	return 0;
}
