package programers;

public class 전력망둘로나누기 {
    static int[] visit;
    static int[] ok;
    static int cnt = 0;
    static int max = 10000000;
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        for(int j = 0; j < wires.length; j++) {
            visit = new int[n + 1];
            ok = new int[n + 1];
            cnt = 1;
            ok[wires[0][0]] = 1;
            visit[j] = 1;
            go(wires);
            if(max > op(n, cnt))
                max = op(n, cnt);
        }
        System.out.println(max);
    }
    static int op(int n, int cnt){
       int num = n - cnt;
       num -= cnt;
       if(num < 0)
           num *= -1;
       return num;
    }

    static void go(int[][] wires){
        for(int i = 0; i < wires.length; i++){
            if(visit[i] == 1)
                continue;
            if(ok[wires[i][0]] == 1 || ok[wires[i][1]] == 1){
                visit[i] = 1;
                ok[wires[i][0]] = 1;
                ok[wires[i][1]] = 1;
                cnt++;
                go(wires);
            }
        }
    }
}
