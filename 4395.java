import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			int sub = Y - X, num = 1;
			while(num * num < sub) num += 1;
			
			if(sub >= num * num - num + 1) System.out.println(2 * num - 1);
			else System.out.println(2 * num - 2);
		}
	}
}