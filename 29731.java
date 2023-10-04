import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		HashSet<String> hs = new HashSet<>();
		hs.add("Never gonna give you up");
		hs.add("Never gonna let you down");
		hs.add("Never gonna run around and desert you");
		hs.add("Never gonna make you cry");
		hs.add("Never gonna say goodbye");
		hs.add("Never gonna tell a lie and hurt you");
		hs.add("Never gonna stop");
		
		boolean flag = true;
		for(int i = 0; i < N; i++) {
			String str = sc.nextLine();
			
			if(!hs.contains(str)) flag = false;
		}
		
		System.out.println(flag ? "No" : "Yes");
	}
}