import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr; // 현재 수열을 저장할 배열
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; // 길이가 M인 배열 생성
        DFS(0); // 깊이 0부터 시작

        bw.flush();
        bw.close();
    }

    public static void DFS(int depth) throws IOException {
        // 깊이가 M이면 배열의 내용을 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        // 1부터 N까지의 숫자를 탐색
        for (int i = 1; i <= N; i++) {
            arr[depth] = i; // 현재 깊이의 수열에 숫자 저장
            DFS(depth + 1); // 다음 깊이 탐색
        }
    }
}
