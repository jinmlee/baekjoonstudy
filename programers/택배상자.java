package programers;

import java.util.LinkedList;
import java.util.Stack;
import java.util.*;

public class 택배상자 {
    public static void main(String[] args) {
        int answer = 0;
        int[] order = {4, 3, 1, 2, 5};
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= order.length; i++){
            q.add(i);
        }

        int idx = 0;
        while(!q.isEmpty()){
            int num = q.poll();

            if(num == order[idx]){
                answer++;
                idx++;
            }else
                stack.push(num);
            if(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                answer++;
                idx++;
            }
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            if(num == order[idx]){
                answer++;
                idx++;
            }else
                break;
        }


        System.out.println(answer);
    }
}
