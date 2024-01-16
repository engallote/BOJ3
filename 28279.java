import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int a = 0, x = 0;
		while(--N >= 0) {
			String s = br.readLine().trim();
			if(s.contains(" ")) {
				a = s.charAt(0) - '0';
				x = Integer.parseInt(s.substring(2));
			}
			else a = s.charAt(0) - '0';
			
			switch(a) {
			case 1:
				dq.offerFirst(x);
				break;
			case 2:
				dq.offer(x);
				break;
			case 3:
				sb.append(dq.isEmpty() ? "-1\n" : dq.pollFirst() + "\n");
				break;
			case 4:
				sb.append(dq.isEmpty() ? "-1\n" : dq.pollLast() + "\n");
				break;
			case 5:
				sb.append(dq.size() + "\n");
				break;
			case 6:
				sb.append(dq.isEmpty() ? "1\n" :  "0\n");
				break;
			case 7:
				sb.append(dq.isEmpty() ? "-1\n" : dq.peekFirst() + "\n");
				break;
			case 8:
				sb.append(dq.isEmpty() ? "-1\n" : dq.peekLast() + "\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}