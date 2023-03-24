import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_3015 {
    static class people{
        int height;
        int cnt;

        public people(int height, int cnt){
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long count = 0;
        Stack<people> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            int cnt = 1;
            while(!stack.isEmpty()){
                if(stack.peek().height == num){
                    count += stack.peek().cnt;
                    cnt += stack.pop().cnt;
                }
                else if(stack.peek().height < num){
                    count += stack.pop().cnt;
                }
                else
                    break;
            }
            if(!stack.isEmpty())
                count++;
            stack.push(new people(num, cnt));

        }

        System.out.println(count);
    }
}