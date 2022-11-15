import numpy as np

h = [1.83, 1.76, 1.69, 1.86, 1.77, 1.73]
w = [86, 74, 59, 95, 80, 68]

np_h = np.array(h)
np_w = np.array(w)

bmi = np_w / (np_h ** 2)
print("대상자들 키 : ", np_h)
print("대상자들 몸무게 : ", np_w)

for i in range(len(bmi)) :
    print("{}번째 대상자의 BMI는 : {}".format(i+1, bmi[i]))
