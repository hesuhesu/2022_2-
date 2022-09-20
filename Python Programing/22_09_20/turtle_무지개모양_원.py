import turtle
import random

sw, sh = 500, 500

turtle.title('무지개색 원 그리기')
turtle.setup(width = sw + 50, height = sh + 50)
turtle.screensize(sw, sh)

myT = turtle.Turtle()
myT.shape('turtle')
myT.penup()
myT.goto(0, -sh / 2)
myT.pendown()
myT.speed(10)



for i in range(50) :
    
    radius = random.randrange(30,256)
    
    if radius % 6 == 0:
        myT.pencolor('red')
    elif radius % 5 == 0:
        myT.pencolor('orange')
    elif radius % 4 == 0:
        myT.pencolor('yellow')
    elif radius % 3 == 0:
        myT.pencolor('green')
    elif radius % 2 == 0:
        myT.pencolor('blue')
    elif radius % 1 == 0:
        myT.pencolor('navyblue')
    else :
        myT.pencolor('purple')

    myT.circle(radius)

turtle.done()