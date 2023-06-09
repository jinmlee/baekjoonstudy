package programers;

public class 양궁대회 {
    static int[] maxOne = new int[11];
    static int[] copy = new int[11];
    static int max = 0;
    static int scoreMax = 0;
    public static void main(String[] args) {
        int n = 10;
        int[] info = {0,0,0,0,0,0,0,0,3,4,3};
        int[] answer;

        run(n, info);

        if(max == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = maxOne;
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }

    }

    static void run(int cnt, int[] info){
        if(cnt <= 0){
            int infoScore = 0;
            int Score = 0;
            for(int i = 0; i < 11; i++){
                if(copy[i] > 0)
                    Score += 10 - i;
                else if(info[i] > 0)
                    infoScore += 10 - i;
            }
           if(max < Score - infoScore) {
               max = Score - infoScore;
               for (int i = 0; i < 11; i++) {
                   maxOne[i] = copy[i];
               }
           }else if(max == Score - infoScore && Score > scoreMax){
               scoreMax = Score;
               for (int i = 0; i < 11; i++) {
                   maxOne[i] = copy[i];
               }
           }
            return;
        }
        for(int i = 0; i < 11; i++){
            if(copy[i] > 0)
                continue;
            if(i == 10){
                copy[i] = cnt;
                cnt = 0;
            }
            else if(cnt >= info[i] + 1){
                copy[i] = info[i] + 1;
                cnt -= info[i] + 1;
            }
            else
                continue;
            run(cnt, info);
            cnt += info[i] + 1;
            copy[i] = 0;
        }
    }
}
