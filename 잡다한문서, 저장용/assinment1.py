import pathlib
from tempfile import TemporaryFile

fp = TemporaryFile('w+t') # 임시 파일 만들고 데이터 쓰기

a = pathlib.Path(__file__).parent.absolute()
a1 = '{}\\replacement_input.txt'.format(a)
a2 = '{}\\replacement_output.txt'.format(a)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

def next_price(A,B) :
    C = A.sort() # A는 inputs[:5] 
    D = 100
    for i in C : # inputs[:5] 중에 B인 emptyList1의 최댓값을 넘는 제일 작은값을 출력.
        if i > B :
            D = A.index(i)
            break
    return D

ab = int(Test1.readline())         # 계산을 반복할 횟수를 불러온다.

for i in range(ab*2) :
    
    if i % 2 == 0 :
        bc = int(Test1.readline())
        print(bc)
    else :
        listA = Test1.readline()
        inputs = listA.split()
        print(inputs)  # 가져온 리스트.
        emptyList1 = []         # 임시로 기입할 리스트
        emptyList2 = []
        emptyList3 = []        # run의 개수
        line = 1               # 줄 갯수를 의미.

        emptyList3.append(line)
        for i in range(bc) : 
            find_list = min(inputs[:5])
            print("{}는 제일 작은 값입니다.".format(find_list))
            print("최소값의 위치는 {}번째".format(inputs.index(find_list) + 1))        # 인덱스의 위치를 알려준다.
            
            if find_list > emptyList1[-1] :
                emptyList1.append(find_list)
                inputs.remove(find_list)

            elif find_list < emptyList1[-1] :  # 5개 중 젤 작은 수가 추가된 줄 제일 큰 수보다 작다면
                next_price(inputs[:5],emptyList1[-1])
                if next_price == 100 :
                    line += 1
                    emptyList3[0] += 1 # 한 줄이 늘어남
                    emptyList2.append(emptyList1)



Test1.close()
Test2.close()
