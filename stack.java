import java.util.*;

class stack {
  static public class myStack {
    int length;
    int[] stack;
    int top;
    public myStack(int l) {
      length = l;
      stack = new int[length];
      top = 0;
    }
    void push(int num) {
      if (top >= length) {
        System.out.println("Overflow Conditon");
        System.exit(0);
      }
      stack[top] = num;
      top+=1;
    }
    void pop() {
      if (top==-1) {
        System.out.println("Can't pop. Stack is empty");
        System.exit(0);
      }
      top-=1;
    }
    void print_stack() {
      for(int i=0;i<top;i+=1) {
        System.out.print(stack[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    int l;
    Scanner scan = new Scanner(System.in);
    l = scan.nextInt();
    myStack s = new myStack(l);
    s.push(1);
    s.push(2);
    s.push(3);
    s.print_stack();
    s.pop();
    s.print_stack();
  }
}
