package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14891 {
    static int[][] topni = new int[4][8];
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str;
        for(int i = 0; i < 4; i++){
            str = br.readLine().split("");
            for(int j = 0; j < 8; j++){
                topni[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            visit = new int[5];
            str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]) - 1;
            int direction = Integer.parseInt(str[1]);
            move(num, direction);
        }
        int answer = 0;
        int score = 1;

        for(int i = 0; i < 4; i++){
             if(topni[i][0] == 1)
                 answer += score;
             score *= 2;
        }
        System.out.println(answer);
    }

    static void move(int num, int d){
        visit[num] = 1;
        if(d == 1){
            int temp = topni[num][7];
            for(int i = 7; i > 0; i--){
                topni[num][i] = topni[num][i - 1];
            }
            topni[num][0] = temp;
            if(num + 1 < 4 && visit[num + 1] == 0 && topni[num][3] != topni[num + 1][6]){
                move(num + 1, -1);
            }
            if(num - 1 >= 0 && visit[num - 1] == 0 && topni[num][7] != topni[num - 1][2]){
                move(num - 1, -1);
            }
        }
        else{
            int temp = topni[num][0];
            for(int i = 0; i < 7; i++){
                topni[num][i] = topni[num][i+1];
            }
            topni[num][7] = temp;
            if(num + 1 < 4 && visit[num + 1] == 0 && topni[num][1] != topni[num + 1][6]){
                move(num + 1, 1);
            }
            if(num - 1 >= 0 && visit[num - 1] == 0 && topni[num][5] != topni[num - 1][2]){
                move(num - 1, 1);
            }
        }
    }
}
