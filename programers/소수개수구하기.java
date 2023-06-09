package programers;

import java.util.Stack;

public class 소수개수구하기 {
    public static void main(String[] args) {
        int n = 4;
        int k = 10;
        int answer = 0;

        long idx = 0;
        Stack<Integer> stack = new Stack<>();

        while(n > 0){
            stack.push(n % k);
            n /= k;
            idx++;
        }
        long number = 0;
        while(!stack.isEmpty()){
            long num = stack.pop();
            if(num != 0){
                if(number == 0)
                    number = num;
                else
                    number = number*10 + num;
            }else{
                answer += fun(number);
                number = 0;
            }
        }
        answer += fun(number);

        System.out.println(answer);

    }
    static int fun(long number){
        if(number <= 1)
            return 0;
        if(number == 2)
            return 1;
        long i = 2;
        while (i * i <= number){
            if(number % i == 0){
                return 0;
            }
            i++;
        }
        return 1;
    }
}
