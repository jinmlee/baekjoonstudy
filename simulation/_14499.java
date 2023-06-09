package simulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14499 {
    static Queue<Integer> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);
        int y = Integer.parseInt(str[3]);
        int moveCnt = Integer.parseInt(str[4]);

        map = new int[N][M];
        dice = new int[4][3];
        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < str.length; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        str = br.readLine().split(" ");
        for(int i = 0; i < moveCnt; i++){
            int direction = Integer.parseInt(str[i]);
            if(x + dx[direction - 1] >= 0 && x + dx[direction - 1] < M && y + dy[direction - 1] >= 0 && y + dy[direction - 1] < N) {
                x += dx[direction - 1];
                y += dy[direction - 1];
                diceMove(direction);
                if (map[y][x] == 0) {
                    map[y][x] = dice[1][1];
                } else {
                    dice[1][1] = map[y][x];
                    map[y][x] = 0;
                }
                q.add(dice[3][1]);
            }
        }
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }

    static void diceMove(int d){
        if(d == 3) {
            int num = dice[3][1];
            for (int i = 3; i > 0; i--) {
                dice[i][1] = dice[i-1][1];
            }
            dice[0][1] = num;
        }
        if(d == 4){
            int num = dice[0][1];
            for(int i = 0; i < 3; i++){
                dice[i][1] = dice[i+1][1];
            }
            dice[3][1] = num;
        }
        if(d == 2){
            int num = dice[1][2];
            for(int i = 2; i > 0; i--){
                dice[1][i] = dice[1][i - 1];
            }
            dice[1][0] = dice[3][1];
            dice[3][1] = num;
        }
        if(d == 1){
            int num = dice[1][0];
            for(int i = 0; i < 2; i++){
                dice[1][i] = dice[1][i+1];
            }
            dice[1][2] = dice[3][1];
            dice[3][1] = num;
        }
    }
}
