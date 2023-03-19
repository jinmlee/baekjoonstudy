import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_6198 {

    static class garden{
        int idx;
        int height;

        public garden(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<garden> view = new Stack<>();
        long viewCount = 0;

        for(int i = n; i > 0; i--){
            int height = Integer.parseInt(br.readLine());
            while(!view.isEmpty()){
                if(view.peek().height <= height){
                    viewCount += view.peek().idx - i;
                    view.pop();
                }
                else
                    break;
            }
            view.push(new garden(i - 1, height));
        }

        while(!view.isEmpty()){
            viewCount += view.pop().idx;
        }

        System.out.println(viewCount);
    }
}
