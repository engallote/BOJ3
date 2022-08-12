import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		int a = 0, b = 0, res = Integer.MAX_VALUE;
		for(char c : ch) if(c == 'a') if(c == 'a') a += 1;
		
		for(int i = 0; i < ch.length; i++) {
			b = 0;
			for(int j = i; j < i + a; j++) if(ch[j % ch.length] == 'b') b += 1;
			res = Math.min(res, b);
		}
		
		System.out.println(res);
	}
}