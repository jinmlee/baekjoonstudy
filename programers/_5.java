package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _5 {
    static int max = 10000000;
    static Stack<stone> stack = new Stack<>();
    static int idx = 0;

    public static void main(String[] args) {
        int[] picks = {1, 0, 1};
        String[] minerals = {"stone","stone","stone","stone","stone", "diamond", "diamond", "diamond", "diamond", "diamond"};
        int cnt = 0;

        for(int i = minerals.length - 1; i >= 0 ; i--){
            stack.push(new stone(minerals[i]));
        }
        for(int i = 0; i < 3; i++){
            cnt += picks[i];
        }

        op(cnt, picks, 0);

        System.out.println(max);
    }

    static void op(int cnt, int[] picks, int answer) {
        Stack<stone> remove = new Stack<>();

        if (cnt == 0 || stack.isEmpty()) {
            if(answer < max)
                max = answer;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int count = 0;
            if (picks[i] == 0)
                continue;
            picks[i]--;
            for(int j = 0; j < 5; j++){
                if(stack.isEmpty())
                    break;
                count += stack.peek().count[i];
                remove.push(stack.pop());
            }
            answer += count;
            op(cnt - 1, picks, answer);
            picks[i]++;
            while(!remove.isEmpty()){
                stack.push(remove.pop());
            }
            answer -= count;
        }
    }

    static class stone{
        String name;
        int[] count;
        public stone(String name){
            this.name = name;
            switch (name){
                case "diamond":
                    int[] count = {1, 5, 25};
                    this.count = count;
                    break;
                case "iron":
                    int[] count2 = {1, 1, 5};
                    this.count = count2;
                    break;
                case "stone":
                    int[] count3 = {1, 1, 1};
                    this.count = count3;
                    break;
            }
        }
    }
}
