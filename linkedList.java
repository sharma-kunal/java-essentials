import java.util.*;
public class linkedList{
  public static class Node {
    int data;
    Node next;
    public Node(int d) {
      data = d;
      next = null;
    }
  }
  public static class Linkedlist {
    Node head;
    Node flag;
    public Linkedlist() {
      head = null;
    }

    public void add(int data) {
      if(head == null){ head = new Node(data); return;}

      Node temp = new Node(data);
      flag = head;
      while(flag.next!=null) {
        flag = flag.next;
      }
      flag.next = temp;
    }
    public int length() {
      int l = 0;
      flag = head;
      while(flag!=null) {
        flag=flag.next;
        l+=1;
      }
      return l;

    }
    public void display() {
      flag = head;
      if(head==null) {
        System.out.println("list is empty");
      }
      while(flag!=null) {
        System.out.print(flag.data + " ");
        flag=flag.next;
      }
      System.out.println();
    }
    public void remove_by_index(int i) {
      if(i==0) {
        head = null;
        return;
      }
      if(i>=length()) {
        System.out.println("Index out of range");
        System.exit(0);
      }
      flag=head;
      int count=0;
      while(count!=i-1) {
        flag=flag.next;
        count+=1;
      }
      Node temp = flag.next.next;
      flag.next = temp;
    }
    public void remove_by_data(int d) {
      flag = head;
      if(head.data==d) {
        head=flag.next;
        return;
      }
      while(flag.next.data != d) {
        flag = flag.next;
        if(flag.next==null) {
          System.out.println("Data not in list");
          System.exit(0);
        }
      }
      Node temp = flag.next.next;
      flag.next = temp;
    }
  }
  public static void main(String args[]) {
    Linkedlist l = new Linkedlist();
    l.add(1);
    l.add(2);
    l.add(3);
    l.add(4);
    l.add(5);
    l.display();
    l.remove_by_index(7);
    l.display();
  }
}
