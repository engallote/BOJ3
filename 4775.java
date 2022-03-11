import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < N; i++) hs.add(sc.next());
		
		int M = sc.nextInt();
		boolean flag = true;
		
		for(int i = 1; i <= M; i++) {
			flag = true;
			while(true) {
				String str = sc.next();
				if(str.equals("-1")) break;
				
				if(hs.contains(str)) continue;
				else {
					if(flag) System.out.println("Email " + i + " is not spelled correctly.");
					flag = false;
					System.out.println(str);
				}
			}
			if(flag) System.out.println("Email " + i + " is spelled correctly.");
			if(i == M) System.out.println("End of Output");
		}
	}
}