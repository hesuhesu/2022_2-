import turtle
import random



psize, tsize = 10, 0
r,g,b = 0.0, 0.0, 0.0



turtle.title("거북이로 그림 그리기")
turtle.shape('turtle')
turtle.pensize(psize)



def screenLC(x,y) :
    global r,g,b
    turtle.pencolor((r,g,b))
    turtle.pendown() # 펜을 찍고 감.
    turtle.goto(x,y)

def screenRC(x,y) :
    turtle.penup() # 펜을 떼고 감.
    turtle.goto(x,y)

def screenMC(x,y) :
    global r,g,b
    tSize = random.randrange(1,10)
    turtle.shapesize(tSize)
    r= random.random()
    g= random.random()
    b= random.random()

turtle.onscreenclick(screenLC, 1)
turtle.onscreenclick(screenRC, 2)
turtle.onscreenclick(screenMC, 3)

turtle.done()
