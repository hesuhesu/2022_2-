import os, sys, time

start_time = time.time()

def dijkstra(DP, num_nodes, start):
    unprocessed_nodes = set(range(num_nodes))

    while unprocessed_nodes:
        min_node = min(unprocessed_nodes, key=lambda v: DP[start][v])
        unprocessed_nodes.remove(min_node)

        for neighbor in range(num_nodes):
            if DP[start][neighbor] > DP[start][min_node] + DP[min_node][neighbor]:
                DP[start][neighbor] = DP[start][min_node] + DP[min_node][neighbor]

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
read_path = '{}\\input_dijkstraAlgorithm.txt'.format(path)
write_path = '{}\\output_dijkstraAlgorithm.txt'.format(path)

Test1 = open(read_path, 'r', encoding = 'utf8')
Test2 = open(write_path, 'w', encoding = 'utf8')

node_count = int(Test1.readline())  # 노드 개수

max_int = float('inf') # sys.maxsize
cityList = []
DP = [[max_int] * (node_count) for _ in range(node_count)]
for i in range(node_count):
    DP[i][i] = 0
    cityList.append(Test1.readline().strip())

while 1:
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    if (len(checkList) == 0):
        break
    DP[checkList[0]][checkList[1]] = checkList[2]

print("\ndijkstraAlgorithm : \n")
print("         ", end = "")
Test2.write("         ")
for i in cityList:
    print("   {:<5}".format(i), end = "")
    Test2.write("   {:<5}".format(i))

print("")
Test2.write("\n")

for i in range(node_count):
    print("{:<5}".format(cityList[i]), end = "")
    Test2.write("{:<5}".format(cityList[i]))
    dijkstra(DP, node_count, i)
    for j in range(node_count):
        print("     {:<5}".format(DP[i][j]), end = "")
        Test2.write("     {:<5}".format(DP[i][j]))
    print("")
    Test2.write("\n")

end_time = time.time()
print(f"\n걸린 시간 : {end_time - start_time:.5f} sec")
Test2.write(f"\n걸린 시간 : {end_time - start_time:.5f} sec\n")

Test1.close()
Test2.close()