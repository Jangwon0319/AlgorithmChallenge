import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];    // M : 가로 길이, N : 세로 길이
        visited = new boolean[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            StringTokenizer point = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(point.nextToken());
            int r = Integer.parseInt(point.nextToken());

            map[r][c] = 1;  // 쓰레기가 있는 좌표 위치
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = DFS(i, j);
                    temp.add(size);
                }
            }
        }

        if (!temp.isEmpty()) {
            System.out.println(Collections.max(temp));
        } else {
            System.out.println(0);
        }
    }

    public static int DFS(int x, int y) {
        visited[x][y] = true;
        int count = 1;  // 쓰레기 수

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= M && ny <= N && !visited[nx][ny] && map[nx][ny] == 1) {
                count += DFS(nx, ny);
            }
        }
        return count;
    }
}
