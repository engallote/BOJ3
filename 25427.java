import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		long d = 0, s = 0, k = 0, h = 0;
		
		for(int i = 0; i < N; i++) {
			if(ch[i] == 'D') ++d;
			else if(ch[i] == 'K') k += d;
			else if(ch[i] == 'S') s += k;
			else if(ch[i] == 'H') h += s;
		}
		
		System.out.println(h);
	}
}