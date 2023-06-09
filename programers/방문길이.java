package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 방문길이 {
    static int[][][] map;
    static int cnt = 0;
    public static void main(String[] args) {
        String dirs = "URURURURURURUR";

        map = new int[11][11][4];
        int x = 5;
        int y = 5;
        for(int i = 0; i < dirs.length(); i++){
            switch (dirs.charAt(i)){
                case 'U':
                    if(y + 1 < 11) {
                        map[y][x][1] = 1;
                        y++;
                        visit(x, y, 0);
                    }
                    break;
                case 'D':
                    if(y - 1 >= 0){
                        map[y][x][0] = 1;
                        y--;
                        visit(x, y, 1);
                    }
                    break;
                case 'R':
                    if(x + 1 < 11) {
                        map[y][x][3] = 1;
                        x++;
                        visit(x, y, 2);
                    }
                    break;
                case 'L':
                    if(x - 1 >= 0) {
                        map[y][x][2] = 1;
                        x--;
                        visit(x, y, 3);
                    }
                    break;
            }
        }
        System.out.println(cnt);
    }
    static void visit(int x, int y, int dir){
        if(map[y][x][dir] == 0)
            cnt++;
        map[y][x][dir] = 1;
    }
}
