import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 총 봉지 갯수
        int result = Integer.MAX_VALUE;


        int x = n / 5;
        int y = n / 3;

        for (int i = 0 ; i <= x ; i++){
            for (int j = 0 ; j <= y ; j++){
                if (n == (5 * i + 3 * j)){
                    int temp = i + j;
                    result = Math.min(result, temp);
                    break;
                }
                else if (n < (5 * i + 3 * j))
                    break;
            }
        }
        if (result == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(result);
    }
}
