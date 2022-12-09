import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int idx = 0;
    	String str = "";
    	Queue<String> q = new LinkedList<>();
    	
    	while((str = br.readLine()) != null) {
    		StringTokenizer st = new StringTokenizer(str, " \t\n");
    		while(st.hasMoreTokens()) q.offer(st.nextToken());
    	}
    	
    	while(!q.isEmpty()) {
    		str = q.poll();
    		
			if(str.equals("<br>")) {
				sb.append("\n");
				idx = 0;
				continue;
			}
			if(str.equals("<hr>")) {
				if(idx != 0) sb.append("\n");
				for(int j = 0; j < 80; j++) sb.append("-");
				sb.append("\n");
				idx = 0;
				continue;
			}
			
			if(idx + str.length() + (idx == 0 ? 0 : 1) > 80) {
				idx = 0;
				sb.append("\n");
			}
			
			if(idx != 0) sb.append(" ");
			sb.append(str);
			idx += str.length() + (idx == 0 ? 0 : 1);
    	}
    	
    	System.out.print(sb.toString());
	}
}