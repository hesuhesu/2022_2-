import os
import sys
from numpy import *
from numpy.linalg import det

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
a1 = '{}\\cramer_in.txt'.format(path)
a2 = '{}\\cramer_out.txt'.format(path)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

def cramer(A,b):
    n = len(b)
    detsub = zeros((n))
    x = zeros((n))
    detA = det(A)
    for i in range(n):
        Atemp = A.copy()
        Atemp[:,i] = b
        detsub[i] = det(Atemp)
        x[i] = detsub[i]/detA
    return detsub, x

listA = []
listB = []
checkList = Test1.readline().split()
checkList = list(map(int, checkList))
listA.append(checkList)

listNum1 = len(checkList)-1
listNum2 = len(checkList)
for _ in range(listNum1) :
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    listA.append(checkList)

Test1.readline()    
    
for _ in range(listNum2) :
    checkList = Test1.readline()
    checkList = int(checkList)
    listB.append(checkList)

A = array(listA)
b = array(listB)

detsub, x = cramer(A,b)

x = list(map(str, x))
Test2.write("[")
for i in range(listNum2):
    if (i == listNum2-1):
        Test2.write("'x{} = ', {}".format(i+1,x[i]))
        break    
    Test2.write("'x{} = ', {}, ".format(i+1,x[i]))
Test2.write("]")

Test1.close()
Test2.close()
