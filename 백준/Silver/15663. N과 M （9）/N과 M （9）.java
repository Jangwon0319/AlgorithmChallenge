import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> output = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        // 배열 정렬
        Arrays.sort(arr);

        DFS(0);

        // BufferedWriter 종료
        bw.flush();
        bw.close();
    }

    public static void DFS(int depth) throws IOException {
        if (depth == M) {
            // 수열 출력
            for (int num : output) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        int prev = -1; // 이전 숫자 저장 (중복 방지)
        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[i] != prev) {
                visited[i] = true; // 방문 체크
                output.add(arr[i]); // 현재 숫자 추가
                DFS(depth + 1); // 재귀 호출
                output.remove(output.size() - 1); // 백트래킹
                visited[i] = false; // 방문 해제
                prev = arr[i]; // 이전 숫자 갱신
            }
        }
    }
}
