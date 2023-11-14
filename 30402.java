import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String res = "";
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				String c = sc.next();
				if(c.equals("w")) {
					res = "chunbae";
					break;
				}
				else if(c.equals("b")) {
					res = "nabi";
					break;
				}
				else if(c.equals("g")) {
					res = "yeongcheol";
					break;
				}
			}
		}
		
		System.out.println(res);
	}
}