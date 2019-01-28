import java.util.*;
import java.lang.Math;
class segmentTree {
  static public int[] tree;
  public segmentTree(int length) {
    tree = new int[2*length+1];
  }

  public static int build(int[] a, int start, int end, int i) {
    if(start == end) {
      tree[i] = a[start];
      return a[start];
    }
    else {
      int mid = (start+end)/2;
      tree[i] = Math.min(build(a, start, mid, 2*i+1),build(a, mid+1, end, 2*i+2));
    }
    return tree[i];
  }

  public static void print() {
    for(int i=0;i<tree.length;i+=1) {
      System.out.print(tree[i]+" ");
    }
    System.out.println();
  }

  public static int update(int start, int end, int a, int b, int i) {
    if(a > end || b < start){
      return Integer.MAX_VALUE;
    }
    if(start == end && (start >= a || start <= b)) {
      tree[i]+=1;
      return tree[i];
    }
    int mid = (start+end)/2;
    update(start, mid, a, b, 2*i+1);
    update(mid+1, end, a, b, 2*i+2);
    tree[i] = Math.min(tree[2*i+1], tree[2*i+2]);
    return tree[i];
  }
}

class main {
  public static void main(String[] args) {
    int[] a = {5, 8, 4, 3, 8, 6, 7};
    segmentTree s = new segmentTree(a.length);
    s.build(a, 0, a.length-1, 0);
    s.print();
    s.update(0, 6, 2, 4, 0);
    s.print();
  }
}
