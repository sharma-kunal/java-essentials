import java.util.*;
class test {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(i);
		int num = 0;
		int x;
		while(i>0) {
			x = i%10;
			num = num*10 + x;
			i = i/10;
		}
		System.out.println(num);
	}
}
