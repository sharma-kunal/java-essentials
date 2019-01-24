import java.util.*;
public class binary_search {
  public static int search(int[] arr, int l, int r, int x) {
    while(l<=r) {
      int m = (l+r)/2;
      if(arr[m] == x) return m;
      if(arr[m] < x) l=m+1;
      else r=m-1;
    }
  return -1;
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter length of array: ");
    int length = scan.nextInt();
    int[] arr = new int[length];
    for(int i=0;i<length;i+=1) {
      System.out.printf("Enter element at index ",i);
      arr[i] = scan.nextInt();
    }
  System.out.print("Enter element to search for: ");
  int x = scan.nextInt();
  System.out.println(search(arr, 0, arr.length-1, x));
  }
}
