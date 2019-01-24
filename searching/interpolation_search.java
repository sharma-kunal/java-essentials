import java.util.*;
public class interpolation_search {
  public static int search(int[] arr, int l, int h, int x) {
    while(l<=h) {
      int p = l + (((h-l)/(arr[h]-arr[l]))*(x-arr[l]));
      if(arr[p] == x) return p;
      if(arr[p] < x) l=p+1;
      else h=p-1;
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
