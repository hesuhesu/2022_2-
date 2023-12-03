import sys, os

class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, node1, node2, weight):
        if node1 in self.graph:
            self.graph[node1].append((node2, weight))
        else:
            self.graph[node1] = [(node2, weight)]

        if node2 in self.graph:
            self.graph[node2].append((node1, weight))
        else:
            self.graph[node2] = [(node1, weight)]

def prim_mst(graph, start_node):
    visited = set()
    visited_all = [start_node]
    mst = []
    visited.add(start_node)  # 시작 노드를 방문 처리

    while len(visited) < len(graph.graph):
        min_edge = None
        for node in visited:
            for neighbor, weight in graph.graph[node]:
                if neighbor not in visited and (min_edge is None or weight < min_edge[2]):
                    min_edge = (node, neighbor, weight)

        if min_edge is not None:
            node1, node2, weight = min_edge
            mst.append((node1, node2, weight))
            visited.add(node2)
            visited_all.append(node2)

    return mst, visited_all

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
read_path = '{}\\input.txt'.format(path)
write_path = '{}\\output.txt'.format(path)

Test1 = open(read_path, 'r', encoding = 'utf8')
Test2 = open(write_path, 'w', encoding = 'utf8')

graph = Graph()
listA = []
node_count = 0 # 노드 개수.

while 1 :
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    if (len(checkList) == 0):
        break
    listA.append([checkList[0], checkList[1]])
    node_count += 1

for i in range(node_count):
    for j in range(node_count):
        if i == j :
            continue
        else :
            graph.add_edge(i,j,(abs(listA[i][0] - listA[j][0])**2 + abs(listA[i][1] - listA[j][1])**2)**(1/2))

mst, visited = prim_mst(graph, 0)

print("방문 순서 : \n[", end="")
Test2.write("방문 순서 : \n[")
for i in range(len(visited)):
    if (i == len(visited)-1):
        print(visited[i], end = "")
        Test2.write(f"{visited[i]}")
        continue  
    print(visited[i], end = ", ")
    Test2.write(f"{visited[i]}, ")

print("]\n")
Test2.write("]\n\n")

result = 0
for i in range(1,len(visited)):
    num = (abs(listA[visited[i]][0] - listA[visited[i-1]][0])**2 + abs(listA[visited[i]][1] - listA[visited[i-1]][1])**2)**(1/2)
    result += num
    print(f"{visited[i-1]}와 {visited[i]}의 거리 = {num}")
    Test2.write(f"{visited[i-1]}와 {visited[i]}의 거리 = {num}\n")

num = (abs(listA[visited[-1]][0] - listA[visited[0]][0])**2 + abs(listA[visited[-1]][1] - listA[visited[0]][1])**2)**(1/2)
result += num
print(f"{visited[-1]}와 {visited[0]}의 거리 = {num}\n")
print(f"방문 거리 : {result}")
Test2.write(f"{visited[-1]}와 {visited[0]}의 거리 = {num}\n")
Test2.write(f"\n방문 거리 : {result}")

Test1.close()
Test2.close()