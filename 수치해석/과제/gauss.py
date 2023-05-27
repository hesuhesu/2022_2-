import os, sys
from numpy import array, zeros
import numpy as np

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
a1 = '{}\\gauss_in.txt'.format(path)
a2 = '{}\\gauss_out.txt'.format(path)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

def gauss(A,b):
    print("-----------------------------------------------------------------------")
    n = len(b)
    count = 0
    for k in range(0, n-1):

        result = 0
        index = count
        for j in range(count,n):
            if (result < A[j, k]):
                result = A[j, k]
                index = j

        for z in range(n):
            A[count, z], A[index, z] = A[index, z], A[count,z]
        b[count], b[index] = b[index], b[count]

        print("\n피봇 후 행렬 근황 \n")
        print(A)
        print()
        print(b)

        for i in range(k+1, n):
            if A[i, k] != 0.0:
                lam = A[i, k] / A[k, k]
                A[i, k:n] = A[i, k:n] - lam*A[k, k:n]
                b[i] = b[i] - lam*b[k]
        
        count += 1
        print("-----------------------------------------------------------------------")
                
    x = zeros((n))
    for k in range(n-1, -1, -1):
        x[k] = (b[k] - np.dot(A[k, k+1: n], x[k+1: n])) / A[k, k]

    return A,b,x

listA = []
listB = []
checkList = Test1.readline().split()
checkList = list(map(int, checkList))
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


A = array(listA, dtype=np.float64)
b = array(listB, dtype=np.float64)
print("<변환 전 A,b 근황>\n")
print(A)
print()
print(b)
resultA, resultB, x = gauss(A,b)
print("<변환 후 A,b 근황>\n")
print(A)
print()
print(b)
print()
x = list(map(str, x))

for i in range(len(b)) :
    for j in range(len(b)):
        Test2.write(str(resultA[i][j])+" ")
    Test2.write("\n")

Test2.write("\n")
for i in range(len(b)):
    Test2.write(str(resultB[i])+"\n")

Test2.write("\n")
for i in range(listNum2):
    if (i == listNum2-1):
        print("x{} = {}".format(i+1,x[i]), end = "")
        Test2.write("x{} = {}".format(i+1,x[i]))
        break
    print("x{} = {}, ".format(i+1,x[i]), end = "")
    Test2.write("x{} = {}, ".format(i+1,x[i]))

Test1.close()
Test2.close()
