import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void DFS(int node) {
        // 방문 노드 출력
        System.out.print(node + " ");
        visited[node] = true;

        // 인접한 노드들 중 방문하지 않은 노드로 재귀 호출
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[graph.size()];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 리스트 정렬 (작은 번호부터 방문하기 위해)
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 수행
        visited = new boolean[n + 1];
        DFS(start);
        System.out.println();

        // BFS 수행
        visited = new boolean[n + 1];
        BFS(start);
        System.out.println();
    }
}
