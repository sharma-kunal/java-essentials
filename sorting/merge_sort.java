import java.util.*;
public class merge_sort {
  public static void merge(int[] arr, int l, int m, int r) {
    int l1 = m-l+1;
    int l2 = r-m;
    int[] left = new int[l1];
    int[] right = new int[l2];
    for(int i=0;i<l1;i+=1) {
      left[i] = arr[l+i];
    }
    for(int j=0;j<l2;j+=1) {
      right[j] = arr[m+j+1];
    }
    int i=0,j=0;
    int k=l;
    while(i<l1 && j<l2) {
      if(left[i]<=right[j]) {
        arr[k] = left[i];
        k+=1;
        i+=1;
      }
      else {
        arr[k] = right[j];
        k+=1;
        j+=1;
      }
    }
    while(i<l1) {
      arr[k] = left[i];
      k+=1;
      i+=1;
    }
    while(j<l2) {
      arr[k] = right[j];
      k+=1;
      j+=1;
    }
  }

  public static void mergesort(int[] arr, int l, int r) {
    if(l<r) {
      int m = (l+r)/2;
      mergesort(arr, l, m);
      mergesort(arr, m+1, r);
      merge(arr, l, m, r);
    }
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

      mergesort(arr, 0, arr.length-1);

      for(int i=0;i<length;i+=1) {
        System.out.print(arr[i] + " ");
      }
  }
 }
