import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		int res = 0;
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == 'D') {
				if(i + 3 < ch.length && ch[i + 1] == 'K' && ch[i + 2] == 'S' && ch[i + 3] == 'H')
					++res;
			}
		}
		
		System.out.println(res);
	}
}