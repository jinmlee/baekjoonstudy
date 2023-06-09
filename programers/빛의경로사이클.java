package programers;

import java.util.LinkedList;
import java.util.*;

public class 빛의경로사이클 {
    static int[] px = {0, 1, 0, -1};
    static int[] py = {1, 0, -1, 0};
    static int[][][] visit;
    static String[][] map;
    static int width = 0;
    static int length = 0;
    public static void main(String[] args) {

        int[] answer;
        String[] grid =  {"SS","SS"};
        Queue<Integer> q = new LinkedList<>();
        width = grid[0].length();
        length = grid.length;

        map = new String[length][width];
        visit = new int[length][width][4];
        for(int i = 0; i < length; i++){
            String[] str = grid[i].split("");
            for(int j = 0; j < str.length; j++){
                map[i][j] = str[j];
            }
        }

       for(int y = 0; y < length; y++){
           for(int x = 0; x < width; x++){
               for(int i = 0; i < 4; i++){
                   if(visit[y][x][i] == 0){
                       q.add(go(y, x, i, 0));
                   }
               }
           }
       }

        answer = new int[q.size()];
        int idx = 0;
        while(!q.isEmpty()){
            answer[idx] = q.poll();
            idx++;
        }
        Arrays.sort(answer);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }

    }

    static int go(int y, int x, int p, int cnt){
        while (visit[y][x][p] == 0) {
            visit[y][x][p] = 1;
            cnt++;
            switch (map[y][x]) {
                case "R":
                    p++;
                    if (p == 4)
                        p = 0;
                    break;
                case "L":
                    p--;
                    if (p == -1)
                        p = 3;
                    break;
                case "S":
            }
            y += py[p];
            x += px[p];
            if (x == width)
                x = 0;
            if (x == -1)
                x = width - 1;
            if (y == length)
                y = 0;
            if (y == -1)
                y = length - 1;
        }
        return cnt;
    }
}
