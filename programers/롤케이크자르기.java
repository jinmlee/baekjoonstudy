package programers;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        int answer = 0;

        int[] left = new int[10000];
        int[] right = new int[10000];
        int leftCnt = 0;
        int rightCnt = 0;


        for(int i = 0; i < topping.length; i++){
            if(right[topping[i]] == 0)
                rightCnt++;
            right[topping[i]]++;
        }

        for(int i = 0; i < topping.length; i++){
            if(left[topping[i]] == 0)
                leftCnt++;
            left[topping[i]]++;
            right[topping[i]]--;
            if(right[topping[i]] == 0)
                rightCnt--;

            if(leftCnt == rightCnt)
                answer++;
        }
        System.out.println(answer);
    }
}
