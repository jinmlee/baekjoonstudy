package programers;

import java.util.*;

public class 수식최대화 {
    static List<String> list = new ArrayList<>();
    static String[] operator = {"+-*", "+*-", "-+*", "-*+", "*-+", "*+-"};
    static long max = 0;
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        String num = "";
        String[] str = expression.split("");
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("+") || str[i].equals("-") || str[i].equals("*")){
                list.add(num);
                num = "";
                list.add(str[i]);
            }else{
                num += str[i];
            }
        }
        list.add(num);
        for(int i = 0; i < operator.length; i++){
            fun(operator[i]);
        }
        System.out.println(max);
    }
    static void fun(String operator){
        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        int idx = 0;
        String[] str = operator.split("");
        for(int i = 0; i < 3; i++){
            while(idx < list2.size()){
                if(str[i].equals(list2.get(idx))){
                    long num = Long.parseLong(list2.remove(idx - 1));
                    String o = list2.remove(idx - 1);
                    Long num2 = Long.parseLong(list2.remove(idx - 1));
                    list2.add(idx - 1, String.valueOf(op(o, num, num2)));
                    idx = 0;
                }else
                    idx++;
            }
            idx = 0;
        }
        long answer = Long.parseLong(list2.get(0));
        if(answer < 0)
            answer *= -1;
        if(max < answer)
            max = answer;

    }
    static long op(String o, long num, long num2){
        long a = 0;
        switch (o){
            case "*":
                a = num * num2;
                break;
            case "-":
                a = num - num2;
                break;
            case "+":
                a = num + num2;
                break;
        }
        return a;
    }
}
