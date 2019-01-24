import java.util.*;
public class selection_sort {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter length of array: ");
    int length = scan.nextInt();
    int[] arr = new int[length];
    for(int i=0;i<length;i+=1) {
      System.out.printf("Enter element at index ",i);
      arr[i] = scan.nextInt();
    }

    for(int i=0;i<length-1;i+=1) {
      for(int j=i+1;j<length;j+=1) {
        int min = i;
        if(arr[j] < arr[min]) min = j;
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
    for(int i=0;i<length;i+=1) {
      System.out.print(arr[i] + " ");
    }
  }
}
