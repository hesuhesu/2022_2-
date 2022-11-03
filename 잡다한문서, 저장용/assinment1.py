import os
import sys

'''
먼저 실행해보시는게 이해하기 더 쉬울 수 있습니다!
주석이 너무 길어서 가독성이 떨어집니다..!
그만큼 상세 설명 하였으므로 프로그램에 문제는 없다고 생각합니다.
'''

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
path2 = os.path.dirname(os.path.abspath(__file__))
path3 = os.getcwd()

a1 = '{}\\replacement_input.txt'.format(path)  # 추가로 파일 이름까지 입력하면 준비 완료입니다.
a2 = '{}\\replacement_output.txt'.format(path)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

ab = int(Test1.readline())         # replacement_input.txt 파일에서 계산을 반복할 횟수를 불러옵니다(줄 갯수).

listnum = 0
Anum = 1 # 그냥 몇 번째 리스트인지 알려주는 정수형 변수입니다.
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
        print(inputs)  # # 홀수 번 일 때 실행됩니다. 리스트를 불러옵니다. n 번째 줄 리스트.
        print("\n----------------------------------------------\n")
        buffer = []         # 체킹 버퍼
        File_content = []   # 계속 저장되는 part 교재에서는 끊어저 저장되지만 한 번에 저장하여 끊는 식으로 진행합니다.
        buffer_start_number = 0 # 동결되고 난 후의 시작번호
        
        inputs = list(map(int, inputs)) # 리스트 정수형으로 변환하여 인수들의 비교가 쉽게 합니다.
        
        buffer = inputs[:5]
        print("최초의 버퍼의 상황 : {}".format(buffer))
        del inputs[0:5]
        buffer.sort()
        print("sort 한 버퍼의 상황 : {}".format(buffer))
        File_content.append(buffer[0])
        print("최초의 잠시 파일 콘텐츠 현재 상황 : {}".format(File_content))
        del buffer[0] # 추가하고 새로운 준비를 위해 삭제합니다.
        print("----------------------------------------------\n")
        
        listnum = 0

        while 1 : 

            if listnum == 0 : # 처음 시작할 때 살짝 꼬여서 임의로 추가한 조건문입니다. 1이 추가되면서 더 이상 쓸모없습니다.
                listnum += 1
                pass
            

            # 예외 처리입니다. 반드시 inputs가 전부 소진되어 에러가 날 예정이므로 이후에는 버퍼의 오름차순만 정리합니다.
            try : 
                buffer.append(inputs[0])
                buffer.sort()             
                # sort를 하는 이유는 replacement selection의 buffer는 크기 비교 후 최소의 값 도출입니다. 그런 의미에서 부분부분 값 고정보다는 sort후 동결을 따라하는 식이 낫다고 판단했습니다.
                del inputs[0]
                
            except :
                buffer.sort()

    
            try : 

                if buffer[buffer_start_number] >= File_content[-1] : # 이 부분은 곧 예외처리로 없어질 부분입니다. buffer[buffer_start_number]가 없어서 오류가 뜨는 경우가 발생합니다.
                    File_content.append(buffer[buffer_start_number])
                    print("버퍼의 1 상황 : {} 버퍼의 시작점 : {}\n".format(buffer, buffer_start_number)) # 실행시키면 sort된 부분에서 설계되는 부분을 인지할 수 있습니다 0~4까지의 숫자를 채우고 0으로 다시 넘어갑니다.
                    del buffer[buffer_start_number]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                
                elif buffer[buffer_start_number] < File_content[-1] : # 파일 콘텐츠가 진행중인 run의 제일 큰 값보다 버퍼 시작점이 작을 때입니다.
                    
                    buffer_start_number += 1 # 1씩 더해줌으로써 버퍼의 시작 위치를 올려갑니다. 시작 위치가 올라간다는 뜻은 앞의 값들은 동결된다는 뜻입니다.
                    
                    if buffer_start_number < 5 : # 아직 버퍼의 시작이 5보다 작을 때 입니다. 
                        File_content.append(buffer[buffer_start_number])
                        print("버퍼의 1 상황 : {} 버퍼의 시작점 : {}\n".format(buffer, buffer_start_number))
                        del buffer[buffer_start_number]
                        print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                    
                    elif buffer_start_number == 5 : # 5가 되는 순간 다시 0으로 변하고, 자연스럽게 반복을 이어갑니다. 이는 곧 모든 버퍼가 동결되었고 다음 라인으로 넘어간다는 의미입니다.
                        buffer_start_number = 0
                        File_content.append(buffer[buffer_start_number])
                        print("버퍼의 1 상황 : {} 버퍼의 시작점 : {}\n".format(buffer, buffer_start_number))
                        del buffer[buffer_start_number]
                        print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
            
            except :  # 예외 사항에 또 예외를 두었습니다. 2가지 예외 사항이 있습니다.

                try :
                    File_content.append(buffer[0]) # buffer[buffer_start_number]가 없는 값일 때 시도됩니다. 1차 예외이고, 이후 예외는 107번 줄에 기입했습니다.
                    print("버퍼의 2 상황 : {} 버퍼의 시작점 : {}\n".format(buffer, buffer_start_number)) 
                    # 실행 시 버퍼 출력 설명문을 보면 "버퍼의 2 상황"으로 바뀐걸 알 수 있습니다. 이 때부턴 buffer_start_number은 멈추고 남은 값들을 오름차순으로 넣습니다.
                    del buffer[0]
                    print("파일 콘텐츠의 현재 상황 : {}".format(File_content))
                except : 
                    break # 더 이상 버퍼에 값이 없습니다. 반복문을 종료합니다.


                        
        # 파일 리스트화 및 정수형으로 변환 + 문자열로 변환
        File_content2 = list(File_content)

        w = 0   # insert를 하게되면 자연스럽게 리스트에 들어있는 요소의 개수가 증가합니다. 충당하기 위해 w라는 변수를 사용.
        for i in range(1,len(File_content)) :
            w += 1
            if File_content[i] < File_content[i-1] :
                File_content2.insert(w,"\n")
                w += 1
            
        
        print(File_content2)
        
        
        FW = File_content2.count("\n") + 1  # 1을 추가한 이유는 "\n" 할 때마다 1줄씩 추가인데, 처음 시작이 0이기 때문입니다.

        print("\n----------------------------------------------\n")
        print("현재 러닝의 상태는 \n{}입니다.".format(File_content2))
        
        # 중요 컨텐츠를 문자열로 변경
        File_content = list(map(str, File_content))
        File_content2 = list(map(str, File_content2))
        FW = str(FW)        
        
        # 파일 쓰기 부분.
        Test2.write(FW)
        Test2.write("\n")
        for i in range(len(File_content2)) :
            Test2.writelines(File_content2[i] + " ") # 리스트를 한 칸씩 띄워서 읽습니다. "\n" 덕분에 자연스럽게 줄바꿈 됩니다.

        Test2.write("\n")

        

Test1.close()
Test2.close() # 마무리 파일 입력 후 닫기.

# pyinstaller --onefile [파일명].py

path = os.getcwd()
print(path + "\\replacement_input.txt")
