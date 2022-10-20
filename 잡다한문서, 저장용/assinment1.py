import pathlib

a = pathlib.Path(__file__).parent.absolute()
a1 = '{}\\replacement_input.txt'.format(a)
a2 = '{}\\replacement_output.txt'.format(a)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

ab = int(Test1.readline())         # 계산을 반복할 횟수를 불러온다.

for i in range(ab*2) :
    if i % 2 == 0 :
        bc = int(Test1.readline())
        print(bc)
    else :
        listA = Test1.readline()
        inputs = listA.split()
        print(inputs)
        BringList = []          # 1차 읽어온 리스트.
        emptyList1 = []         # 임시로 기입할 리스트
        emptyList2 = []
        emptyList3 = []        # 최종 출력을 위한 리스트.
        line = 1               # 줄 갯수를 의미.
        for i in range(bc) :
            BringList.append(int(inputs[i]))

        for i in range(bc) : 
            find_list = min(BringList[:5])
            print(find_list)
            emptyList1.append(find_list)
            BringList.remove(find_list)
            ready_list = min(BringList[:5])

            if ready_list < emptyList1[-1] :  # 만약 5개 내에 숫자가 전 숫자보다 작다면
                BringList.index(ready_list)
                


Test1.close()
Test2.close()