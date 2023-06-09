package programers;

import java.util.*;

public class 귤고르기 {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        Arrays.sort(tangerine);
        Stack<orange> q = new Stack<>();
        q.add(new orange(tangerine[0], 1));

        for(int i = 1; i < tangerine.length; i++){
            if(q.peek().size == tangerine[i]){
                q.peek().cnt++;
            }else{
                q.add(new orange(tangerine[i], 1));
            }
        }

        PriorityQueue<orange> q2 = new PriorityQueue<>(Comparator.comparing(o -> o.cnt));
        while(!q.isEmpty()){
            q2.add(q.pop());
        }

        Stack<orange> stack = new Stack<>();
        while(!q2.isEmpty()){
            stack.push(q2.poll());
        }

        int count = 0;
        int max = 0;
        while(max < k){
            max += stack.pop().cnt;
            count++;
        }


        System.out.println(count);


    }
    static class orange{
        int size;
        int cnt;
        public orange(int size, int cnt){
            this.size = size;
            this.cnt = cnt;
        }
    }
}
