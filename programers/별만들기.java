package programers;

import java.util.LinkedList;
import java.util.Queue;

public class 별만들기 {
    public static void main(String[] args) {
        int[][] line = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
        String[] answer;
        int[][] map;
        long x = 0;
        long y = 0;
        long minX = 1000;
        long minY = 1000;
        long maxX = 0;
        long maxY = 0;

        Queue<XY> q = new LinkedList<>();
        for(x = -500; x <= 500; x++) {
            for(y = -500; y <= 500; y++) {
                int cnt = 0;
                for (int i = 0; i < line.length; i++) {
                    if (line[i][0] * x + line[i][1] * y + line[i][2] == 0)
                        cnt++;
                }
                if(cnt >= 2) {
                    q.add(new XY(x, y));
                    if(x < minX)
                        minX = x;
                    if(y < minY)
                        minY = y;
                    if(x > maxX)
                        maxX = x;
                    if(y > maxY)
                        maxY = y;
                }
            }
        }
        long X = maxX - minX;
        long Y = maxY - minY;
        map = new int[(int)(Y+1)][(int)(X+1)];
        answer = new String[(int)(Y+1)];
        String[][] copy = new String[(int)(Y + 1)][(int)(X + 1)];

        while(!q.isEmpty()){
            long qx = q.peek().x;
            long qy = q.peek().y;
            q.poll();
            map[(int)(qy - minY)][(int)(qx - minX)] = 1;
        }

        for(int i = 0; i <= Y; i++){
            for(int j = 0; j <= X; j++){
                if(map[i][j] == 1)
                    copy[(int)(Y - i)][(int)(X - j)] = "*";
                else
                    copy[(int)(Y - i)][(int)(X - j)] = ".";
            }
            answer[(int)(Y - i)] = String.join("",copy[(int)(Y - i)]);
        }

        for(int i = 0; i <= Y; i++){
            System.out.println(answer[i]);
        }


    }
    static class XY{
        long x;
        long y;
        public XY(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
}
