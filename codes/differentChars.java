// Return an array of different characters in a string.
import java.util.*;
public class differentChars {

  public static boolean count(char c, ArrayList<Character> temp) {
    for(int i=0;i<temp.size();i+=1){
      if(temp.get(i)==c) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter string");
    String str = scan.nextLine();
    ArrayList<Character> x = new ArrayList<Character>();
    x.add(str.charAt(0));
    for(int i=1;i<str.length();i+=1) {
      if(count(str.charAt(i), x)) x.add(str.charAt(i));
    }
    System.out.println(x);
  }
}
