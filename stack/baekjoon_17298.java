import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class baekjoon_17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        Stack<Integer> NGE = new Stack<>();

        for (String s: str) {
            left.push(Integer.parseInt(s));
        }
        for(int i = 0; i < n; i++){
            int num = left.peek();
            while(!right.isEmpty() && right.peek() <= num){
                right.pop();
            }
            if(right.isEmpty())
                NGE.push(-1);
            else
                NGE.push(right.peek());
            right.push(left.pop());
        }

        while(!NGE.isEmpty()){
            bw.write(String.valueOf(NGE.pop()));
            if(!NGE.isEmpty())
                bw.write(" ");
        }
        bw.flush();
        bw.close();
    }
}
