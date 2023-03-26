import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_6549 {
    static class top{
        long stick;
        long cnt;
        public top(long stick, long cnt){
            this.stick = stick;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<top> stack = new Stack<>();

        String[] str = br.readLine().split(" ");
        long count;
        int n = Integer.parseInt(str[0]);
        while(true){
            if(n == 0)
                break;
            long max = 0;
            for(int i = 1; i <= n; i++){
                int num = Integer.parseInt(str[i]);
                count = 1;

                while(!stack.isEmpty()){
                    if(stack.peek().stick >= num){
                        if(max < stack.peek().stick * (stack.peek().cnt + count - 1))
                            max = stack.peek().stick * (stack.peek().cnt + count - 1);
                        count += stack.peek().cnt;
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                stack.push(new top(num, count));
                if(max < stack.peek().stick * stack.peek().cnt)
                    max = stack.peek().stick * stack.peek().cnt;

            }
            count = 0;
            while(!stack.isEmpty()){
                if(max < stack.peek().stick * (stack.peek().cnt + count))
                    max = stack.peek().stick * (stack.peek().cnt + count);
                count += stack.peek().cnt;
                stack.pop();
            }
            System.out.println(max);

            str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
        }
    }
}
