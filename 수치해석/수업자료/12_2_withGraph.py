from numpy import zeros, linspace, array, cos
import matplotlib.pyplot as plt


def f(x):
    return 3 * x - cos(x) - 1.0


n = 7
xs = zeros(n)
x0 = -2.0
x1 = 3.0
itl = range(0, 7)
it = array(itl)

for k in range(n):
    x2 = x1 - f(x1) * ((x1 - x0) / (f(x1) - f(x0)))
    x0 = x1
    x1 = x2
    xs[k] = x2

# printing output
print("%5s %8s" % ('k', 'x'))
for k in range(n):
    print("%5d %9.4f" % (k + 1, xs[k]))

plt.plot(it, xs, 'ko-')
plt.xlabel('Iteration')
plt.ylabel('x')
plt.show()