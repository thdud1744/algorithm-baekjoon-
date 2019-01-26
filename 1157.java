import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = bf.readLine().toUpperCase();
		HashMap<Character, Integer> archive = new HashMap<Character, Integer>();
		
		for(int i = 0; i<s.length(); i++) {
			if(archive.containsKey(s.charAt(i))) {
				archive.put(s.charAt(i), archive.get(s.charAt(i))+1);
			} else {
				archive.put(s.charAt(i), 0);
			}
		}
		
		Entry<Character, Integer> max = null;
		
		for(Entry<Character, Integer> entry : archive.entrySet()) {
			if( max == null || entry.getValue().compareTo(max.getValue()) > 0) {
				max = entry;
			}
		}	
		int max_value = max.getValue();
		int count = 0;
		
		for(Entry<Character, Integer> entry : archive.entrySet()) {
			if( entry.getValue() == max_value) {
				count ++;
			}
		}	
		
		if(count > 1) {
			bw.write("?");
		} else {
			bw.write(max.getKey());
		}
		bw.flush();
		bw.close();
	}
}
