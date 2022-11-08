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
    
    print("--------------------------------------------")
    n1 = int(input("myCar1가 가속할 속도를 입력하시오 : "))
    if n1 == -1 :
        break
    myCar1.upSpeed(n1)
    
    n2 = int(input("myCar1가 감속할 속도를 입력하시오 : "))
    if n2 == -1 :
        break
    myCar1.downSpeed(n2)
    print("--------------------------------------------")

print("최종 속력은 {}".format(myCar1.speed))
