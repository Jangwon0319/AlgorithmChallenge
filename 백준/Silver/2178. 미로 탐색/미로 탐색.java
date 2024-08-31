import java.io.*;
import java.util.*;

public class Main {
    static int[][] miro;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int nx, ny;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 미로 세로 길이
        M = Integer.parseInt(st.nextToken());   // 미로 가로 길이

        // 미로 배열 초기화 및 선언
        miro = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = line.charAt(j-1) - '0';
            }
        }

        visited = new boolean[N + 1][M + 1];

        System.out.println(BFS(1,1));
        
    }

    public static int BFS(int x, int y) {
        Deque<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 4; i++) {
                nx = cx + dx[i];
                ny = cy + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= M && !visited[nx][ny] && miro[nx][ny] == 1) {
                    visited[nx][ny] = true; // 다음 위치 큐에 추가
                    queue.offer(new Point(nx, ny));
                    miro[nx][ny] = miro[cx][cy] + 1;    // 이전 거리에 1 증가
                }
            }
        }
        return miro[N][M];
    }
}
