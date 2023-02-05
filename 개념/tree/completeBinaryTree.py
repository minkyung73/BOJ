# 완전 이진 트리


class Node:
    def __init__(self, node):
        self.node = node
        self.left = None
        self.right = None


class CompleteBinaryTree:
    def __init__(self, root):
        self.root = Node(root)
        self.current_node = None

    # tree 만들기
    def level_order_binary_tree_util(self, value):
        self.current_node = self.root
        while True:
            if value < self.current_node.value:
                if self.current_node.left is not None:
                    self.current_node = self.current_node.left
                else:
                    self.current_node.left = Node(value)
                    break
            else:
                if self.current_node.right is not None:
                    self.current_node = self.current_node.right
                else:
                    self.current_node.right = Node(value)
                    break

    # traversal =================================================
    # preorder
    def print_pre_order(self, node):
        if node is not None:
            print(node.value, end=' ')
            if node.left:
                self.print_pre_order(node.left)
            if node.right:
                self.print_pre_order(node.right)


arr = [6, 4, 8, 2, 5, 7, 9, 1, 3]

# head = Node(arr[0])
tree = CompleteBinaryTree(arr[0])

for i in range(1, len(arr)):
    tree.level_order_binary_tree_util(arr[i])
    # tree.level_order_binary_tree_util(Node(arr[i]))

tree.print_pre_order(head)


