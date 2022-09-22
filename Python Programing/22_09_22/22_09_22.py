import turtle

t = turtle.Turtle()
t.shape("turtle")

# 정삼각형 그리기
for i in range(3) :
    t.forward(100)
    t.left(360/3) # 각을 120도로 꺾어서 모양을 만듬.

# 정사각형을 그리기 위해 터틀 활용
t.penup()
t.goto(200,0)
t.pendown()

for i in range(4):
    t.forward(100)
    t.left(360/4) # 각을 90도로 꺾어서 모양을 만듬.

turtle.done()
