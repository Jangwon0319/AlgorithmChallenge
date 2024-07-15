import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 동전 종류의 갯수
        int k = Integer.parseInt(st.nextToken());   // 동전들을 합친 가격

        // 동전의 가치들을 담을 배열
        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 동전의 갯수 최솟값 구하기
        // 큰 동전부터 계산하여 순차적으로 내려온다
        int count = 0;

        for (int i = coin.length - 1; i >= 0; i--) {
            // 만약 동전의 가치와 k의 가격이 같으면 count는 한개만 설정
            if (coin[i] == k){
                count++;
                break;
            }
            else if (coin[i] < k){
                count += k / coin[i];
                k = k % coin[i];
            }

        }

        System.out.println(count);


    }
}
