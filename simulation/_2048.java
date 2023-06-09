package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2048{
    static int N;
    static int[][] map;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int y = 0; y < N; y++){
            String[] str = br.readLine().split(" ");
            for(int x = 0; x < N; x++){
                map[y][x] = Integer.parseInt(str[x]);
            }
        }
        mainFun(5);
        System.out.println(max);
    }
    
    static  void mainFun(int cnt){
        if(cnt == 0){
            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    if(max < map[y][x])
                        max = map[y][x];
                }
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    System.out.print(map[y][x] + " ");
                }
                System.out.println();
            }
            System.out.println();
            int[][] copyMap = map.clone();
            rotate(i);
            move();
            mainFun(cnt - 1);
            map = copyMap.clone();
        }
        
    }
    
    static void rotate(int cnt) {
        int i = 0;

        while (i < cnt) {
            int[][] copy = new int[N][N];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    copy[x][N - y - 1] = map[y][x];
                }
            }
            map = copy;
            i++;
        }
    }

    static void move(){
        for(int y = 0; y < N; y++){
            int idx = 0;
            int copy2[] = new int[N];
            for(int x = 0; x < N; x++) {
                if (map[y][x] == 0)
                    continue;
                if (idx < N) {
                    if (copy2[idx] == 0) {
                        copy2[idx] = map[y][x];
                        map[y][x] = 0;
                    }
                    else if (copy2[idx] == map[y][x]) {
                        copy2[idx] *= 2;
                        map[y][x] = 0;
                        idx++;
                    } else {
                        idx++;
                        copy2[idx] = map[y][x];
                        map[y][x] = 0;
                    }
                }
            }
            for(int i = 0; i < N; i++){
                map[y][i] = copy2[i];
            }
        }
    }
}