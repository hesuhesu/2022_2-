import os
import sys



path = (os.path.sep.join(sys.argv[0].split(os.path.sep)[:-1]))
path2 = os.path.dirname(os.path.abspath(__file__))
path3 = os.getcwd()

print(path)
print(path3)

a1 = '{}\\bst_input.txt'.format(path)  # 추가로 파일 이름까지 입력하면 준비 완료입니다.
a2 = '{}\\bst_output.txt'.format(path)

Test1 = open(a1, 'r', encoding = 'utf8')
Test2 = open(a2, 'w', encoding = 'utf8')

ab = int(Test1.readline())         # replacement_input.txt 파일에서 계산을 반복할 횟수를 불러옵니다(줄 갯수).


class Node(object):
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

class BinarySearchTree(object):

    level = 0

    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self._insert_value(self.root, data)
        return self.root is not None

    def _insert_value(self, node, data):
        if node is None:
            node = Node(data)
        else:
            if data <= node.data:
                node.left = self._insert_value(node.left, data)
            else:
                node.right = self._insert_value(node.right, data)
        return node
    
    def find(self, key):
        return self._find_value(self.root, key)

    def _find_value(self, root, key):
        if root is None or root.data == key:
            return root is not None
        elif key < root.data:
            return self._find_value(root.left, key)
        else:
            return self._find_value(root.right, key)

    def delete(self, key):
        self.root, deleted = self._delete_value(self.root, key)
        return deleted

    def _delete_value(self, node, key):
        if node is None:
            return node, False

        deleted = False
        if key == node.data:
            deleted = True
            if node.left and node.right:
                # replace the node to the leftmost of node.right
                parent, child = node, node.right
                while child.left is not None:
                    parent, child = child, child.left
                child.left = node.left
                if parent != node:
                    parent.left = child.right
                    child.right = node.right
                node = child
            elif node.left or node.right:
                node = node.left or node.right
            else:
                node = None
        elif key < node.data:
            node.left, deleted = self._delete_value(node.left, key)
        else:
            node.right, deleted = self._delete_value(node.right, key)
        return node, deleted

listnum = 0
Anum = 1 # 그냥 몇 번째 리스트인지 알려주는 정수형 변수입니다.
for i in range(ab) :

    print("################################################################################################")
    list1 = int(Test1.readline())
    print("\n----------------------------------------------")
    print("<{}번째> 이진트리 최초 갯수는 {}입니다.".format(Anum,list1))
    Anum += 1
    
    list2 = Test1.readline() # insert 전체 삽입
    list2 = list2.split()
    list2 = list(map(int, list2)) # 리스트 정수형으로 변환하여 인수들의 비교가 쉽게 합니다.
    print("최초 모든 요소의 리스트 : {}".format(list2))

    
    '''
    여기에 대략적인 BST 구현
    '''
    
    bst = BinarySearchTree()
    for i in list2 :
        bst.insert(i)
    
    bst

    list3 = int(Test1.readline()) # 검색할 키의 개수 1차
    print("----------------------------------------------")
    print("1. 1차 검색 개수는 {}개입니다(output에 저장됨)".format(list3))

    list4 = Test1.readline()
    list4 = list4.split()
    list4 = list(map(int, list4)) # 검색할 키가 순서대로 스페이스로 구분되어 표기
    print("1차 검색할 키의 요소 리스트 : {}".format(list4))


    list5 = int(Test1.readline()) # 삭제할 키의 개수
    print("----------------------------------------------")
    print("2. 삭제할 갯수는 {}개입니다.".format(list5))

    list6 = Test1.readline()
    list6 = list6.split()
    list6 = list(map(int, list6)) # 삭제할 키가 순서대로 스페이스로 구분되어 표기
    print("삭제할 키의 요소 리스트 : {}".format(list6))


    list7 = int(Test1.readline()) # 검색할 키의 개수 2차
    print("----------------------------------------------")
    print("3. 2차 검색 개수는 {}개입니다(output에 저장됨)".format(list3))

    list8 = Test1.readline()
    list8 = list8.split()
    list8 = list(map(int, list8)) # 검색할 키가 순서대로 스페이스로 구부되어 표기
    print("2차 검색할 키의 요소 리스트 : {}".format(list8))
       
            

    # 중요 컨텐츠를 문자열로 변경
    # 예시 File_content = list(map(str, File_content))

    # 예시 FW = str(FW)        
        
    # 파일 쓰기 부분.
    
        

        

Test1.close()
Test2.close() # 마무리 파일 입력 후 닫기.

# pyinstaller --onefile [파일명].py
