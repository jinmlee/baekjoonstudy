package programers;

import java.util.*;

class Solution {
    public static void main(String[] args) {

        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] answer = new String[plans.length];
        int idx = 0;

        Queue<study> q = new LinkedList<>();
        Stack<study> stack = new Stack<>();
        Arrays.sort(plans, Comparator.comparing((String[] o) -> o[1]));

        int now = 0;

        for(int i = 0; i < plans.length; i++){
            q.add(new study(plans[i]));
        }

        while(!q.isEmpty() || !stack.isEmpty()){
            if(stack.isEmpty()){
                stack.push(q.poll());
                now = stack.peek().time;
            }
            else if(q.isEmpty()){
                answer[idx++] = stack.pop().name;
            }
            else{
                if(now + stack.peek().playTime > q.peek().time){
                    stack.peek().playTime -= q.peek().time - now;
                    now = q.peek().time;
                    stack.push(q.poll());
                }
                else{
                    answer[idx++] = stack.peek().name;
                    now += stack.pop().playTime;
                }
            }
        }
        for(int i = 0; i < plans.length; i++){
            System.out.println(answer[i]);
        }
    }
    static class study{
        String name;
        int time;
        int playTime;
        public study(String[] plans){
            this.name = plans[0];
            String[] str = plans[1].split(":");
            this.time = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
            this.playTime = Integer.parseInt(plans[2]);
        }
    }
}