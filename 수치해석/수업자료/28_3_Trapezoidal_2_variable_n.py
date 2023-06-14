from numpy import exp,sqrt

def trapezoidal(f,a,b,n):
    h = (b-a)/n
    trap = 0.0
    for i in range(1,n):
        x = a + i*h # a 시작점부터 i*h를 더해 구간을 1칸식 진행
        trap = trap + 2.0 * f(x) # 중간 부분만 누적
    trap = h * (f(a) + trap + f(b)) / 2.0 #사다리꼴 공식
    return trap

def f(x):
    return x**2 * exp(-x)/sqrt(1.0 + x**2)

a = -1.0
b = 1.0
n = 512 #구간을 나누면 실제 적분값에 가까워짐

#T = trapezoidal(f,a,b,n)
for i in range(32):
    if(i==0): continue
    else:
        T = trapezoidal(f, a, b, i)
    print('T = %8.4f' % T)
