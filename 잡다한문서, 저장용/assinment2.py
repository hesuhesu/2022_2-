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
        line = 1               # 줄 갯수를 의미.
        buffer_start_number = 0 # 동결되고 난 후의 시작번호

        outputLine1.append(line) # run의 시작.
        
        inputs = list(map(int, inputs)) # 리스트 정수형으로 변환(원래 문자열이였음)
        
        buffer = inputs[:5]
        print("최초의 버퍼의 상황 : {}".format(buffer))
        del inputs[0:5]
        buffer.sort()
        print("sort 한 버퍼의 상황 : {}".format(buffer))
        File_content.append(min(buffer))
        print("최초의 잠시 파일 콘텐츠 현재 상황 : {}".format(File_content))
        del buffer[0]
        
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
                    print("버퍼의 상황 : {}".format(buffer))
                    del buffer[buffer_start_number]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                
                elif buffer[buffer_start_number] < File_content[-1] :
                    buffer_start_number += 1
                    if buffer_start_number < 5 :
                        File_content.append(buffer[buffer_start_number])
                        print("버퍼의 상황 : {}".format(buffer))
                        del buffer[buffer_start_number]
                        print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                    
                    else :
                        line += 1
                        outputLine2.append(File_content)
                        File_content = []
                        buffer_start_number = 0
            except : 
                try :
                    if buffer[-1] >= File_content[-1] :
                        File_content.append(buffer[0])
                        print("버퍼의 상황 : {}".format(buffer))
                        del buffer[0]
                        print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                
                    elif buffer[-1] < File_content[-1] :
                        buffer_start_number += 1
                        if buffer_start_number < 5 :
                            File_content.append(buffer[0])
                            print("버퍼의 상황 : {}".format(buffer))
                            del buffer[0]
                            print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                    
                        else :
                            line += 1
                            outputLine2.append(File_content)
                            File_content = []
                            buffer_start_number = 0
                except : 
                    break

                        
                    
            

            
            '''
            if (buffer[buffer_start_number] >= File_content[-1]):
                File_content.append(buffer[buffer_start_number])
                print("버퍼의 상황 : {}".format(buffer))
                del buffer[buffer_start_number]
                print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                
            elif buffer[buffer_start_number] < File_content[-1] :
                buffer_start_number += 1
                if buffer_start_number < 5 :
                    File_content.append(buffer[buffer_start_number])
                    print("버퍼의 상황 : {}".format(buffer))
                    del buffer[buffer_start_number]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                    
                else :
                    line += 1
                    outputLine2.append(File_content)
                    File_content = []
                    buffer_start_number = 0
            '''
        
        
                
        
        

                
            
        

Test1.close()
Test2.close()
