import java.util.*;
class binarySearchTree {
  class Node {
    int data;
    Node left,right;
    public Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  Node root;
  public binarySearchTree() {
    root = null;
  }

  void insert(int data) {
    root = insertR(root, data);
  }

  Node insertR(Node root, int data) {
    if(root == null) {
      root = new Node(data);
      return root;
    }
    if(data < root.data) {
      root.left = insertR(root.left, data);
    }
    else {
      root.right = insertR(root.right, data);
    }
    return root;
  }

  void inorder() {
    inorderR(root);
  }
  void inorderR(Node root) {
    if(root!=null) {
      inorderR(root.left);
      System.out.println(root.data);
      inorderR(root.right);
    }
  }

  void delete(int data) {
    root = deleteR(root, data);
  }

  Node deleteR(Node root, int data) {
    if(root==null) return root;
    if(data<root.data) root.left = deleteR(root.left, data);
    else if(data>root.data) root.right = deleteR(root.right, data);

    else {
      if(root.left == null) return root.right;
      else if(root.right == null) return root.left;
      root.data = minV(root.right);
      root.right = deleteR(root.right, root.data);
    }
    return root;
  }

  int minV(Node root) {
    int min = root.data;
    while(root.left!=null) {
      min = root.left.data;
      root = root.left; 
    }
    return min;
  }
  public static void main(String[] args) {
    binarySearchTree tree = new binarySearchTree();
    tree.insert(50);
    tree.insert(30);
    tree.insert(20);
    tree.insert(40);
    tree.insert(70);
    tree.insert(60);
    tree.insert(80);
    tree.inorder();
    tree.insert(10);
    tree.inorder();
    tree.delete(20);
    tree.inorder();
  }
}
