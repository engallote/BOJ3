import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<String> hs = new HashSet<>();
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			
			if(name.equals("ENTER")) {
				hs.clear();
				continue;
			}
			
			if(!hs.contains(name)) ++res;
			hs.add(name);
		}
		
		System.out.println(res);
	}
}