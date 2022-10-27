import pathlib

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

listnum = 0

ab = int(Test1.readline())         # 계산을 반복할 횟수를 불러온다.

for i in range(ab*2) :
    
    if i % 2 == 0 :
        bc = int(Test1.readline())
        print("\n----------------------------------------------")
        print("\n아래 리스트의 갯수는 {}입니다.\n".format(bc))
    else :
        listA = Test1.readline()
        inputs = listA.split()
        print("----------------------------------------------\n")
        print(inputs)  # 가져온 리스트.
        print("\n----------------------------------------------\n")
        emptyList1 = []         # 임시로 기입할 리스트
        emptyList2 = []
        emptyList3 = []        # run의 개수
        line = 1               # 줄 갯수를 의미.
        
        emptyList3.append(line) # run의 시작.
        
        min_price = min(inputs[:5]) # 처음 1차 최솟값을 도출
        print("{}는 제일 작은 값입니다.".format(min_price))
        emptyList1.append(min_price) 
        inputs.remove(min_price)
        print(emptyList1)

        while 1 :

            if (inputs == []) : # 리스트 내에 아무것도 없을 때.
                break
            
            elif min_price > emptyList1[-1] :
                emptyList1.append(min_price)
                inputs.remove(min_price)
                print(emptyList1)

            elif min_price < emptyList1[-1] :  # 5개 중 젤 작은 수가 추가된 줄 제일 큰 수보다 작다면
                emptyList1.pop()
                next_price(inputs[:5],emptyList1[-1])
                print("동결")
                if next_price == 100 :
                    line += 1
                    emptyList3[listnum] += 1 # 한 줄이 늘어남
                    emptyList2.append(emptyList1)

            else : # 오류나면 삭제하기.
                min_price = min(inputs[:5])
                print("{}는 제일 작은 값입니다.".format(min_price))
            
                emptyList1.append(min_price)
                inputs.remove(min_price)
                print(emptyList1)

        listnum += 1
        print(emptyList2)
        print(emptyList3)
        

Test1.close()
Test2.close()
