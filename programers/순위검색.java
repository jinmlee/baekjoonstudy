package programers;

public class 순위검색 {
    public static void main(String[] args) {
        int[] answer;
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        answer = new int[info.length];
        String[][] infoStr = new String[info.length][5];
        String[][] queryStr = new String[query.length][5];

        for(int i = 0; i < info.length; i++){
            String[] str = info[i].split(" ");
            String[] str1 = query[i].split(" and ");
            String[] s = str1[3].split(" ");
            for(int j = 0; j < 5; j++){
                infoStr[i][j] = str[j];
                if(j < 4)
                    queryStr[i][j] = str1[j];
                else {
                    queryStr[i][3] = s[0];
                    queryStr[i][4] = s[1];
                }
            }
        }

        for(int i = 0; i < info.length; i++){
            int cnt = 0;
            for(int j = 0; j < info.length; j++){
                int num = Integer.parseInt(queryStr[i][4]);
                int num1 = Integer.parseInt(infoStr[j][4]);
                if(num > num1)
                    continue;
                int k;
                for(k = 0; k < 4; k++){
                    if(queryStr[i][k].equals("-"))
                        continue;
                    if(queryStr[i][k].charAt(0) != infoStr[j][k].charAt(0))
                        break;
                }
                if(k == 4)
                    cnt++;
            }
            answer[i] = cnt;
        }

        for(int i = 0; i < info.length; i++){
            System.out.println(answer[i]);
        }
    }
}
