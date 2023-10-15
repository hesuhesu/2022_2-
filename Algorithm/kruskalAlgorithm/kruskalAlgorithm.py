import sys, os

class Graph:
    def __init__(self, V):
        self.V = V
        self.edges = []

    def add_edge(self, node1, node2, weight):
        self.edges.append((node1, node2, weight))

def kruskal_mst(graph):
    graph.edges.sort(key=lambda edge: edge[2])  # 간선들을 가중치에 따라 정렬
    mst = []  # 최소 신장 트리를 저장할 리스트
    parent = [-1] * graph.V  # 각 노드의 부모를 나타내는 배열

    def find_parent(node): # 태초의 부모노드를 찾는다. 
        if parent[node] == -1:
            return node
        return find_parent(parent[node])

    def union(node1, node2): # 부모노드의 진위 연결.
        parent_node1 = find_parent(node1)
        parent_node2 = find_parent(node2)
        parent[parent_node1] = parent_node2

    for edge in graph.edges:
        node1, node2, weight = edge
        if find_parent(node1) != find_parent(node2):
            mst.append(edge)
            union(node1, node2)

    return mst

path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
read_path = '{}\\input_kruskalAlgorithm.txt'.format(path)
write_path = '{}\\output_kruskalAlgorithm.txt'.format(path)

Test1 = open(read_path, 'r', encoding = 'utf8')
Test2 = open(write_path, 'w', encoding = 'utf8')

V = int(Test1.readline()) # 노드 개수. txt 파일 맨 위에 존재한다(가정) 차후 입력값에 맞게 변경.
graph = Graph(V)
while 1 :
    checkList = Test1.readline().split()
    checkList = list(map(int, checkList))
    if (len(checkList) == 0):
        break
    graph.add_edge(checkList[0], checkList[1], checkList[2])

mst = kruskal_mst(graph)
print("최소 신장 트리:")
for edge in mst:
    node1, node2, weight = edge
    print(f"({node1}, {node2}, {weight})")
    Test2.write(f"({node1}, {node2}, {weight})\n")

Test1.close()
Test2.close()