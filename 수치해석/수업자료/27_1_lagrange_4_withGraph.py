import numpy as np
import matplotlib.pyplot as plt

def lagrange_interpolation_polynomial(x: float, x_data: list, y_data: list):
    n = len(x_data)
    tmp = 0

    for i in range(n): #L0~L2까지를 전환
        prod = 1
        for j in range(n): #각 Lj 내에서 변수의 첨자를 증가
            if i != j:
                prod *= (x - x_data[j])/(x_data[i] - x_data[j])                
        tmp += prod * y_data[i]  #y_data 자리에 f(x)를 사용할 수 있음
    return tmp

x_data = [0.0, 1.0, 2.0]
print(x_data)
#y_data = [f(i) for i in x_data]
y_data = [1.0, 3.0, 2.0]

x = np.linspace(0, 2, 100)
y = [1.0, 3.0, 2.0]

yy = [lagrange_interpolation_polynomial(i, x_data, y_data) for i in x]


plt.plot(x_data,y_data,'bo')
plt.plot(x,yy,'g-') #add my line to the previous figure

plt.xlabel(r'LARGE $x$')
plt.ylabel(r'LARGE $f(x)$')
plt.savefig('fig 2nd.lagrange', format='eps')
plt.show()
