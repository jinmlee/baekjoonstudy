package programers;

import java.util.*;

public class 뒤에있는_큰수_찾기 {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = new int[numbers.length];


        for(int i = numbers.length -1; i >= 0; i--){
            while(!stack.isEmpty() && numbers[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()) {
                answer[i] = -1;
                stack.push(numbers[i]);
                continue;
            }
            answer[i] = stack.peek();
            stack.push(numbers[i]);
        }

        for(int i = 0; i < numbers.length; i++){
            System.out.println(answer[i]);
        }
    }


    static class number{
        int me;
        int back;
        public number(int me, int back){
            this.me = me;
            this.back = back;
        }
    }
}
