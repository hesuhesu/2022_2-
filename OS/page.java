import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class page {
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(
    			new FileReader("page.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("page.out")
    	);
    	String line = "";
	    line = reader.readLine();
    	int k = Integer.valueOf(line);
    	List<List<Integer>> FIFO_list = new ArrayList<>();
    	List<List<Integer>> LRU_list = new ArrayList<>();
    	List<Integer> OPT_list = new ArrayList<>();
    	List<Integer> reference_string = new ArrayList<>();
    	
    	int FIFO = 0;
    	int LRU = 0;
    	int OPT = 0;
    	int time = 0;
    	for (int i = 0; i < k; i++) {
    		List<Integer> FIFO_input_list = new ArrayList<>();
    		FIFO_input_list.add(null);
    		FIFO_input_list.add(null);
    		
    		List<Integer> LRU_input_list = new ArrayList<>();
    	    LRU_input_list.add(null);
    	    LRU_input_list.add(null);
    	    
    		FIFO_list.add(FIFO_input_list);
    		LRU_list.add(LRU_input_list);
    		OPT_list.add(null);
    	}
    	
    	while (true) {
    		line = reader.readLine();
    		if (line.equals("-1")) {
    			break;
    		}
    		reference_string.add(Integer.valueOf(line));
    	}
    	
    	
    	for (int i = 0; i < reference_string.size(); i++) {
    		
    		time++;
    		System.out.println("현재 시간은 : "+time);
    		System.out.println("reference_string : "+reference_string.get(i)+"\n");
    		int FIFO_count = 0;
    		int LRU_count = 0;
    		int OPT_count = 0;
    		
			for (int j = 0; j < k; j++) {
				if (FIFO_list.get(j).get(0) == null) {
					FIFO_list.get(j).set(0, reference_string.get(i));
					FIFO_list.get(j).set(1, time);
					FIFO_count++;
					FIFO++;
					System.out.println("FIFO_list 근황(추가) : "+FIFO_list);
					break;
				}
				if (FIFO_list.get(j).get(0) == reference_string.get(i)) {
					FIFO_count++;
					System.out.println("FIFO_list 근황(동일) : "+FIFO_list);
					break;
				}
			}
			if (FIFO_count == 0) {
				int FIFO_sort = time;
				int FIFO_index = 0;
				for (int j = 0; j < k; j++) {
					if (FIFO_sort > FIFO_list.get(j).get(1)) {
						FIFO_sort = FIFO_list.get(j).get(1);
						FIFO_index = j;
					}
				}
				FIFO_list.get(FIFO_index).set(0, reference_string.get(i));
				FIFO_list.get(FIFO_index).set(1, time);
				FIFO++;
				System.out.println("FIFO_list 근황(수정) : "+FIFO_list);
			}
			
			for (int j = 0; j < k; j++) {
				if (LRU_list.get(j).get(0) == null) {
					LRU_list.get(j).set(0, reference_string.get(i));
					LRU_list.get(j).set(1, time);
					LRU_count++;
					LRU++;
					System.out.println("LRU_list 근황(추가) : "+LRU_list);
					break;
				}
				
				if (LRU_list.get(j).get(0) == reference_string.get(i)) {
					LRU_list.get(j).set(1, time);
					System.out.println("LRU_list 근황(동일) : "+LRU_list);
					LRU_count++;
					break;
				}
			}
			
			if (LRU_count == 0) {
				int LRU_sort = time;
				int LRU_index = 0;
				for (int j = 0; j < k; j++) {
					if (LRU_sort > LRU_list.get(j).get(1)) {
						LRU_sort = LRU_list.get(j).get(1);
						LRU_index = j;
					}
				}
				LRU_list.get(LRU_index).set(0, reference_string.get(i));
				LRU_list.get(LRU_index).set(1, time);
				LRU++;
				System.out.println("LRU_list 근황(수정) : "+LRU_list);
			}
			
			
			for (int j = 0; j < k; j++) {
				if (OPT_list.get(j) == null) {
					OPT_list.set(j, reference_string.get(i));
					OPT_count++;
					OPT++;
					System.out.println("OPT_list 근황(추가) : "+OPT_list);
					break;
				}
				
				if (OPT_list.get(j) == reference_string.get(i)) {
					OPT_count++;
					System.out.println("OPT_list 근황(동일) : "+OPT_list);
					break;
				}
			}
			
			if (OPT_count == 0) {
				int OPT_sort = reference_string.size();
				int OPT_index = 0;
				
				List<Integer> OPT_test = new ArrayList<>();
				
				for (int j = 0; j < k; j++) {
					OPT_test.add(OPT_sort);
				}
				int count2 = 0;
				for (int j = 0; j < k; j++) {
					int count = 0;
					for (int w = i; w < reference_string.size(); w++) {
						if ((reference_string.get(w) == OPT_list.get(j))) {
							OPT_test.set(j, w);
							count++;
							break;
						}
					}
					if (count == 0) {
						OPT_index = j;
						count2++;
						break;
					}
				}
				if (count2 == 0) {
					OPT_sort = OPT_test.get(0);
					for (int j = 0; j < k; j++) {
						if (OPT_sort < OPT_test.get(j)) {
							OPT_sort = OPT_test.get(j);
							OPT_index = j;
						}
					}
				}
				
				System.out.println("수정해야 할 index : "+OPT_index);
				System.out.println("OPT_list 근황(수정 전) : "+OPT_list);
				OPT_list.set(OPT_index, reference_string.get(i));
				OPT++;
				System.out.println("OPT_list 근황(수정 후) : "+OPT_list);
			}
			
			System.out.println("FIFO 현황 : "+FIFO);
			System.out.println("LRU 현황 : "+LRU);
			System.out.println("OPT 현황 : "+OPT);
			System.out.println("------------------------------------------------------\n");
    	}
    	System.out.println("FIFO: "+FIFO);
		System.out.println("LRU: "+LRU);
		System.out.println("OPT: "+OPT);
    	writer.write("FIFO: "+String.valueOf(FIFO)+"\n");
    	writer.write("LRU: "+String.valueOf(LRU)+"\n");
    	writer.write("OPT: "+String.valueOf(OPT)+"\n");
    	
    	reader.close();
    	writer.close();
    }
}
