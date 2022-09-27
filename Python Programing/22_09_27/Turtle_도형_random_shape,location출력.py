import turtle
import random

# 전역 변수 선언
myturtle, tx, ty,tcolor,tsize,tshape = [None] * 6
shapelist = []
playturtles = []
sw,sh = 500,500

def main():
    turtle.title('거북 리스트 활용')
    turtle.setup(width = sw + 50, height = sh + 50)
    turtle.screensize(sw,sh)

    shapelist = turtle.getshapes()

    for i in range(0,100) :
        random.shuffle(shapelist)
        myturtle = turtle.Turtle(shapelist[0])
        tx = random.randrange(-sw/2, sw/2)
        ty = random.randrange(-sh/2, sh/2)
        r = random.random()
        g = random.random()
        b = random.random()
        tsize = random.randrange(1,3)
        playturtles.append([myturtle, tx, ty, tsize, r, g, b])

    for tlist in playturtles :
        myturtle = tlist[0]
        myturtle.color((tlist[4], tlist[5], tlist[6]))
        myturtle.pencolor((tlist[4], tlist[5], tlist[6]))
        myturtle.turtlesize(tlist[3])
        myturtle.goto(tlist[1], tlist[2])
    turtle.done()

main()
