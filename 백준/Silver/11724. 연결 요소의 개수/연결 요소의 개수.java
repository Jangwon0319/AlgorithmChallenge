import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int n, m;

    public static void DFS(int node) {
        visited[node] = true;

        // 인접한 노드들 중 방문하지 않은 노드로 재귀 호출
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수

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

        // 방문 배열 초기화
        visited = new boolean[n + 1];

        int componentCount = 0; // 연결 요소의 개수

        // 모든 정점을 순회하면서 연결 요소 찾기
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 정점에서 DFS 시작
                DFS(i);
                componentCount++; // 새로운 연결 요소 발견
            }
        }

        // 결과 출력
        System.out.println(componentCount);
    }
}
