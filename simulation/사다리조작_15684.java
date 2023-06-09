package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사다리조작_15684 {
    static int[][] map;
    static int[][] visit;
    static int Y,X;
    static int min = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        X = Integer.parseInt(str[0]) + 1;
        int N = Integer.parseInt(str[1]);
        Y = Integer.parseInt(str[2]) + 1;

        map = new int[Y][X];
        visit = new int[Y][X];
        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            int y = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            map[y][x] = 1;
            visit[y][x]++;
            visit[y][x + 1]++;
            visit[y][x - 1]++;
        }

        move(1, 1, 0);
        if(min > 3)
            min = -1;
        System.out.println(min);
    }


    static void move(int x, int y, int cnt){
        if(cnt > 3)
            return;
        if(x == X - 1){
            y++;
            x = 1;
        }
        if(y == Y){
            int i;
            for(i = 1; i < X; i++){
                if(check(i) == 1)
                    break;
            }
            if(i == X){
                if(min > cnt)
                    min = cnt;
            }
            return;
        }
        if(visit[y][x] == 0){
            for(int i = 0; i <= 1; i++){
                if(i == 1) {
                    map[y][x] = 1;
                    visit[y][x]++;
                    visit[y][x - 1]++;
                    visit[y][x + 1]++;
                    move(x + 1, y, cnt + 1);
                    visit[y][x - 1]--;
                    visit[y][x + 1]--;
                    visit[y][x]--;
                    map[y][x] = 0;
                }
                else{
                    move(x + 1, y, cnt);
                }
            }
        }else{
            move(x + 1, y, cnt);
        }

    }

    static int check(int number){
        int line = number;
        for(int i = 1; i < Y; i++){
            if(map[i][line] == 1){
                line++;
            }
            else if(map[i][line - 1] == 1)
                line--;
        }
        if(line == number)
            return 0;
        return 1;
    }
}
