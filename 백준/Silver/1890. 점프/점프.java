import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임판 넓이 N x N
        int N = Integer.parseInt(br.readLine());

        // 게임판 2차원 배열 선언 및 초기화
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int next = board[i][j];
                if (next == 0){
                    break;
                }

                if (j + next < N){
                    dp[i][j+next] += dp[i][j];
                }
                if (i + next < N){
                    dp[i+next][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);

    }
}
