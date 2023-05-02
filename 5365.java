import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String[] str = sc.nextLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(i > 0 && str[i].length() < str[i - 1].length()) sb.append(" ");
			else sb.append(str[i].charAt(idx));
			idx = str[i].length() - 1;
		}
		
		System.out.println(sb.toString());
	}
}