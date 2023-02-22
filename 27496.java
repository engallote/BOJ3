import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	BigDecimal bd = new BigDecimal("0.0");
    	BigDecimal[] arr = new BigDecimal[N];
    	int res = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = new BigDecimal(st.nextToken());    		
    		bd = bd.add(arr[i].multiply(new BigDecimal(("0.001"))));
    		
    		if(i >= L) bd = bd.subtract(arr[i - L].multiply(new BigDecimal(("0.001"))));
    		
    		if(bd.compareTo(new BigDecimal("0.129")) >= 0 && bd.compareTo(new BigDecimal("0.138")) <= 0)
    			++res;
    	}
    	
    	
    	System.out.println(res);
	}
}