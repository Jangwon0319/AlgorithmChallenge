import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 영식이가 가지고 있는 랜선 갯수
        int k = Integer.parseInt(st.nextToken());
        
        // 필요한 랜선 갯수
        int n = Integer.parseInt(st.nextToken());

        // 가지고 있는 랜선 길이 입력 및 배열 저장
        long[] l_length = new long[k];
        long max = 0;   // 이진 탐색을 위한 최댓값 구하기

        for (int i = 0; i < k; i++) {
            l_length[i] = Long.parseLong(br.readLine());
            if (max < l_length[i]) {
                max = l_length[i];
            }
        }

        // 이진 탐색을 통한 길이 구하기
        long min = 1;    // 나눌 수 있는 랜선 최솟값
        long result = 0; // 최적의 랜선 길이를 저장하기 위한 변수

        // 이진 탐색 알고리즘 구현
        while (min <= max){
            long mid = (max + min) / 2;
            long temp = 0;

            for (int i = 0; i < k; i++) {
                temp += l_length[i] / mid;
            }

            if (temp < n) {
                max = mid - 1;
            } else {
                result = mid; // 가능한 경우, 현재 길이를 저장하고 더 긴 길이를 시도
                min = mid + 1;
            }
        }

        System.out.println(result);
    }
}
