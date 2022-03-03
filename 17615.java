import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		
		//»¡°­ ¿ÞÂÊÀ¸·Î
		int idx = -1, res = Integer.MAX_VALUE, cnt = 0;
		for(int i = 0; i < N; i++) {
			if(ch[i] == 'B') break;
			idx = i;
		}
		
		for(int i = N - 1; i > idx; i--)
			if(ch[i] == 'R') ++cnt;
		
		res = Math.min(res, cnt);
		
		//»¡°­ ¿À¸¥ÂÊÀ¸·Î
		idx = N;
		for(int i = N - 1; i >= 0; i--) {
			if(ch[i] == 'B') break;
			idx = i;
		}
		
		cnt = 0;
		for(int i = 0; i < idx; i++)
			if(ch[i] == 'R') ++cnt;
		
		res = Math.min(res, cnt);
		
		//ÆÄ¶û ¿ÞÂÊÀ¸·Î
		idx = -1;
		for(int i = 0; i < N; i++) {
			if(ch[i] == 'R') break;
			idx = i;
		}
		
		cnt = 0;
		for(int i = N - 1; i > idx; i--)
			if(ch[i] == 'B') ++cnt;
		
		res = Math.min(res, cnt);
		
		//ÆÄ¶û ¿À¸¥ÂÊÀ¸·Î
		idx = N;
		for(int i = N - 1; i >= 0; i--) {
			if(ch[i] == 'R') break;
			idx = i;
		}
		
		cnt = 0;
		for(int i = 0; i < idx; i++)
			if(ch[i] == 'B') ++cnt;
		
		res = Math.min(res, cnt);
		
		System.out.println(res);
	}
}