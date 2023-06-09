package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15683 {
    static int X;
    static int Y;
    static int box[][];
    static int visit[][];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dx2 = {1, 0, -1, 0};
    static int[] dy2 = {0, -1, 0, 1};
    static int cnt;
    static int max = 0;
    static Queue<cctv> q = new LinkedList<>();
    static Queue<cctv> reset = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        Y = Integer.parseInt(str[0]);
        X = Integer.parseInt(str[1]);

        box = new int[Y][X];
        visit = new int[Y][X];
        int cctvCnt = 0;

        for(int y = 0; y < Y; y++){
            str = br.readLine().split(" ");
            for(int x = 0; x < X; x++){
                box[y][x] = Integer.parseInt(str[x]);
                if(box[y][x] > 0 && box[y][x] != 6) {
                    q.add(new cctv(x, y));
                }
                if(box[y][x] > 0)
                    cctvCnt++;
            }
        }
        setBox();
        System.out.println(Y*X - (cctvCnt + max));

    }

    static void setBox(){

        if(q.isEmpty())
            return;
        int x = q.peek().x;
        int y = q.peek().y;

        q.poll();
        switch (box[y][x]) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    setCCTV(x, y, dx[i], dy[i]);
                    setBox();
                    setReset();
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    setCCTV(x, y, dx[i], dx[i]);
                    setCCTV(x, y, dx[i + 2], dy[i + 2]);
                    setBox();
                    setReset();
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    setCCTV(x, y, dx[i], dy[i]);
                    setCCTV(x, y, dx2[i], dy2[i]);
                    setBox();
                    setReset();
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (j == i)
                            continue;
                        setCCTV(x, y, dx[j], dy[j]);
                    }
                    setBox();
                    setReset();
                }
                break;
            case 5:
                for (int i = 0; i < 4; i++)
                    setCCTV(x, y, dx[i], dy[i]);
                setBox();
                setReset();
                break;
        }
    }

    static void setCCTV(int x, int y, int dx, int dy){
        if(x + dx >= 0 && x + dx < X && y + dy >= 0 && y + dy < Y) {
            if(box[y + dy][x + dx] == 0) {
                box[y + dy][x + dx] = -1;
                cnt++;
             //   System.out.println(cnt);
                if(cnt > max)
                    max = cnt;
                reset.add(new cctv(x + dx, y + dy));
                setCCTV(x + dx, y + dy, dx, dy);
            }
        }
    }

    static void setReset(){
        while(!reset.isEmpty()){
            int x = reset.peek().x;
            int y = reset.peek().y;
            box[y][x] = 0;
            cnt--;
            reset.poll();
        }
    }

    static class cctv{
        int x, y;
        public cctv(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
