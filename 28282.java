import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int K = sc.nextInt();
		
		HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>();
		for(int i = 0; i < X * 2; i++) {
			int num = sc.nextInt();
			if(i < X) {
				if(left.containsKey(num)) left.replace(num, left.get(num) + 1);
				else left.put(num, 1);
			}
			else {
				if(right.containsKey(num)) right.replace(num, right.get(num) + 1);
				else right.put(num, 1);
			}
		}
		
		long res = 0;
		Iterator<Integer> it = left.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			int value = left.get(key);
			
			int num = right.containsKey(key) ? right.get(key) : 0;
			num = X - num;
			
			res += (long)num * (long)value;
		}
		
		System.out.println(res);
	}
}