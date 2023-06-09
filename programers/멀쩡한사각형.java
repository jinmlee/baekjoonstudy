package programers;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        long w = 8;
        long h = 12;
        long answer = 0;
        double line = (double)h / w;
        double hight = 1;
        for(double i = 1; i < w; i++){
            while (hight / i <= line)
                hight++;
            answer += hight - 1;
        }
        answer *= 2;

        System.out.println(answer);
    }
}
