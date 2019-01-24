import java.util.*;
import java.io.*;
public class radix_sort {
  public static int getMax(int[] arr) {
    int max = arr[0];
    for(int i=1;i<arr.length;i+=1) {
      if(arr[i] > max) max=arr[i];
    }
    return max;
  }
  static void countSort(int arr[], int exp)
    {
        int n = arr.length;
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixsort(int arr[])
    {
        int m = getMax(arr);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, exp);
    }
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter length of array: ");
      int length = scan.nextInt();
      int[] arr = new int[length];
      for(int i=0;i<length;i+=1) {
        System.out.printf("Enter element at index ",i);
        arr[i] = scan.nextInt();
      }
      radixsort(arr);
      for(int i=0;i<length;i+=1) {
        System.out.print(arr[i] + " ");
      }
    }
}
