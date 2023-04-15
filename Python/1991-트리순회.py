from sys import stdin

# n = int(stdin.readline().strip())
# arr = []
# for i in range(n):
#     arr.append(list(map(str, stdin.readline().strip().split())))
# arr.sort()


class Node:
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None

    # preorder traversal
    def preorder(self, n):
        if n is not None:
            print(n.item, '', end='')   # node 방문
            if n.left:
                self.preorder(n.left)   # left subtree traversal
            if n.right:
                self.preorder(n.right)  # right subtree traversal

    # inorder traversal
    def inorder(self, n):
        if n is not None:
            if n.left:
                self.preorder(n.left)   # left subtree traversal
            print(n.item,  '', end='')  # node 방문
            if n.right:
                self.preorder(n.right)  # right subtree traversal

    # postorder traversal
    def postorder(self, n):
        if n is not None:
            if n.left:
                self.preorder(n.left)   # left subtree traversal
            if n.right:
                self.preorder(n.right)  # right subtree traversal
            print(n.item, '', end='')   # node 방문


# class NodeMgmt:
#     def __init__(self, head):
#         self.current_node = None
#         self.head = head  # 루트노드
#
#     # 삽입
#     def insert(self, value):
#         self.current_node = self.head
#
#         while True:
#             if value < self.current_node.value:
#                 if self.current_node.left != None:  # 이미 가지고 있다면
#                     self.current_node = self.current_node.left  # 비교대상을 바꾼다.
#                 else:
#                     self.current_node.left = Node(value)  # 없다면 새로 만들어 연결시킨다.
#                     break
#             else:
#                 if self.current_node.right != None:  # 이미 가지고 있다면
#                     self.current_node = self.current_node.right  # 비교대상을 바꾼다.
#                 else:
#                     self.current_node.right = Node(value)
#                     break
#
#     # 이진 탐색 트리 출력
#     def search(self, value):
#         self.current_node = self.head
#
#         while self.current_node:
#             if self.current_node.value == value:  # 찾았다
#                 return True
#             elif value < self.current_node.value:
#                 self.current_node = self.current_node.left  # 비교대상 바꾸기
#             else:
#                 self.current_node = self.current_node.right  # 비교대상 바꾸기
#         return False  # 다 찾아봤는데 없다.


tree = BinaryTree()

n1 = Node('A')
n2 = Node('B')
n3 = Node('C')
n4 = Node('D')
n5 = Node('E')
n6 = Node('F')
n7 = Node('G')

tree.root = n1
n1.left = n2
n1. right = n3
n2.left = n4
n3.left = n5
n3.right = n6
n6.right = n7

print("preorder: ", end='')
tree.preorder(tree.root)
print()

print("inorder: ", end='')
tree.inorder(tree.root)
print()

print("postorder: ", end='')
tree.postorder(tree.root)
print()


