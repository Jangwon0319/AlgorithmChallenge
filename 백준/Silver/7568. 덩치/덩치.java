import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받을 사람 수
        int n = Integer.parseInt(br.readLine());

        // 키와 몸무게를 저장할 배열
        int[][] arr = new int[n][2];

        // 키랑 몸무게 저장
        // arr[i][0] : 키 
        // arr[i][1] : 몸무게
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 키 저장
            arr[i][1] = Integer.parseInt(st.nextToken());   // 몸무게 저장
        }

        // Rank 담을 배열
        int[] rank = new int[n];

        // Rank 확인을 위한 반복문
        for (int i = 0; i < n; i++) {
            int count = 1;  // 자신보다 덩치가 큰 사람 카운트 변수
            
            for (int j = 0; j < n; j++) {
                // 키와 몸무게 둘 다 클 경우에만 덩치가 크다라고 정의
                if ((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])) {
                    count++;
                }
            }
            rank[i] = count;
        }

        for (int i : rank) {
            System.out.print(i + " ");
        }

    }
}
