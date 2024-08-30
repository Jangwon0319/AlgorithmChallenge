import java.io.*;
import java.util.*;

public class Main {

    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수빈 위치
        int K = Integer.parseInt(st.nextToken());   // 동생 위치

        if (N == K) {
            System.out.println(0);
            return;
        }

        BFS(N, K);

    }
    public static void BFS(int N, int K) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;


        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = cur - 1;
                }
                else if (i == 1) {
                    next = cur + 1;
                }
                else {
                    next = cur * 2;
                }

                // next가 범위를 벗어나지 않고 방문하지 않은 경우 처리
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    if (next == K) {
                        System.out.println(visited[cur]);
                        return;
                    }

                    queue.offer(next);
                    visited[next] = visited[cur] + 1; 
                }
            }

        }
    }
}
