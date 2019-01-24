import java.util.*;
public class quick_sort {
  public static int partition(int[] arr, int l, int h) {
    int pivot = arr[h];
    int i = l-1;
    for(int j=l;j<h-1;j+=1) {
      if(arr[j]<pivot) {
        i+=1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[h];
    arr[h] = temp;
    return (i+1);
  }
  public static void quicksort(int[] arr, int l, int h) {
    if(l<h) {
      int pi = partition(arr, l, h);

      quicksort(arr, l, pi-1);
      quicksort(arr, pi+1, h);
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

    quicksort(arr, 0, arr.length-1);

    for(int i=0;i<length;i+=1) {
      System.out.print(arr[i] + " ");
    }
  }
}
