import java.io.*;
import java.util.*;

public class Main {

    static int M, N, K;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int nx, ny;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // 가로 길이
            N = Integer.parseInt(st.nextToken());   // 세로 길이
            K = Integer.parseInt(st.nextToken());   // 배추의 위치 개수

            // 배추의 위치 초기화
            farm = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                StringTokenizer location = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(location.nextToken());
                int y = Integer.parseInt(location.nextToken());
                farm[x][y] = 1;
            }

            int wormCount = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (farm[j][k] == 1 && !visited[j][k]) {
                        wormCount++;
                        DFS(j, k);
                    }
                }
            }
            System.out.println(wormCount);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && farm[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
}
