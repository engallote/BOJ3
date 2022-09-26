import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] arr = {"aespa", "baekjoon", "cau", "debug","edge","firefox","golang","haegang","iu","java",
    			"kotlin", "lol", "mips", "null", "os", "python", "query", "roka", "solvedac", "tod", "unix",
    			"virus", "whale", "xcode", "yahoo", "zebra"};
    	
    	String str = br.readLine().trim();
    	StringBuilder res = new StringBuilder();
    	boolean flag = true;
    	int idx = 0, len = 0;
    	
    	while(len < str.length()) {
    		idx = str.charAt(len) - 'a';
    		int len2 = arr[idx].length();
    		
    		if(len2 <= str.length()) {
    			String tmp = str.substring(len, len + len2);
    			
    			if(tmp.equals(arr[idx])) res.append((char)(idx + 'a'));
    			else {
    				flag = false;
    				break;
    			}
    		}
    		else {
    			flag = false;
    			break;
    		}
    		
    		len += len2;
    	}
    	
    	if(flag) {
    		bw.write("It's HG!\n");
    		bw.write(res.toString());
    	}
    	else bw.write("ERROR!");
    	bw.flush();
	}
}