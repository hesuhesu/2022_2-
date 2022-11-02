import pathlib

a = pathlib.Path(__file__).parent.absolute()
a1 = '{}\\replacement_input.txt'.format(a)
a2 = '{}\\replacement_output.txt'.format(a)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

ab = int(Test1.readline())         # 계산을 반복할 횟수를 불러온다.

listnum = 0
Anum = 1
for i in range(ab*2) :
    
    if i % 2 == 0 :
        bc = int(Test1.readline())
        print("\n----------------------------------------------")
        print("\n{}번째 리스트의 갯수는 {}입니다.\n".format(Anum,bc))
        Anum += 1
    else :
        listA = Test1.readline()
        inputs = listA.split()
        print("----------------------------------------------\n")
        print(inputs)  # 가져온 리스트.
        print("\n----------------------------------------------\n")
        buffer = []         # 체킹 버퍼
        File_content = []
        outputLine1 = []        # run의 개수
        outputLine2 = []        # 임시로 run 리스트들 저장하는 곳
        line = 1             # 줄 갯수를 의미.
        buffer_start_number = 0 # 동결되고 난 후의 시작번호

        outputLine1.append(line) # run의 시작.
        
        inputs = list(map(int, inputs)) # 리스트 정수형으로 변환(원래 문자열이였음)
        
        buffer = inputs[:5]
        print("최초의 버퍼의 상황 : {}".format(buffer))
        del inputs[0:5]
        buffer.sort()
        print("sort 한 버퍼의 상황 : {}".format(buffer))
        File_content.append(buffer[0])
        print("최초의 잠시 파일 콘텐츠 현재 상황 : {}".format(File_content))
        del buffer[0]
        print("----------------------------------------------\n")
        
        listnum = 0

        while 1 : 

            if listnum == 0 :
                listnum += 1
                pass
                
            try :
                buffer.append(inputs[0])
                buffer.sort()
                del inputs[0]
                
            except :
                buffer.sort()

            try : 
                if buffer[buffer_start_number] >= File_content[-1] :
                    File_content.append(buffer[buffer_start_number])
                    print("버퍼의 1 상황 : {} 버퍼의 시작점 : {}".format(buffer, buffer_start_number))
                    del buffer[buffer_start_number]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                
                elif buffer[buffer_start_number] < File_content[-1] :
                    buffer_start_number += 1
                    if buffer_start_number < 5 :
                        File_content.append(buffer[buffer_start_number])
                        print("버퍼의 1 상황 : {} 버퍼의 시작점 : {}".format(buffer, buffer_start_number))
                        del buffer[buffer_start_number]
                        print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                    
                    elif buffer_start_number == 5 :
                        buffer_start_number = 0
            except : 
                try :
                    File_content.append(buffer[0])
                    print("버퍼의 2 상황 : {} 버퍼의 시작점 : {}".format(buffer, buffer_start_number))
                    del buffer[0]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                except : 
                    break


                        
        # 파일 리스트화 및 정수형으로 변환 + 문자열로 변환
        File_content2 = list(File_content)

        w = 0 # insert를 하게되면 자연스럽게 들어있는 갯수가 증가한다. 이를 위해 w라는 변수를 사용.
        for i in range(1,len(File_content)) :
            w += 1
            if File_content[i] < File_content[i-1] :
                File_content2.insert(w,"\n")
                w += 1
            
        
        print(File_content2)
        
        
        FW = File_content2.count("\n") + 1

        print("\n----------------------------------------------\n")
        print("현재 러닝의 상태는 \n{}입니다.".format(File_content2))
        File_content = list(map(str, File_content))
        File_content2 = list(map(str, File_content2))
        
        
        FW = str(FW)
        
        # 파일 쓰기 부분.
        Test2.write(FW)
        Test2.write("\n")
        for i in range(len(File_content2)) :
            Test2.writelines(File_content2[i] + " ")

        Test2.write("\n")

        

Test1.close()
Test2.close()
