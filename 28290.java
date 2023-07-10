import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		if(str.equals("fdsajkl;") || str.equals("jkl;fdsa")) System.out.println("in-out");
		else if(str.equals("asdf;lkj") || str.equals(";lkjasdf")) System.out.println("out-in");
		else if(str.equals("asdfjkl;")) System.out.println("stairs");
		else if(str.equals(";lkjfdsa")) System.out.println("reverse");
		else System.out.println("molu");
	}
}