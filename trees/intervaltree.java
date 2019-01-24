import java.util.*;
class Node {
  int[] i = new int[2];
  int max;
  Node left, right;
  public Node(int[] arr) {
    i[0] = arr[0];
    i[1] = arr[1];
    max = arr[1];
    left = right = null;
  }
}

class intervalTree {
  public static int[] overlap = new int[2];
  public static Node build(Node root, int[] i) {
    if(root == null) {
      return new Node(i);
    }
    else if(i[0] < root.i[0]) {
      root.left = build(root.left, i);
    }
    else {
      root.right = build(root.right, i);
    }
    if(i[1] > root.max) {
      root.max = i[1];
    }
    return root;
  }

  public static void inOrder(Node root) {
    if(root == null) return;
    inOrder(root.left);
    System.out.printf("Interval: %d - %d\n", root.i[0], root.i[1]);
    //System.out.println();
    System.out.printf("max = %d\n", root.max);
    //System.out.println();
    inOrder(root.right);
  }

  public static boolean overlap(Node root, int a, int b) {
    if(root == null) return false;
    if(root.i[0] <= a && b <= root.i[1]) {
      overlap[0] = root.i[0];
      overlap[1] = root.i[1];
      return true;
    }
    int mid = (root.i[0] + root.i[1])/2;
    if(root.left != null && root.left.max >= a)
      return overlap(root.left, a, b);
    else
      return overlap(root.right, a, b);
  }

  public static void main(String[] args) {
    Node root = null;
    //int[][] arr = {{17, 19}, {21, 24}, {30, 35}, {5, 8}, {20, 30}, {4, 8}, {24, 27}};
    int[][] arr = {{15, 20}, {10, 30}, {17, 19},
        {5, 20}, {12, 15}, {30, 40}};
    for(int i=0;i<arr.length;i+=1) {
      root = build(root, arr[i]);
    }
    inOrder(root);
    if(overlap(root, 6, 7)) {
        System.out.print(overlap[0] + "-" + overlap[1]);
        //System.out.println("Overlap");
    }
    else {
      System.out.println("No overlap");
    }
  }
}
