import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rr {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("rr.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("rr.out")
    	);
    	String line = "";
	    line = reader.readLine();	
		String[] NUM = line.split(" ");
    	int k = Integer.valueOf(NUM[0]);
    	int time_slice = Integer.valueOf(NUM[1]);
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> start_cpu = new ArrayList<>();
    	List<Integer> stack_io = new ArrayList<>();
    	List<Integer> thread_list = new ArrayList<>();
    	
    	int findindex = 0;
    	
		for (int i = 0; i < k; i++){
    	    line = reader.readLine();	
			String[] split = line.split(" ");
			List<Integer> input_list = new ArrayList<>();
 			for (int j = 1; j < split.length - 1; j++) {
				input_list.add(Integer.valueOf(split[j]));
			}
			list.add(input_list);
			stack_io.add(Integer.valueOf(split[0]));

			start_cpu.add(findindex);
			findindex++;
    	}
		int stack = 0;
		int uhwu = 0;
		int king_stack_io = stack_io.get(stack_io.size()-1);
		
		while (true) {
			int start_index = 0;
			
			if ((thread_list.size() == 0) & (start_cpu.size() == 0)) {
				break;
			}
			
			if (thread_list.size()==0) {
				int check1 = king_stack_io;
	    	
				for (int i = 0; i < start_cpu.size(); i++) {
						if (stack_io.get(start_cpu.get(i)) <= check1) {
							check1 = stack_io.get(start_cpu.get(i));
						}
				}
				System.out.println("유휴 전 유휴 근황 : "+uhwu);
				uhwu += (check1 - stack);
				stack = check1;
				System.out.println("유휴 후 stack 근황 : "+stack);
				System.out.println("유휴 후 유휴 근황 : "+uhwu);
				while (start_cpu.size() > 0) {
					int check2 = king_stack_io;
					List<Integer> checklist2 = new ArrayList<>();
					for(int i = 0; i < start_cpu.size(); i++) {
						if (stack_io.get(start_cpu.get(i)) == check2) {
							checklist2.add(start_cpu.get(i));
						}
						else if (stack_io.get(start_cpu.get(i)) < check2) {
							checklist2.clear();
							checklist2.add(start_cpu.get(i));
							check2 = stack_io.get(start_cpu.get(i));
						}
					}
					if (check2 > stack) {
						break;
					}
					Collections.sort(checklist2);
					for (int i = 0; i < checklist2.size(); i++) {
						thread_list.add(checklist2.get(i));
						System.out.println("## thread_list에 추가 : "+checklist2.get(i)+"(stack_io : "+check2+") ##");
						start_cpu.remove(Integer.valueOf(checklist2.get(i)));
					}
				}
			}
			

			

			if (list.get(thread_list.get(start_index)).get(0) > time_slice) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("                       time_slice를 초과합니다.");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("stack 쌓기 전 근황 : "+stack);
				stack += time_slice;
				System.out.println("<index : "+thread_list.get(start_index)+"의 삭제 전 list의 근황 : "+list.get(thread_list.get(start_index))+" >");
				System.out.println("stack 쌓은 후 근황 : "+stack+"(+"+time_slice+")");
				list.get(thread_list.get(start_index)).set(0, list.get(thread_list.get(start_index)).get(0) - time_slice);
				stack_io.set(thread_list.get(start_index), stack);
				
				if (stack_io.get(thread_list.get(start_index)) > king_stack_io){
					king_stack_io = stack_io.get(thread_list.get(start_index));
				}
				
				while (start_cpu.size() > 0) {
					int check2 = king_stack_io;
					List<Integer> checklist2 = new ArrayList<>();
					for(int i = 0; i < start_cpu.size(); i++) {
						if (stack_io.get(start_cpu.get(i)) == check2) {
							checklist2.add(start_cpu.get(i));
						}
						else if (stack_io.get(start_cpu.get(i)) < check2) {
							checklist2.clear();
							checklist2.add(start_cpu.get(i));
							check2 = stack_io.get(start_cpu.get(i));
						}
					}
					if (check2 > stack) {
						break;
					}
					Collections.sort(checklist2);
					for (int i = 0; i < checklist2.size(); i++) {
						thread_list.add(checklist2.get(i));
						System.out.println("## thread_list에 추가 : "+checklist2.get(i)+"(stack_io : "+check2+") ##");
						start_cpu.remove(Integer.valueOf(checklist2.get(i)));
					}
				}
				System.out.println("<index : "+thread_list.get(start_index)+"의 삭제 후 list의 근황(다시 큐에 삽입) : "+list.get(thread_list.get(start_index))+" >");
				thread_list.add(thread_list.get(start_index));
				thread_list.remove(start_index);
			}
			
			
			else if (list.get(thread_list.get(start_index)).get(0) <= time_slice) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("                       time_slice보다 작거나 같습니다.");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("stack 쌓기 전 근황 : "+stack);
				stack += list.get(thread_list.get(start_index)).get(0);
				System.out.println("<index : "+thread_list.get(start_index)+"의 삭제 전 list의 근황 : "+list.get(thread_list.get(start_index))+" >");
				System.out.println("stack 쌓은 후 근황 : "+stack+"(+"+list.get(thread_list.get(start_index)).get(0)+")");
				list.get(thread_list.get(start_index)).remove(0);
				
				while (start_cpu.size() > 0) {
					int check2 = king_stack_io;
					List<Integer> checklist2 = new ArrayList<>();
					for(int i = 0; i < start_cpu.size(); i++) {
						if (stack_io.get(start_cpu.get(i)) == check2) {
							checklist2.add(start_cpu.get(i));
						}
						else if (stack_io.get(start_cpu.get(i)) < check2) {
							checklist2.clear();
							checklist2.add(start_cpu.get(i));
							check2 = stack_io.get(start_cpu.get(i));
						}
					}
					if (check2 > stack) {
						break;
					}
					Collections.sort(checklist2);
					for (int i = 0; i < checklist2.size(); i++) {
						thread_list.add(checklist2.get(i));
						System.out.println("## thread_list에 추가 : "+checklist2.get(i)+"(stack_io : "+check2+") ##");
						start_cpu.remove(Integer.valueOf(checklist2.get(i)));
					}
				}
				
				if (list.get(thread_list.get(start_index)).size() == 0) {
					stack_io.set(thread_list.get(start_index), stack);
					
					if (stack_io.get(thread_list.get(start_index)) > king_stack_io){
						king_stack_io = stack_io.get(thread_list.get(start_index));
					}
					
					System.out.println("!!!!!!!현 index는 삭제됩니다 - 미포함 - index : "+thread_list.get(start_index));
					thread_list.remove(start_index);
				}
				else if (list.get(thread_list.get(0)).size() == 1) {
					System.out.println("!!!!!!!현 index는 삭제됩니다 - cpu i/o 시간 포함 - index : "+thread_list.get(start_index));
					stack_io.set(thread_list.get(start_index), stack + list.get(thread_list.get(start_index)).get(0));
					
					if (stack_io.get(thread_list.get(start_index)) > king_stack_io){
						king_stack_io = stack_io.get(thread_list.get(start_index));
					}
					
					list.get(thread_list.get(start_index)).remove(0);
					thread_list.remove(start_index);
				}
				else {
					stack_io.set(thread_list.get(start_index), stack + list.get(thread_list.get(start_index)).get(0));
					
					if (stack_io.get(thread_list.get(start_index)) > king_stack_io){
						king_stack_io = stack_io.get(thread_list.get(start_index));
					}
					
					list.get(thread_list.get(start_index)).remove(0);
					System.out.println("<index : "+thread_list.get(start_index)+"의 삭제 후 list의 근황 : "+list.get(thread_list.get(start_index))+" >");
					
					start_cpu.add(thread_list.get(start_index));
					thread_list.remove(start_index);
				}
			};
			System.out.println("list : "+list);
			System.out.println("stack_io 근황 : "+stack_io);
			System.out.println("thread_list 근황 : "+thread_list);
			System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");		
		}
		System.out.println("\n최종 결과 : "+String.valueOf(uhwu)+" "+stack_io); 
    	writer.write(String.valueOf(uhwu)+"\n");
    	
    	for (int i = 0; i < stack_io.size(); i++) { 
    		writer.write(String.valueOf(stack_io.get(i))+"\n"); 
    	}
    	reader.close();
    	writer.close();
    }
}
