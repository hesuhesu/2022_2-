import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sjf {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("sjf.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("sjf.out")
    	);
    	
    	String line = "";
    	int k = Integer.valueOf(reader.readLine());
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> stack_io = new ArrayList<>();
    	List<Integer> countlist = new ArrayList<>();
    	List<Integer> countlist2 = new ArrayList<>();
    	
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

		int maxioprice = Collections.max(stack_io);
		
		while (true) {
			int check = stack; 
			int check2 = 0;
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
			
			int copy = maxioprice;
			int topsize = 0;
			int index = 0;
			int indexNum = 0;
			int uhwucount = 0;
			for (int k1 = 0; k1 < stack_io.size(); k1++) {
				if ((list.get(k1).size()>0) & (stack >= stack_io.get(k1))) {
					topsize = list.get(k1).get(0);
					uhwucount++;
					break;
				}
			}
			
			System.out.println("\n<<<시작합니다!!>>>\n");
			if (uhwucount != 0) {
				for (int i = 0; i < stack_io.size(); i++) {
					if ((list.get(i).size()>0) & (stack >= stack_io.get(i))){
						if (topsize > list.get(i).get(0)) {
							countlist.clear();
							countlist.add(i);
							topsize = list.get(i).get(0);
							index = i;
							System.out.println("cpu사용이 젤 작은 index : "+(index+1));
							System.out.println("index의 값 : "+ list.get(i).get(0));
						}
						else if (topsize == list.get(i).get(0)){
							System.out.println("같은 값 추가~~");
							countlist.add(i);
							index = i;
						}
					}
				}
				if (countlist.size() > 1) {
					for (int j = countlist.size()-1; j > -1; j--) {
						if (stack_io.get(countlist.get(j)) <= copy) {
							copy = stack_io.get(countlist.get(j));
							index = countlist.get(j);
						}
					}
				}
				countlist.clear();

				System.out.println("##### case : 1 #####");
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
				
				if (maxioprice < stack_io.get(index)) {
					maxioprice = stack_io.get(index);
				}
				
			}
						
			if ((check == stack)&(check2 == 0)) {

					System.out.println("\n--------------------\n수정 전 indexNum의 값 : "+(indexNum+1));
					System.out.println("@@@@@ 유휴 페이즈 : 1 @@@@@");
					for (int i = 0; i < stack_io.size(); i++) {
						if (list.get(i).size() > 0) {
							if (copy > stack_io.get(i)) {
								countlist.clear();
								countlist2.clear();
								countlist.add(i);
								countlist2.add(list.get(i).get(0));
								copy = stack_io.get(i);
								indexNum = i;
								System.out.println("io가 젤 작은 index : "+(indexNum+1));
								System.out.println("index의 값 : "+ stack_io.get(i));
							}
							else if (copy == stack_io.get(i)){
								System.out.println("유휴가 같네요..");
								countlist.add(i);
								countlist2.add(list.get(i).get(0));
								indexNum = i;
							}
						}
					}
					if (countlist2.size() > 1) {
						System.out.println("@@@@@ 유휴 페이즈 : 2 @@@@@");
						int topsize2 = Collections.max(countlist2);
						for (int j = countlist2.size()-1; j > -1; j--) {
							if (countlist2.get(j) <= topsize2) {
								topsize2 = countlist2.get(j);
								indexNum = countlist.get(j);
							}
						}
					}
					countlist.clear();
					countlist2.clear();
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
					
					if (maxioprice < stack_io.get(indexNum)) {
						maxioprice = stack_io.get(indexNum);
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
