package hw_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	
    	int result1 = 0, result2 = 0;
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("C:\\Users\\user\\Desktop\\input.txt")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("C:\\Users\\user\\Desktop\\output.txt")
    	);
    	String line = "";
    	
		while( (line = reader.readLine()) != null ){ // 파일 내 문자열을 1줄씩 읽기 while
    	    	
			String[] split = line.split(" ");
			for (int i = 1; i < split.length; i++) {
				
				if (i%2 == 1) {
					result1 += Integer.valueOf(split[i]);
					result2 += Integer.valueOf(split[i]);
				}
				else if (i == split.length-1) {
					continue;
				}
				else {
					result1 += Integer.valueOf(split[i]);
				}
			}
			
    	}
    	writer.write(String.valueOf(result1));
		writer.write(" "+String.valueOf(result2));
    	
    	System.out.println(result1);
    	System.out.println(result2);
    	
    	reader.close();
    	writer.close();
    }
}
