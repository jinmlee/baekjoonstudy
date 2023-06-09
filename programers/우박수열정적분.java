package programers;

public class 우박수열정적분 {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
        double[] answer;

        answer = new double[ranges.length];

        double[] num = new double[10000];
        num[0] = (double)k;
        int idx = 1;
        double dk = (double)k;

        while(dk > 1){
            if(dk % 2 == 0){
                dk = dk / 2;
                num[idx] = dk;
                idx++;
            }else{
                dk = dk * 3 + 1;
                num[idx] = dk;
                idx++;
            }
        }
        System.out.println(idx);
        double[] weight = new double[idx];
        for(int i = 0; i < idx - 1; i++){
            double max = Math.max(num[i], num[i+1]);
            double min = Math.min(num[i], num[i+1]);


            weight[i] = min + (max-min)/2;
        }
        idx--;
        for(int i = 0; i < ranges.length; i++){
            if(ranges[i][0] == idx + ranges[i][1])
                answer[i] = 0;
            else if(ranges[i][0] > idx + ranges[i][1])
                answer[i] = -1;
            else{
                for(int j = ranges[i][0]; j < idx + ranges[i][1]; j++){
                    answer[i] += weight[j];
                }
            }
        }

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
