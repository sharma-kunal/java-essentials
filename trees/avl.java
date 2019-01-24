import java.util.*;
public class avl {
  class Node {
    int key;
    int height;
    Node left,right;
    public Node(int key) {
      this.key = key;
      height = 1;
      left = right = null;
    }
  }
}
