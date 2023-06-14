from numpy import array, linspace, zeros, sign, cos
import matplotlib.pyplot as plt


def f(x):
    return x * 0.5 + 1.5


x = array([0, 1, 2])
y_r = array([1, 3, 2])
y = zeros(3)

n = len(x)
c = zeros(n)

for i in range(n):
    y[i] = f(x[i])

# printing output
print("%5s %8s" % ('x', 'y'))
for k in range(n):
    print("%5d %9.4f" % (k, y[k]))

plt.plot(x, y, 'k--')
plt.scatter(x, y_r, s =30, facecolor = 'black' )
plt.xlabel('x')
plt.ylabel('y')
plt.show()
