import java.util.*;

public class Main {
	static int N, max, cnt;
	static String str;
	static boolean[] chk;
	static String ans;
	static HashMap<Integer, String> hm;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			str = sc.next();
			
			if(N == 0 && str.equals("0")) break;
			
			int num = 0;
			for(int i = 0; i < str.length(); i++) num += str.charAt(i) - '0';
			
			if(num > N) {
				System.out.println("error");
				continue;
			}
			else if(Integer.parseInt(str) == N) {
				System.out.println(N + " " + str);
				continue;
			}
			
			ans = "";
			cnt = 0;
			max = -1;
			chk = new boolean[6];
			hm = new HashMap<>();
			
			find(0);
			
			if(cnt == 1) {
				System.out.println(max + " " + ans);
			}
			else System.out.println("rejected");
		}
	}
	private static void find(int idx) {
		if(idx == str.length()) {
			int sum = 0;
			StringBuilder sb = new StringBuilder(), tmp = new StringBuilder();
			for(int i = 0; i < str.length(); i++) {
				tmp.append(str.charAt(i));
				
				if(chk[i]) {
					
					sum += Integer.parseInt(tmp.toString());
					sb.append(tmp.toString() + " ");
					tmp = new StringBuilder();
				}
			}
			
			if(tmp.toString().length() > 0) {
				sum += Integer.parseInt(tmp.toString());
				sb.append(tmp.toString());
			}
			
			if(sum > max && sum <= N) {
				max = sum;
				cnt = 1;
				hm.put(sum, sb.toString().trim());
				ans = sb.toString();
			}
			else if(max == sum && !hm.get(sum).equals(sb.toString().trim())) {
				cnt += 1;
			}
			return;
		}
		
		find(idx + 1);
		chk[idx] = true;
		find(idx + 1);
		chk[idx] = false;
	}
}