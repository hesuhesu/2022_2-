import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class kmin {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("kmin.inp")
		);
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("kmin.out")
		);
		ArrayList<Integer> listA = new ArrayList<Integer>(); 
		String line = "";
		while (true) {
		    line = reader.readLine();
			String[] split = line.split(" ");
			
			if (split[0].equals("i")) {
				listA.add(Integer.valueOf(split[1]));
			}
			else if (split[0].equals("r")){
				listA.sort(null);
				int result = listA.get(Integer.valueOf(split[1])-1);
				writer.write(String.valueOf(result)+"\n");
			}
			else if (split[0].equals("e")) {
				break;
			}
		}
	    reader.close();
	    writer.close();
}
}
