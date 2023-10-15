import os, sys

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

    return mst

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
read_path = '{}\\input_primAlgorithm.txt'.format(path)
write_path = '{}\\output_primAlgorithm.txt'.format(path)

Test1 = open(read_path, 'r', encoding = 'utf8')
Test2 = open(write_path, 'w', encoding = 'utf8')

graph = Graph()
start_node = int(Test1.readline())  # 시작 노드 선택
while 1 :
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    if (len(checkList) == 0):
        break
    graph.add_edge(checkList[0], checkList[1], checkList[2])


mst = prim_mst(graph, start_node)

print("모든 노드들과 그 관계 : ", graph.graph)
print("최소 신장 트리:")
for edge in mst:
    node1, node2, weight = edge
    print(f"({node1}, {node2}, {weight})")
    Test2.write(f"({node1}, {node2}, {weight})\n")

Test1.close()
Test2.close()