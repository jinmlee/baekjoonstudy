package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 경사로_14890 {
    static int map[][];
    static int visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int jump = Integer.parseInt(str[1]);
        map = new int[N][N];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i = 0; i < N; i++){
            visit = new int[N][N];
            int j = 0;
            for(j = 0; j < N - 1; j++){
                if(map[i][j] != map[i][j + 1]) {
                    if(move(i, j, jump, N) == 0)
                        break;
                }
            }
            if(j == N - 1)
                cnt++;
        }
        for(int i = 0; i < N; i++){
            visit = new int[N][N];
            int j = 0;
            for(j = 0; j < N - 1; j++){
                if(map[j][i] != map[j + 1][i]) {
                    if(move2(j, i, jump, N) == 0)
                        break;
                }
            }
            if(j == N - 1)
                cnt++;
        }

        System.out.println(cnt);

    }
    static int move(int y, int x, int jump, int N){
        int check = map[y][x] - map[y][x + 1];
        if(check >= 2 || check <= -2)
            return 0;
        if(check > 0){
            x++;
            if(visit[y][x] == 1)
                return 0;
            visit[y][x] = 1;
            for(int i = 0; i < jump - 1; i++){
                if(x + i + 1 >= N || map[y][x + i] != map[y][x + i + 1] || visit[y][x + i + 1] == 1)
                    return 0;
                visit[y][x + i + 1] = 1;
            }
        }else{
            if(visit[y][x] == 1)
                return 0;
            visit[y][x] = 1;
            for(int i = 0; i < jump - 1; i++){
                if(x - i - 1 < 0 || map[y][x - i] != map[y][x - i - 1] || visit[y][x - i - 1] == 1)
                    return 0;
                visit[y][x - i - 1] = 1;
            }
        }
        return 1;
    }



    static int move2(int y, int x, int jump, int N){
        int check = map[y][x] - map[y + 1][x];
        if(check >= 2 || check <= -2)
            return 0;
        if(check > 0){
            y++;
            if(visit[y][x] == 1)
                return 0;
            visit[y][x] = 1;
            for(int i = 0; i < jump - 1; i++){
                if(y + i + 1 >= N || map[y + i][x] != map[y + i + 1][x] || visit[y + i + 1][x] == 1)
                    return 0;
                visit[y + i + 1][x] = 1;
            }
        }else{
            if(visit[y][x] == 1)
                return 0;
            visit[y][x] = 1;
            for(int i = 0; i < jump - 1; i++){
                if(y - i - 1 < 0 || map[y - i][x] != map[y - i - 1][x] || visit[y - i - 1][x] == 1)
                    return 0;
                visit[y - i - 1][x] = 1;
            }
        }
        return 1;
    }
}
