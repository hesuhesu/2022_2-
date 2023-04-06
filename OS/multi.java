import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class multi {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("multi.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("multi.out")
    	);
    	
    	String line = "";
    	int k = Integer.valueOf(reader.readLine());
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> stack_io = new ArrayList<>();
    	List<Integer> Last_io = new ArrayList<>();
    	
    	for (int i = 0; i<k; i++) {
    		stack_io.add(0);
    	}

		for (int i = 0; i < k; i++){
    	    line = reader.readLine();	
			String[] split = line.split(" ");
			List<Integer> input_list = new ArrayList<>();
			for (int j = 0; j < split.length - 1; j++) {
				input_list.add(Integer.valueOf(split[j]));
			}
			list.add(input_list);
			
    	}
		
		int stack = 0;
		int uhwu = 0;
		
		while (true) {
			int check = stack; 
			int check2 = 0;
			if (stack_io.size() == 0) {
				break;
			}
			
			for (int i = 0; i< stack_io.size(); i++) {
				if (stack >= stack_io.get(i)) {
						System.out.println("\n"+(i+1)+"번째 cpu "+list.get(i).get(0)+"추가");
						stack += list.get(i).get(0);
						stack_io.set(i, stack);
						
						if (list.get(i).get(0) == 0){
							check2++;
						}
						
						if (list.get(i).size() == 1) {
							list.remove(i);
							Last_io.add(stack_io.get(i));
							stack_io.remove(i);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
							break;
						}
						else if (list.get(i).size() == 2) {
							list.get(i).remove(0);
							stack_io.set(i, stack_io.get(i)+list.get(i).get(0));
							System.out.println((i+1)+"번째 io "+list.get(i).get(0)+"추가");
							list.remove(i);
							Last_io.add(stack_io.get(i));
							stack_io.remove(i);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
							break;
						}
						else {
							list.get(i).remove(0);
							stack_io.set(i, stack_io.get(i)+list.get(i).get(0));
							System.out.println((i+1)+"번째 io "+list.get(i).get(0)+"추가");
							list.get(i).remove(0);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
							break;
						}
				}
			}
			
			if ((check == stack)&(check2 == 0)) {

				int indexNum = stack_io.size();
				
					int checkPrice = Collections.max(stack_io);
					System.out.println("\n--------------------\n수정 전 indexNum의 값 : "+indexNum);
					for (int i = 0; i< stack_io.size(); i++) {
						if (stack_io.size()==1) {
							indexNum = 0;
							break;
						}
						else if (stack_io.get(i) == 0) {
							stack_io.set(i, stack);
							indexNum = i;
							break;
						}
						else if (stack_io.get(i) <= checkPrice) {
							checkPrice = stack_io.get(i);
							indexNum = stack_io.indexOf(checkPrice);
						}
					}
					
					System.out.println("\n수정 후 indexNum의 값 : "+(indexNum+1)+"\n--------------------");
					System.out.println("\n유휴 시작!");
					System.out.println("제일 작은 모듈은 "+(indexNum+1)+"번째 모듈이며 값은 : "+stack_io.get(indexNum)+" 현 스택은 : "+stack);
					uhwu += (stack_io.get(indexNum) - stack);
					System.out.println((stack_io.get(indexNum) - stack)+"를 추가한 유휴시간 현황 : "+uhwu);
					
					
					stack = stack_io.get(indexNum) + list.get(indexNum).get(0);
					System.out.println("적용 후 스택 근황 : "+stack);
					stack_io.set(indexNum, stack); 
					
						if (list.get(indexNum).size() == 2) {	
							list.get(indexNum).remove(0);
							stack_io.set(indexNum, stack_io.get(indexNum)+list.get(indexNum).get(0));
							System.out.println((indexNum+1)+"번째 io "+list.get(indexNum).get(0)+"추가");
							list.remove(indexNum);
							Last_io.add(stack_io.get(indexNum));
							stack_io.remove(indexNum);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
						}
						else if (list.get(indexNum).size() == 1) {
							list.remove(indexNum);
							Last_io.add(stack_io.get(indexNum));
							stack_io.remove(indexNum);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
						}
						else {
							list.get(indexNum).remove(0);
							stack_io.set(indexNum, stack_io.get(indexNum)+list.get(indexNum).get(0));
							System.out.println((indexNum+1)+"번째 io "+list.get(indexNum).get(0)+"추가");
							list.get(indexNum).remove(0);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
						}
			
			
		}
	}
		System.out.println("\nio의 마지막 근황 : "+Last_io);
		System.out.println("\n최종 결과 : "+String.valueOf(uhwu)+" "+String.valueOf(Collections.max(Last_io))+"\n");
    	writer.write(String.valueOf(uhwu)+" "+String.valueOf(Collections.max(Last_io))+"\n");
    	
    	reader.close();
    	writer.close();
    }
}
