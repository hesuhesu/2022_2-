from scipy.interpolate import lagrange
import numpy as np

x = np.array([0, 1, 2, 3])
y = x**3
poly = lagrange(x, y)
print(poly)


''' 라그랑주 2차 코드 형태
x1,x2,x3,x4,x5=-2.12,-0.94,0.00,0.94,2.12
y1,y2,y3,y4,y5=4.4944,0.8836,0.0000,0.8836,4.4944


####y=x**2 의 참값과 비교해보기########
x=[x1,x2,x3,x4,x5]
y=[y1,y2,y3,y4,y5]

###아래의 값들에 대한 보간값을 구하여라#####
xn1,xn2,xn3,xn4=-1.5,-0.5,0.5,1.5  
xn=[xn1,xn2,xn3,xn4]

for k in range(len(x)-1):
    px=0
    for i in range(len(x)):
        li=1
        lx=1
        for j in range(len(y)):
            if i != j:
                lx=lx*(xn[k]-x[j])
                li=li*(x[i]-x[j])
            else:
                continue

        px=px+y[i]*(lx/li)
        
 '''

''' 라그랑주 1차 보간
# Lagrange Interpolation

# Importing NumPy Library
import numpy as np

# Reading number of unknowns
n = int(input('Enter number of data points: '))

# Making numpy array of n & n x n size and initializing 
# to zero for storing x and y value along with differences of y
x = np.zeros((n))
y = np.zeros((n))


# Reading data points
print('Enter data for x and y: ')
for i in range(n):
    x[i] = float(input( 'x['+str(i)+']='))
    y[i] = float(input( 'y['+str(i)+']='))


# Reading interpolation point
xp = float(input('Enter interpolation point: '))

# Set interpolated value initially to zero
yp = 0

# Implementing Lagrange Interpolation
for i in range(n):

    p = 1

    for j in range(n):
        if i != j:
            p = p * (xp - x[j])/(x[i] - x[j])

    yp = yp + p * y[i]    

# Displaying output
print('Interpolated value at %.3f is %.3f.' % (xp, yp))
'''