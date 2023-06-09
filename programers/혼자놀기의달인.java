package programers;

public class 혼자놀기의달인 {
    static int cardsLen = 0;
    static int max = 0;
    static int[] copy;
    static int[] visit;
    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        int answer = 0;

        copy = cards;
        cardsLen = cards.length;
        open();

        System.out.println(max);
    }


    static void open(){
        for(int i = 0; i < cardsLen; i++){
            visit = new int[cardsLen];
            int first = 0;
            int idx = i;
            while(visit[idx] == 0){
                visit[idx] = 1;
                first++;
                idx = copy[idx] - 1;
            }
            for(int j = i + 1; j < cardsLen; j++){
                if(visit[j] != 0)
                    continue;
                int[] copyVisit = new int[cardsLen];
                for(int p = 0; p < cardsLen; p++){
                    copyVisit[p] = visit[p];
                }
                int second = 0;
                int idx2 = j;
                while(copyVisit[idx2] == 0){
                    copyVisit[idx2] = 1;
                    second++;
                    idx2 = copy[idx2] - 1;
                }
                if(first * second > max)
                    max  = first * second;
            }
        }
    }
}
