import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
    	
    	// 여기 해당하는 출력문은 확인용.
	    
    	Scanner sc = new Scanner(System.in);
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("test.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("test.out")
    	);
    	String line = "";
    	
    	int k = Integer.valueOf(reader.readLine());
    	sc.close();
    	
    	String[][] result = new String[k][3];  // 총괄 2차원 배열
    	List<String> result_name = new ArrayList<String>(); // 이름 리스트. 중복되는지 여부 확인
    	HashSet<String> result_set = new HashSet<>(); // set.
    	
    	int numCount = 0;
    	for (int i = 0; i < k; i++) {
    		line = reader.readLine(); // 한 줄씩 읽기. sc.nextInt로 몇 줄 읽을지 정함.
    		String[] split = line.split(" "); 
    		List<String> n = new ArrayList<String>();
    		n.add(split[0]);
    		n.add(split[1]);
    		n.add(split[2]);
    		
    		if (numCount < split[1].length()) {
    			numCount = split[1].length();
    		}
    		
    		for (int j = 0; j < 3; j++) {
    			result[i][j] = split[j];
    		}
    		result_name.add(split[2]);
    		result_set.add(split[2]);
	}
    	
    	
    	ArrayList<String> result_final_set = new ArrayList<>(result_set); // set list로 변환.
    	Collections.sort(result_final_set);
    	
    	Arrays.sort(result, new Comparator<String[]>() {
    		@Override
    		public int compare(String[] o1, String[] o2) {
    			return o1[0].compareTo(o2[0]);
    		}
    	});
    	
    	List<Integer> countnum = new ArrayList<Integer>();
    	List<String> result_final_name = new ArrayList<String>();
    	
    	for (int i = 0; i < result_final_set.size(); i++) {
    		if (Collections.frequency(result_name, result_final_set.get(i)) > 1) {
    			countnum.add(Collections.frequency(result_name, result_final_set.get(i)));
    			result_final_name.add(result_final_set.get(i));
    		}
    	}
    	
	for (int i = 0; i < k; i++) {
		System.out.print(result[i][0]+" "+result[i][1]+" ");
		writer.write(String.valueOf(result[i][0])+" "+String.valueOf(result[i][1])+" ");
		for (int j = 0; j < numCount - result[i][1].length(); j++) {
			System.out.print(" ");
			writer.write(" ");
		}
		System.out.print(result[i][2]+"\n");
		writer.write(String.valueOf(result[i][2])+"\n");
	}
		
	writer.write("\n");
	System.out.println("");
		
    	if (countnum.size() > 0) {
    		for (int i = 0; i < countnum.size(); i++) {
    			System.out.println(result_final_name.get(i)+" "+countnum.get(i));
    			writer.write(String.valueOf(result_final_name.get(i))+" "+String.valueOf(countnum.get(i))+"\n");
    		}
    	}
		
    	reader.close();
    	writer.close();
    }
}
