import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String p = sc.next();
		
		int idx = 0, cnt = 0;
		for(int i = 0; i < p.length(); i++) {
			if(s.contains(p.substring(idx, i + 1))) continue;
			++cnt;
			idx = i;
		}
		
		System.out.println(cnt + 1);
	}
}