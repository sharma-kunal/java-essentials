import java.util.*;

class queue {
  static public class myQueue {
    int front,rear;
    int length;
    int[] queue;
    public myQueue(int l) {
      length = l;
      queue = new int[length];
      rear = -1;
      front = -1;
    }
    void enqueue(int num) {
       if (rear == -1 && front == -1) {
         rear+=1;
         front+=1;
         queue[rear] = num;
       }
       else if (front != (rear+1)%(length-1)) {
         rear = (rear+1)%(length-1);
         queue[rear] = num;
       }
       else {
         System.out.println("Overflow");
         System.exit(0);
       }
    }
    void dequeue() {
      if(front == rear) {
         System.out.println("Queue is empty");
         System.exit(0);
      }
      else {
        front = (front+1)%(length-1);
      }
    }
    void display() {
      for (int i=front; i!=(rear+1)%(length-1);i+=(front+1)%(length-1)) {
        System.out.print(queue[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    int l;
    Scanner scan = new Scanner(System.in);
    l = scan.nextInt();
    myQueue q = new myQueue(l);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.display();
    q.dequeue();
    q.display();
  }
}
