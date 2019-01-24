import java.util.*;
public class threadedTree {
  public static class Node {
    int data;
    Node left,right;
    boolean lthread,rthread;
    public Node() {}
  }
  static Node insert(Node root, int data) {
    Node ptr = root;
    Node par = null;
    while(ptr!=null) {
      par = ptr;
      if(data < ptr.data) {
        if(ptr.lthread == false) ptr = ptr.left;
        else break;
      }

      else {
        if(ptr.rthread == false) ptr = ptr.right;
        else break;
      }
    }
    Node temp = new Node();
    temp.data = data;
    temp.lthread = true;
    temp.rthread = true;
    if(par == null) {
      root = temp;
      temp.left = null;
      temp.right = null;
    }
    else if(data < par.data) {
      temp.left = par.left;
      temp.right = par;
      par.lthread = false;
      par.left = temp;
    }
    else {
      temp.left = par;
      temp.right = par.right;
      par.rthread = false;
      par.right = temp;
    }
    return root;
  }

public static Node inorderSuccessor(Node ptr)
{
    if (ptr.rthread == true)
        return ptr.right;

    ptr = ptr.right;
    while (ptr.lthread == false)
        ptr = ptr.left;
    return ptr;
}

public static void inorder(Node root)
{
    if (root == null)
        System.out.println("Tree is empty");

    Node ptr = root;
    while (ptr.lthread == false)
        ptr = ptr.left;

    // One by one print successors
    while (ptr != null)
    {
        System.out.print(ptr.data + " ");
        ptr = inorderSuccessor(ptr);
    }
}

  public static void main(String[] args) {
    Node root = new Node();
    root = insert(root, 6);
    root = insert(root, 3);
    root = insert(root, 1);
    root = insert(root, 5);
    root = insert(root, 8);
    root = insert(root, 7);
    root = insert(root, 11);
    root = insert(root, 9);
    root = insert(root, 13);
    inorder(root);
  }

}
