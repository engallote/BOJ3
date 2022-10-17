import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("int a;\n");
    	for(int i = 1; i <= N; i++) {
    		sb.append("int ");
    		for(int j = 0; j < i; j++) sb.append("*");
    		
    		if(i == 1) sb.append("ptr = &a;\n");
    		else sb.append("ptr" + i + " = &ptr" + (i - 1 <= 1 ? "" : i - 1) + ";\n");
    	}
    	
    	System.out.println(sb.toString());
	}
}