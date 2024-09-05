import java.io.*;
import java.util.*;

public class Main {
    static int N, S;  // N: 수열의 크기, S: 목표 합
    static int[] arr; // 수열 배열
    static int count = 0; // 부분 수열의 합이 S인 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수열의 크기
        S = Integer.parseInt(st.nextToken()); // 목표 합

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        // 수열 입력 처리
        for (int i = 0; i < N; i++) {
            if (st.hasMoreTokens()) {  // 토큰이 있는지 확인
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        // 부분 수열을 탐색하기 위한 DFS 시작
        DFS(0, 0);

        // S가 0인 경우, 공집합이 포함되므로 하나 빼야 함
        if (S == 0) {
            count--;
        }

        System.out.println(count);
    }

    // DFS로 부분 수열을 탐색
    public static void DFS(int index, int sum) {
        if (index == N) { // 모든 원소를 탐색한 경우
            if (sum == S) { // 현재 합이 S인 경우
                count++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        DFS(index + 1, sum + arr[index]);

        // 현재 원소를 포함하지 않는 경우
        DFS(index + 1, sum);
    }
}
