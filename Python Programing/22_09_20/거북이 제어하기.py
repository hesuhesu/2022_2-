import turtle

t = turtle.Turtle()
t.shape('turtle')

t.width(3)
t.shapesize(3,3)

while True :
    command = input("명령을 입력하시오.")

    if command == "1" :
        t.left(90)
        t.forward(100)
    elif command == "r" :
        t.right(90)
        t.forward(100)
    else : 
        break

turtle.done()
