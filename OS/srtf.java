import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class srtf {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("srtf.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("srtf.out")
    	);
    	
    	String line = "";
    	int k = Integer.valueOf(reader.readLine());
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> start_cpu = new ArrayList<>();
        
    	
		for (int i = 0; i < k; i++){
    	    line = reader.readLine();	
			String[] split = line.split(" ");
			List<Integer> input_list = new ArrayList<>();
			input_list.add(Integer.valueOf(split[0]));
			input_list.add(Integer.valueOf(split[1]));
			input_list.add(Integer.valueOf(split[1]));
			input_list.add(Integer.valueOf(split[0]));
			start_cpu.add(Integer.valueOf(split[0]));
			
			list.add(input_list);
    	}
		
		Set<Integer> setset = new HashSet<>(start_cpu);
    	List<Integer> set = new ArrayList<>(setset);
		Collections.sort(set);
		int stack = list.get(0).get(0);
		int resttime = 0;
		int doingindex = 1;
		int finalcount = 0;
		System.out.println("최초의 시작 : "+list.get(0).get(0));
		
		while (true) {
			
			if (list.size() == 0) {
				break;
			}

	    	List<Integer> storage_list = new ArrayList<>();
			
			if ((doingindex > set.size()-1)|(finalcount == 1)) {
				System.out.println("up");
				int index = list.size()-1;
				int test = list.get(0).get(1);
				for (int i = list.size()-1; i > -1; i--) {
					if (test >= list.get(i).get(1)) {
						test = list.get(i).get(1);
						index = i;
					}
				}
				System.out.println("쌓기 전 스택 : "+stack);
				System.out.println("list 현황 : "+list);
				System.out.println("선택된 요소의 남은 remain_cpu : "+list.get(index).get(1));
				
				stack += list.get(index).get(1);
				System.out.println("쌍은 후 스택 : "+stack);
				System.out.println("휴계시간 전 근황 : "+resttime);
				System.out.println("****************************************************\n");
				System.out.println("stack("+stack+") - 태초의 cpu 사용시간("+list.get(index).get(2)+") - 태초의 도착 시간("+list.get(index).get(3)+") = "+(stack-list.get(index).get(2)-list.get(index).get(3)));
				System.out.println("\n****************************************************");
				resttime += (stack - list.get(index).get(2)-list.get(index).get(3));
				list.remove(index);
				System.out.println("휴계시간 후 근황 : "+resttime);
				System.out.println("<<<<<DELETE>>>>>");
			}
			else {
				System.out.println("down");
				int index = list.size()-1;
				
				for (int i = 0; i < list.size(); i++) {
					if (stack >= list.get(i).get(0)) {
						storage_list.add(i);
					}
				}

				if (storage_list.size() == 0) {
					int copystack = set.get(set.size()-1);
					for (int i = 0; i < list.size(); i++) {
						if (copystack == list.get(i).get(0)) {
							storage_list.add(i);
						}
						else if (copystack > list.get(i).get(0)) {
							storage_list.clear();
							storage_list.add(i);
							copystack = list.get(i).get(0);
						}
					}
					stack = copystack;
					int copystack2 = set.get(set.size()-1);
					for (int i = storage_list.size()-1; i > -1; i--) {
						if (copystack2 >= list.get(storage_list.get(i)).get(1)) {
							copystack2 = list.get(storage_list.get(i)).get(1);
							index = storage_list.get(i);
						}
					}
				}
				
				
				else {
					System.out.println("유휴를 막을 요소가 있습니다");
					int storagecheck = list.get(storage_list.get(storage_list.size()-1)).get(1);
					for (int i = storage_list.size()-1; i > -1; i--) {
						if (storagecheck >= list.get(storage_list.get(i)).get(1)) {
							storagecheck = list.get(storage_list.get(i)).get(1);
							index = storage_list.get(i);
						}
					}
				}
				
				System.out.println("선택된 리스트 수정 전 현황 : "+list.get(index));
				if (set.get(doingindex)-stack == list.get(index).get(1)) {
					System.out.println("\n(remain_cpu와 동일.)\n");
					System.out.println("추가 전 stack 근황 : "+stack);
					System.out.println("추가됩니다 : "+list.get(index).get(1));
					stack += list.get(index).get(1);
					System.out.println("추가 후 stack 근황 : "+stack);
					resttime += (stack-list.get(index).get(2)-list.get(index).get(3));
					System.out.println("****************************************************\n");
					System.out.println("stack("+stack+") - 태초의 cpu 사용시간("+list.get(index).get(2)+") - 태초의 도착 시간("+list.get(index).get(3)+") = "+(stack-list.get(index).get(2)-list.get(index).get(3)));
					System.out.println("\n****************************************************");System.out.println("휴계시간 근황 : "+resttime);
					list.remove(index);
					System.out.println("<<<<<DELETE>>>>>");
					doingindex++;
				}
				else if (set.get(doingindex)-stack < list.get(index).get(1)) {
					System.out.println("\n(remain_cpu가 더 많음.)\n");
					System.out.println("추가 전 stack 근황 : "+stack);
					System.out.println("추가됩니다 : "+(set.get(doingindex)-stack));
					list.get(index).set(1, list.get(index).get(1) - (set.get(doingindex)-stack));
					stack += set.get(doingindex)-stack;
					System.out.println("추가 후 stack 근황 : "+stack);
					list.get(index).set(0,stack);
					System.out.println("휴계시간 근황 : "+resttime);
					System.out.println("선택된 리스트 수정 후 현황 : "+list.get(index));
					doingindex++;
				}
				else if (set.get(doingindex)-stack > list.get(index).get((1))) {
					System.out.println("\n(remain_cpu가 더 적음.)\n");
					System.out.println("추가 전 stack 근황 : "+stack);
					System.out.println("추가됩니다 : "+list.get(index).get((1)));
					stack += list.get(index).get(1);
					System.out.println("추가 후 stack 근황 : "+stack);
					resttime += (stack - list.get(index).get(2) - list.get(index).get(3));
					System.out.println("****************************************************\n");
					System.out.println("stack("+stack+") - 태초의 cpu 사용시간("+list.get(index).get(2)+") - 태초의 도착 시간("+list.get(index).get(3)+") = "+(stack-list.get(index).get(2)-list.get(index).get(3)));
					System.out.println("\n****************************************************");System.out.println("휴계시간 근황 : "+resttime);
					list.remove(index);
					System.out.println("<<<<<DELETE>>>>>");
					if (set.get(doingindex) == set.get(set.size()-1)) {
						int count1 = 0;
						for (int i = 0; i<list.size()-1; i++) {
							if (set.get(doingindex)> list.get(i).get(0)) {
								count1++;
								break;
							}
						}
						if (count1 == 0) {
							stack = set.get(doingindex);
							finalcount++;
						}
					}
				}
			}
			System.out.println("------------------------------------------------");
		}
		System.out.println("\n최종 결과 : "+String.valueOf(resttime)); 
    	writer.write(String.valueOf(resttime)+"\n");
    	
    	reader.close();
    	writer.close();
    }
}
