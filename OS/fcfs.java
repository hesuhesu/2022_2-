import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fcfs {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("fcfs.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("fcfs.out")
    	);
    	
    	String line = "";
    	int k = Integer.valueOf(reader.readLine());
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> stack_io = new ArrayList<>();
    	
		for (int i = 0; i < k; i++){
    	    line = reader.readLine();	
			String[] split = line.split(" ");
			List<Integer> input_list = new ArrayList<>();
			
			for (int j = 1; j < split.length - 1; j++) {
				input_list.add(Integer.valueOf(split[j]));
			}
			list.add(input_list);
			stack_io.add(Integer.valueOf(split[0]));
    	}
		
		int stack = 0;
		int uhwu = 0;
		
		while (true) {
			int check = stack; 
			int check2 = 0;
			int check3 = 0; 
			int breakcheck = 0;
			
			System.out.println("\n<<처음부터 시작합니다>>\n");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).size()>0) {
					breakcheck++;
					break;
				}
			}
			
			if (breakcheck == 0) {
				break;
			}
			
			int price = Collections.max(stack_io);
			int index = 0;
			System.out.println("\n<<<시작합니다!!>>>\n");
			for (int i = stack_io.size()-1; i > -1; i--) {
				
					if ((stack >= stack_io.get(i)) & (price >= stack_io.get(i)) & (list.get(i).size()>0)) {
						price = stack_io.get(i);
						index = i;
						check3++;
						System.out.println("젤 작은 index : "+(index+1));
						System.out.println("index의 값 : "+ stack_io.get(i));
					}
			}
			
			if (check3 != 0) {
				System.out.println("값이 존재함");
				System.out.println("\n"+(index+1)+"번째 cpu "+list.get(index).get(0)+"추가");
				stack += list.get(index).get(0);
				stack_io.set(index, stack);
				
				if (list.get(index).get(0) == 0){
					check2++;
				}
				
				if (list.get(index).size() == 1) {
					list.get(index).remove(0);
					System.out.println("남은 cpu : " + list);
					System.out.println("남은 io : " + stack_io);
					System.out.println("stack 근황 : " + stack);
				}
				else if (list.get(index).size() == 2) {
					list.get(index).remove(0);
					stack_io.set(index, stack_io.get(index)+list.get(index).get(0));
					System.out.println((index+1)+"번째 io "+list.get(index).get(0)+"추가");
					list.get(index).remove(0);
					System.out.println("남은 cpu : " + list);
					System.out.println("남은 io : " + stack_io);
					System.out.println("stack 근황 : " + stack);
				}
				else {
					list.get(index).remove(0);
					stack_io.set(index, stack_io.get(index)+list.get(index).get(0));
					System.out.println((index+1)+"번째 io "+list.get(index).get(0)+"추가");
					list.get(index).remove(0);
					System.out.println("남은 cpu : " + list);
					System.out.println("남은 io : " + stack_io);
					System.out.println("stack 근황 : " + stack);
				}
			}
						

			
			if ((check == stack)&(check2 == 0)) {

					int indexNum = 0;
				
					int checkPrice = Collections.max(stack_io);
					System.out.println("\n--------------------\n수정 전 indexNum의 값 : "+(indexNum+1));
					for (int i = stack_io.size()-1; i > -1; i--) {
						if (list.get(i).size() > 0) {
							if ((stack_io.get(i) == 0)) {
								indexNum = i;
								break;
							}
							if (stack_io.get(i) <= checkPrice) {
								indexNum = i;
								checkPrice = stack_io.get(i);
							}
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
							list.get(indexNum).remove(0);
							System.out.println("남은 cpu : " + list);
							System.out.println("남은 io : " + stack_io);
							System.out.println("stack 근황 : " + stack);
						}
						else if (list.get(indexNum).size() == 1) {
							list.get(indexNum).remove(0);
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
		System.out.println("\n최종 결과 : "+String.valueOf(uhwu)+" "+stack_io); 
    	writer.write(String.valueOf(uhwu)+"\n");
    	
    	for (int i = 0; i < stack_io.size(); i++) { 
    		writer.write(String.valueOf(stack_io.get(i))+"\n"); 
    	}
    	
    	reader.close();
    	writer.close();
    }
}