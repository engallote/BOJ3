import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		
		while(sc.hasNextLine()) {
			String[] arr = sc.nextLine().split(" ");
			String s = arr[0];
			int num = Integer.parseInt(arr[1]);
			
			if(s.equals("Es")) res += num * 21;
			else res += num * 17;
		}
		
		System.out.println(res);
	}
}