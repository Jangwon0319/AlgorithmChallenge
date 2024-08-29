import java.io.*;
import java.util.*;

public class Main {

    static int[][] farm;
    static boolean[][] visited;
    static int m, n, k;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && farm[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            n = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

            farm = new int[m][n];
            visited = new boolean[m][n];

            // 배추 위치 입력받기
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1; // 배추가 심어져 있는 위치를 1로 표시
            }

            int wormCount = 0; // 필요한 벌레 수 (배추 그룹의 수)

            // 모든 위치를 순회하면서 배추 그룹 찾기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) { // 배추가 있고 방문하지 않았으면
                        DFS(i, j); // DFS로 연결된 모든 배추 방문
                        wormCount++; // 새로운 배추 그룹 발견
                    }
                }
            }

            // 결과 출력
            System.out.println(wormCount);
        }
    }
}
