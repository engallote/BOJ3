import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	int len = ch.length, un = 0, col = 0;
    	
    	for(char c : ch) {
    		if(c == '_') ++un;
    		else if(c == ':') ++col;
    	}
    	
    	System.out.println(len + col + un * 5);
	}
}