package programers;

public class 연속부분수열의합개수 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        int answer = 0;

        int[] visit = new int[1000001];
        for(int i = 0; i < elements.length; i++){
            for(int j = 0 ; j < elements.length; j++){
                int num = 0;
                for(int k = 0; k <= i; k++){
                    int idx = j + k;
                    if(idx >= elements.length)
                        idx -= elements.length;
                    num += elements[idx];
                }
                if(visit[num] == 0){
                    visit[num]++;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
