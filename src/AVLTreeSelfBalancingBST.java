import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/avl-tree-set-1-insertion/

An AVL tree (Georgy Adelson-Velsky and Landis' tree, named after the inventors) is a self-balancing binary search tree.
In an AVL tree, the heights of the two child subtrees of any node differ by at most one;
if at any time they differ by more than one, rebalancing is done to restore this property.

We define balance factor for each node as :

balanceFactor = height(left subtree) - height(right subtree)
The balance factor of any node of an AVL tree is in the integer range [-1,+1]. If after any modification in the tree,
the balance factor becomes less than −1 or greater than +1, the subtree rooted at this node is unbalanced,
and a rotation is needed.


You are given a pointer to the root of an AVL tree. You need to insert a value into this tree and perform the necessary rotations to ensure that it remains balanced.

Input Format

You are given a function,

node *insert(node * root,int new_val)
{


}
'node' is defined as :

struct node
{
int val;            //value
struct node* left;  //left child
struct node* right; //right child
int ht;             //height of the node
} node;
You only need to complete the function.

Note: All the values in the tree will be distinct. Height of a Null node is -1 and the height of the leaf node is 0.



Output Format

Insert the new value into the tree and return a pointer to the root of the tree. Ensure that the tree remains balanced.

Sample Input

    3
  /  \
 2    4
       \
        5
The value to be inserted is 6.

Sample Output

    3
  /  \
 2    5
     / \
    4   6


Explanation

After inserting 6 in the tree. the tree becomes:

    3 (Balance Factor = -2)
  /  \
 2    4 (Balance Factor = -2)
       \
        5 (Balance Factor = -1)
         \
          6 (Balance Factor = 0)
Balance Factor of nodes 3 and 4 is no longer in the range [-1,1]. We need to perform a rotation to balance the tree.
This is the right right case. We perform a single rotation to balance the tree.

After performing the rotation, the tree becomes :

                              3 (Balance Factor = -1)
                            /   \
      (Balance Factor = 0) 2     5 (Balance Factor = 0)
                                / \
           (Balance Factor = 0)4   6 (Balance Factor = 0)
 */
public class AVLTreeSelfBalancingBST {
    public static void main(String args[]){
        AVLTree avlTree = new AVLTree();

        int n= 6;//7;
        List<Integer> inputlist = new ArrayList<>();
        /*
        inputlist.add(3);
        inputlist.add(4);
        inputlist.add(5);
        inputlist.add(2);
        inputlist.add(7);
        inputlist.add(9);
        inputlist.add(1);
        */
        inputlist.add(10);
        inputlist.add(20);
        inputlist.add(30);
        inputlist.add(40);
        inputlist.add(50);
        inputlist.add(25);

        for (int i = 0; i < n; i++) {
            avlTree.root =avlTree.insert(avlTree.root,inputlist.get(i));
            System.out.println(avlTree.root.val);
            System.out.println("height =" +avlTree.root.ht);
        }

        avlTree.printInorder(avlTree.root);

         /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        Time Complexity: The rotation operations (left and right rotate) take constant time as only a few pointers are being changed there.
        Updating the height and getting the balance factor also takes constant time.
        So the time complexity of AVL insert remains same as BST insert which is O(h) where h is the height of the tree. Since AVL tree is balanced, the height is O(Logn). So time complexity of AVL insert is O(Logn).

        Comparison with Red Black Tree
        The AVL tree and other self-balancing search trees like Red Black are useful to get all basic operations done in O(log n) time.
        The AVL trees are more balanced compared to Red-Black Trees, but they may cause more rotations during insertion and deletion.
        So if your application involves many frequent insertions and deletions, then Red Black trees should be preferred.
        And if the insertions and deletions are less frequent and search is the more frequent operation,
        then AVL tree should be preferred over Red Black Tree.
        */
    }
}

class Node{
    int val;	//Value
    int ht;		//Height
    Node left;	//Left child
    Node right;	//Right child
}

class AVLTree{
    Node root;
    AVLTree(){
        root = null;
    }

    public Node insert(Node node,int val) {
        if(node == null) {
            node = new Node();
            node.val = val;
            node.ht = setHeight(node);
            return node;
        }
        if(val <= node.val) {
            node.left = insert(node.left, val);
        }
        else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        int balance = height(node.left) - height(node.right);

        if(balance > 1) {
            if(height(node.left.left) >= height(node.left.right)) {
                node = rightRotation(node);
            }
            else {
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            }
        }
        else if(balance < -1) {
            if(height(node.right.right) >= height(node.right.left)) {
                node = leftRotation(node);
            }
            else {
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            }
        }
        else {
            node.ht = setHeight(node);
        }
        return node;
    }

    private Node rightRotation(Node node) {
        Node newnode = node.left;
        node.left = newnode.right;
        newnode.right = node;
        node.ht = setHeight(node);
        newnode.ht = setHeight(newnode);
        return newnode;
    }

    private Node leftRotation(Node node) {
        Node newnode = node.right;
        node.right = newnode.left;
        newnode.left = node;
        node.ht = setHeight(node);
        newnode.ht = setHeight(newnode);
        return newnode;
    }

    private int height(Node node) {
        if(node == null)
            return -1;
        else
            return node.ht;
    }

    private int setHeight(Node node) {
        if(node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

}



