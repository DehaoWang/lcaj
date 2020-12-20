class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
def inorder_traversal(root):
    if root == None:
        return
    else:
        inorder_traversal(root.left)
        print(root.val)
        inorder_traversal(root.right)
        
def preorder_traversal(root):
    if root == None:
        return
    else:
        print(root.val)
        preorder_traversal(root.left)
        preorder_traversal(root.right)