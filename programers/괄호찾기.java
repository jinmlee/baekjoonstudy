package programers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 괄호찾기 {
    public static void main(String[] args) {
        String s = "[](){}";
        int answer = 0;
        String[] str = s.split("");
        List<String> l = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            l.add(str[i]);
        }

        for (int i = 0; i < s.length(); i++) {
            l.add(l.remove(0));
            for(int j = 0; j < s.length(); j++){
                if(!stack.isEmpty()){
                    switch(l.get(j)){
                        case "]":
                            if(stack.peek().equals("["))
                                stack.pop();
                            break;
                        case ")":
                            if(stack.peek().equals("("))
                                stack.pop();
                            break;
                        case "}":
                            if(stack.peek().equals("{"))
                                stack.pop();
                            break;
                        default :
                            stack.push(l.get(j));
                    }
                }
                else
                    stack.push(l.get(j));
            }
            if(stack.isEmpty())
                answer++;
            stack.clear();
        }
        System.out.println(answer);
    }
}
