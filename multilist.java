import java.util.*;
public class multilist {
  public static class Detail {
    String name;
    String branch;
    Detail next;
    public Detail(String name, String branch) {
      this.name = name;
      this.branch = branch;
      next = null;
    }
  }
  public static class Category {
    int category;
    Detail next;
    Category down;
    public  Category(int category) {
      this.category = category;
      next = null;
      down = null;
    }
    static Category head;
    static Category flag;
    public static Category add_category(int category, Category head) {
      if(head==null) {head = new Category(category); return head;}
      Category temp = new Category(category);
      flag = head;
      while(flag.down!=null) {
        flag = flag.down;
      }
      flag.down = temp;
      return head;
    }

    public static Category add_detail(int category, String name, String branch, Category head) {
      Detail temp = new Detail(name, branch);
      if(head==null) {
        head = new Category(category);
        head.next = temp;
        return head;
      }
      flag = head;
      while(flag.category!=category) {
        flag = flag.down;
      }
      if(flag.next==null) {flag.next = new Detail(name, branch); return head;}
      Detail dflag = flag.next;
      while(dflag!=null) {
        dflag = dflag.next;
      }
      dflag = temp;
      return head;
    }

    public static void display(Category head) {
      flag = head;
      while(flag!=null) {
        System.out.println(flag.category);
        Detail dflag = flag.next;
        while(dflag!=null) {
          System.out.println();
          System.out.print(dflag.name + " " + dflag.branch);
          dflag = dflag.next;
        }
        flag = flag.down;
      }
    }
  }
  public static void main(String[] args) {
    Category head = new Category(1);
    head = Category.add_category(2, head);
    head = Category.add_category(3, head);
    Category.display(head);
    head = Category.add_detail(1, "kunal", "cse", head);
    head = Category.add_detail(2, "sushen", "cse", head);
    head = Category.add_detail(3, "aditya", "cse", head);
    head = Category.add_detail(1, "tt", "cse", head);
    Category.display(head);
  }
}
