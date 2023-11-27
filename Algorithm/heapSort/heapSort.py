import os, sys

def down_heap(array, index, n):
        left_child = 2 * index
        right_child = 2 * index + 1
        bigger = index

        if left_child <= n and array[left_child] > array[bigger]:
            bigger = left_child

        if right_child <= n and array[right_child] > array[bigger]:
            bigger = right_child

        if bigger != index:
            array[index], array[bigger] = array[bigger], array[index]
            down_heap(array, bigger , n)

def heap_sort(array):
    n = len(array) - 1 # index 0은 2*i 계산을 위해 임의 숫자 0 삽입
    
    # Heap construction (BuildHeap)
    for i in range(n // 2, 0, -1):
        down_heap(array, i, n)

    # Sorting
    for i in range(n, 0, -1):
        array[i], array[1] = array[1], array[i]
        down_heap(array, 1, i-1)

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
read_path = '{}\\input.txt'.format(path)
write_path = '{}\\output.txt'.format(path)

Test1 = open(read_path, 'r', encoding = 'utf8')
Test2 = open(write_path, 'w', encoding = 'utf8')

result = []
result.append("Nan")
while 1 :
    checkList = Test1.readline()
    if (len(checkList) == 0):
        break
    checkList = int(checkList)
    result.append(checkList)

heap_sort(result)

print("\nheap sort : \n")

for i in range(1,len(result)) :
    print(result[i])
    Test2.write(str(result[i]))
    Test2.write("\n")

Test1.close()
Test2.close()