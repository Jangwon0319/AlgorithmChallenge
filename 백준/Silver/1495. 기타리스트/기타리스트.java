import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken()); // 최대 볼륨

        int[] volumes = new int[N + 1]; // 볼륨 조정 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1]; // DP 테이블
        dp[0][S] = true; // 시작 볼륨 설정

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) { // 이전 곡의 볼륨이 j일 때 가능한 경우
                    if (j + volumes[i] <= M) {
                        dp[i][j + volumes[i]] = true; // 볼륨 증가
                    }
                    if (j - volumes[i] >= 0) {
                        dp[i][j - volumes[i]] = true; // 볼륨 감소
                    }
                }
            }
        }

        int result = -1; // 가능한 최대 볼륨을 저장할 변수
        for (int j = 0; j <= M; j++) {
            if (dp[N][j]) { // 마지막 곡에서 가능한 볼륨이 있는 경우
                result = Math.max(result, j);
            }
        }

        System.out.println(result); // 결과 출력
    }
}
