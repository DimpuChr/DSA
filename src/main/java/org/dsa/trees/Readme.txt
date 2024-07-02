Basic Terminology
Node: A basic unit of a binary tree containing a value or data, and references to its left and right children.
Root: The topmost node in a binary tree.
Leaf: A node that does not have any children.
Internal Node: A node that has at least one child.
Subtree: A tree formed by a node and its descendants.
Height: The number of edges on the longest path from a node to a leaf.
Depth: The number of edges from the root to a node.

Full Binary Tree:
Each node has either 0 or 2 children.

Complete Binary Tree:
All levels are completely filled except possibly for the last level, which is filled from left to right.

Perfect Binary Tree:
All internal nodes have two children, and all leaf nodes are at the same level.

Balanced Binary Tree:
The height of the two subtrees of any node differ by at most one.

Degenerate (or Pathological) Tree:
Each parent node has only one child, making the tree essentially a linked list.

Skewed Binary Tree:
A tree where all nodes are either left-skewed (having only left children) or right-skewed (having only right children).



1. Size
Definition: The size of a binary tree is the total number of nodes it contains.
Calculation: For a tree rooted at r with left subtree L and right subtree R, the size can be calculated as:
Size
(
𝑇
)
=
1
+
Size
(
𝐿
)
+
Size
(
𝑅
)
Size(T)=1+Size(L)+Size(R)

where 1 accounts for the root node r.
2. Edges
Definition: An edge in a binary tree is the connection between a parent node and a child node.
Number of Edges: A binary tree with n nodes has exactly n-1 edges because every node except the root has one incoming edge from its parent.
3. Leaf Nodes
Definition: Leaf nodes (or leaves) are nodes that do not have any children, i.e., both their left and right pointers are null.
Identification: In a binary tree, a node N is a leaf if N.left == null and N.right == null.
4. Height
Definition: The height of a binary tree is the length of the longest path from the root to a leaf. It is the number of edges in the longest path from the root to a leaf.
Calculation: For a tree rooted at r with left subtree L and right subtree R, the height can be calculated as:
Height
(
𝑇
)
=
1
+
max
⁡
(
Height
(
𝐿
)
,
Height
(
𝑅
)
)
Height(T)=1+max(Height(L),Height(R))
5. Depth
Definition: The depth of a node in a binary tree is the number of edges from the root to the node.
Calculation: The depth of the root node is 0, and for any other node, it is 1 + the depth of its parent.
6. Internal Nodes
Definition: Internal nodes are nodes that have at least one child.
Identification: In a binary tree, a node N is an internal node if N.left != null or N.right != null.
7. Complete Binary Tree
Definition: A binary tree is complete if all levels are completely filled except possibly the last, which is filled from left to right.
Properties: In a complete binary tree with n nodes, the nodes are numbered sequentially starting from 1 such that for any node i:
The left child is at position 2i.
The right child is at position 2i + 1.
The parent is at position i/2.
8. Full Binary Tree
Definition: A binary tree is full if every node has either 0 or 2 children (no node has only one child).
9. Perfect Binary Tree
Definition: A binary tree is perfect if all internal nodes have exactly two children and all leaf nodes are at the same level.
Properties: A perfect binary tree of height h has:
Total nodes:

2
ℎ
+
1
−
1
2
h+1
 −1
Leaf nodes:
2
ℎ
2
h

10. Balanced Binary Tree
Definition: A binary tree is balanced if the height of the two subtrees of every node differs by no more than 1.

////////////////////////////////////////////////////////////////////////////////////////////////////////////

1. perfect BT height = 2(h+1) -1 , leaf node = 2h , internal node = 2h -1
2. Strict BT total leaf nodes N and N-1 internal nodes & No of leave nodes = No of internal nodes+1
3. No of leaf nodes = 1+ no of internal nodes with 2 childrens ( apart from root node)

//////////////////////////////////////////////////////////////////////////////////////////

Traversal methods

1. Pre Order :
    Node -> Left -> Right

    ex: we have root 5 -> left 4 - > L 2 -> 1
                       -> right 6 -> R 12

    o/p -> Node (5) -> Left 4,2,1 -> Right 6,12
    use case:
    1. used for Evaluating Math expression or making array copy
    2. serialization from String/array

2. In Order :
   Left -> Node -> Right

   Note : In Binary Search , want to print in sorted order use In order traversal

3. Post Order
   Left -> Right -> Node

   Use case:
   1. Delete elements from Binary tree
   2. Bottom up calculation of height of tree or  diameter