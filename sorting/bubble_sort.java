import java.util.*;
public class bubble_sort {
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
      for(int j=0;j<length-i-1;j+=1) {
        if(arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    for(int i=0;i<length;i+=1) {
      System.out.print(arr[i] + " ");
    }
  }
}
