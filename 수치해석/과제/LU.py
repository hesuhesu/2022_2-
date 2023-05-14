from copy import deepcopy
import os, sys
from numpy import array, zeros, append
import numpy as np

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
a1 = '{}\\LU_in.txt'.format(path)
a2 = '{}\\LU_out.txt'.format(path)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

def resize(N):  # 테이블 재할당
    global A, L, U, temp, x, y
    A = [deepcopy([0 for _ in range(N)]) for _ in range(N)]
    L = [deepcopy([0 for _ in range(N)]) for _ in range(N)]
    U = [deepcopy([0 for _ in range(N)]) for _ in range(N)]
    temp = [deepcopy(0) for _ in range(N)]
    x = [deepcopy(0) for _ in range(N)]
    y = [deepcopy(0) for _ in range(N)]

def LU(A,b):
    for i in range(N):  # 대각행렬 만들기
        for k in range(N):
            if i == k:
                temp[k] = 1
            else:
                temp[k] = 0

        I.append(deepcopy(temp))

    L = deepcopy(I)
    U = deepcopy(A)

    for i in range(0, N - 1):  # LU분해
        for k in range(i + 1, N):
            L[k][i] = U[k][i] / U[i][i]
        for k in range(i + 1, N):
            for z in range(i, N):
                U[k][z] = U[k][z] - L[k][i] * U[i][z]

    L=array(L)

    for i in range(N):  # 해 구하기
        y[i] = b[i]
        for k in range(i):
            y[i] = y[i] - (L[i][k] * y[k])
        y[i] = y[i] / L[i][i]

    for i in range(N - 1, -1, -1):
        x[i] = y[i]
        for k in range(i + 1, N):
            x[i] = x[i] - U[i][k] * x[k]
        x[i] = x[i] / U[i][i]

    return L,U,x,y


N=0
A = []
L = []
U = []
I = []
temp = []
x = []
y = []

listA = []
listB = []
checkList = Test1.readline().split()
checkList = list(map(int, checkList))
checknum = checkList[0]
checkindex = 0
now_index = 0
listA.append(checkList)
listNum1 = len(checkList)-1
listNum2 = len(checkList)
for _ in range(listNum1) :
    checkindex += 1
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    listA.append(checkList)

Test1.readline()

for _ in range(listNum2) :
    checkList = Test1.readline()
    checkList = int(checkList)
    listB.append(checkList)    


N=len(listA)
resize(N)
A = array(listA,dtype=np.float64) # , 
b = array(listB,dtype=np.float64) # , dtype=np.float64
L,U,x,y = LU(A,b)

print(L)
print()
print(U)
print()
print("y", end = " ")
print(y)
print()

x = list(map(str, x))
y = list(map(str, y))

for i in range(len(b)) :
    for j in range(len(b)):
        Test2.write(str(L[i][j])+" ")
    Test2.write("\n")

Test2.write("\n")
for i in range(len(b)) :
    for j in range(len(b)):
        Test2.write(str(U[i][j])+" ")
    Test2.write("\n")

Test2.write("\ny [")
for i in range(len(b)):
    if i == len(b) - 1 :
        Test2.write(y[i]+"]\n")
        break
    Test2.write(y[i]+", ")

Test2.write("\n")
for i in range(listNum2):
    if (i == listNum2-1):
        print("x{} = {}".format(i+1,x[i]), end = "")
        Test2.write("x{} = {}".format(i+1,x[i]))
        break
    print("x{} = {}, ".format(i+1,x[i]), end = "")
    Test2.write("x{} = {}, ".format(i+1,x[i]))
