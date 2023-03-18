import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_2493 {

    static class top {
        int index;
        int height;

        public top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Stack<top> stack = new Stack<>();

        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(str[i - 1]);
            while(!stack.isEmpty()){
                if(stack.peek().height > num){
                    System.out.print(stack.peek().index + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }
            stack.push(new top(i, num));
        }
    }
}
