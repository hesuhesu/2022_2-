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
    elif command == "f" :
        t.forward(100)
    elif command == "h" :
        t.shapesize(30,30)
    elif command == "n" :
        t.shapesize(3,3)
    elif command == "z" :
        aa = int(input('사이즈를 입력하세요'))
        t.shapesize(3*aa,3*aa)
    else : 
        break

turtle.done()
