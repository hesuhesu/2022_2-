import pathlib

a = pathlib.Path(__file__).parent.absolute()
a1 = '{}\\replacement_input.txt'.format(a)
a2 = '{}\\replacement_output.txt'.format(a)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

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
        buffer = []         # 체킹 버퍼
        File_content = []
        outputLine1 = []        # run의 개수
        outputLine2 = []        # 임시로 저장하는 곳
        outputLine3 = []
        line = 1               # 줄 갯수를 의미.
        buffer_start_number = 0 # 동결되고 난 후의 시작번호

        outputLine1.append(line) # run의 시작.
        
        buffer = sorted(inputs[:5])
        del inputs[:5]
        print("{}는 제일 작은 값입니다.\n".format(buffer[0]))
        File_content.append(buffer[0]) # run에 계속 추가
        print("버퍼의 현재 상황 : {}".format(buffer))

        while 1 : 

            buffer.append(inputs[0])
            buffer.sort()
            del inputs[0]
            print("{}는 제일 작은 값입니다.\n".format(buffer[0]))

            if buffer[buffer_start_number] >= File_content[-1] :
                File_content.append(buffer[buffer_start_number])
                del buffer[buffer_start_number]
                print("나간 뒤 버퍼의 현재 상황(4칸) : {}".format(buffer))
            
            elif buffer[buffer_start_number] < File_content[-1] :
                buffer_start_number += 1
                if buffer_start_number < 5 :
                    File_content.append(buffer[buffer_start_number])
                    del buffer[buffer_start_number]
                    print("나간 뒤 버퍼의 현재 상황(4칸) : {}".format(buffer))
                else :
                    line += 1
                    
        

        Test2.write(line)
        Test2.write()
                
                
            
        

Test1.close()
Test2.close()
