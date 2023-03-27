import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class command {
    public static void main(String[] args) throws IOException {
    	
        HashMap<String, String> codes = new HashMap<String, String>();
        
    	codes.put("ls", "dir");
    	codes.put("dir", "ls");
    	codes.put("mkdir", "md");
    	codes.put("md", "mkdir");
    	codes.put("rmdir", "rd");
    	codes.put("rd", "rmdir");
    	codes.put("rm", "del");
    	codes.put("del", "rm");
    	codes.put("cp", "copy");
    	codes.put("copy", "cp");
    	codes.put("mv", "rename");
    	codes.put("rename", "mv");
    	codes.put("clear", "cls");
    	codes.put("cls", "clear");
    	codes.put("pwd", "cd");
    	codes.put("cd", "pwd");
    	codes.put("cat", "type");
    	codes.put("type", "cat");
    	codes.put("man", "help");
    	codes.put("help", "man");
    	codes.put("date", "time");
    	codes.put("time", "date");
    	codes.put("find", "find");
    	codes.put("grep", "findstr");
    	codes.put("findstr", "grep");
    	codes.put("more", "more");
    	codes.put("diff", "comp");
    	codes.put("comp", "diff");
    	codes.put("ed", "edlin");
    	codes.put("edlin", "ed");
    	codes.put("sort", "sort");
    	codes.put("lsattr", "attrib");
    	codes.put("attrib", "lsattr");
    	codes.put("pushd", "pushd");
    	codes.put("popd", "popd");
    	codes.put("ps", "taskmgr");
    	codes.put("taskmgr", "ps");
    	codes.put("kill", "tskill");
    	codes.put("tskill", "kill");
    	codes.put("halt", "shutdown");
    	codes.put("shutdown", "halt");
    	codes.put("ifconfig", "ipconfig");
    	codes.put("ipconfig", "ifconfig");
    	codes.put("fsck", "chkdsk");
    	codes.put("chkdsk", "fsck");
    	codes.put("free", "mem");
    	codes.put("mem", "free");
    	codes.put("debugfs", "scandisk");
    	codes.put("scandisk", "debugfs");
    	codes.put("lpr", "print");
    	codes.put("print", "lpr");
    	
    	List<String> input_list = new ArrayList<String>();
    	
    	BufferedReader reader = new BufferedReader(
    			new FileReader("command.inp")
    	);
    	BufferedWriter writer = new BufferedWriter(
    			new FileWriter("command.out")
    	);
    	
    	int k = Integer.valueOf(reader.readLine());
    	
    	String line = "";
		for (int i = 0; i < k; i++){
    	    line = reader.readLine();	
			input_list.add(line);
    	}
		for (int i = 0; i < input_list.size(); i++) {
			writer.write(String.valueOf(input_list.get(i))+" -> "+String.valueOf(codes.get(input_list.get(i)))+"\n");
		}
    	
    	
    	reader.close();
    	writer.close();
    }
}