import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		
		double res = 0.0, pre = 0, cnt = 0;
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] == '+') {
				pre += 0.5;
				res += pre;
				pre = 0;
			}
			else {
				if(pre != 0) {
					res += pre;
				}
				if(ch[i] == 'A') pre = 4;
				else if(ch[i] == 'B') pre = 3;
				else if(ch[i] == 'C') pre = 2;
				else if(ch[i] == 'D') pre = 1;
				else pre = 0;
				
				cnt += 1;
			}
		}
		
		if(pre != 0) res += pre;
		
		res /= cnt;
		
		System.out.println(res);
	}
}