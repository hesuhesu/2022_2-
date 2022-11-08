# 생성자가 있는 Car class

class Car :
    color = ""
    speed = 0
    
    def __init__(self, value1, value2) :
        self.color = value1
        self.speed = value2
    
    def upSpeed(self, value) :
        self.speed += value
        
    def downSpeed(self, value) :
        self.speed -= value
        
myCar1 = Car("빨강", 30)
myCar2 = Car("파랑", 60)

print(myCar1.speed, myCar2.speed)

while 1 :
    n1 = int(input("myCar1가 가속할 속도를 입력하시오 : "))
    if n1 == 0 :
        break
    myCar1.upSpeed(n1)

print("최종 속력은 {}".format(myCar1.speed))
