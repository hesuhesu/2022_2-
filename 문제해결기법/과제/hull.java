import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class hull {
    static int N;
    static Hulls list[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("hull.inp"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("hull.out"));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        list = new Hulls[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[i] = new Hulls(a, b);
        }
        // 1. 기준점 선정
        for(int i=1; i<=N; i++){
            if(list[1].x > list[i].x){
            	Hulls temp = list[1];
                list[1] = list[i];
                list[i] = temp;
            }
            else if ((list[1].x == list[i].x)&(list[1].x > list[1].y)) {
            	
            }
        }
        
        // 2. 기준점 기준으로 반시계방향으로 정렬
        Arrays.sort(list, 2, N+1, new Comparator<Hulls>() {
 
            @Override
            public int compare(Hulls a, Hulls b) {
                int v = ccw(new Hulls(list[1].x, list[1].y), a, b);
                if( v > 0)    return -1;
                if(v<0)    return 1;
                return (Math.abs(a.x) + a.y) - (Math.abs(b.x) + b.y);
            }
        });    
        // 3. stack 
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for(int i=2; i<=N; i++){
            while(stack.size() > 1 && ccw(list[stack.get(stack.size()-2)], list[stack.peek()], list[i]) <=0 ){
                stack.pop();
            }
            stack.add(i);
        }
        System.out.print(stack.size()+"\n");
        bw.write(stack.size() + "\n");
        
        for (int i = 0; i < stack.size(); i++) {
        	System.out.print(list[stack.get(i)].x+" "+list[stack.get(i)].y+"\n");
            bw.write(list[stack.get(i)].x+" "+list[stack.get(i)].y+"\n");
        }
        br.close();
        bw.flush();
    }
    protected static int ccw(Hulls A, Hulls B, Hulls C) {
        long cal = 0;
        cal = (long)(B.x - A.x) * (C.y - A.y) - (long)(C.x-A.x) * (B.y-A.y);
        if(cal > 0)    return 1;
        else if (cal< 0)    return -1;
        else    return 0;
    }
}
class Hulls{
    int x, y;
    Hulls(int x, int y){
        this.x = x;
        this.y = y;
    }
}
