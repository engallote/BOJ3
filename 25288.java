import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		
		StringBuilder sb = new StringBuilder();
		
		while(--N >= 0) sb.append(str);
		
		System.out.println(sb.toString());
	}
}