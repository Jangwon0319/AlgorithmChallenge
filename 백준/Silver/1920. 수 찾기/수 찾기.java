import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자를 저장한 배열
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 숫자 입력 및 정렬
        // 정렬하는 이유? : 나중에 이진 검색을 위해 정렬
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str1.nextToken());
        }
        Arrays.sort(arr);

        // 테스트할 숫자 배열 저장 및 입력
        int m = Integer.parseInt(br.readLine());
        int[] test = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            test[i] = Integer.parseInt(st2.nextToken());
        }

        // 이진 탐색 알고리즘

        // test 배열 갯수 동안 실시
        for (int i = 0; i < m; i++) {
            
            // 새로 테스트 할 때마다 새로 초기화
            int min = 0;
            int max = n-1;
            boolean found = false;

            // 이진 탐색 트리 알고리즘
            while (min <= max) {
                
                int mid = (min + max) / 2;  // 중간 값 설정
                
                // 만약 key 값이 중간보다 크면 최소값 변경
                if (test[i] > arr[mid])
                    min = mid + 1;
                // 만약 key 값이 중간보다 작으면 최댓값 변경
                else if (test [i] < arr[mid])
                    max = mid - 1;
                // key 값이 중간값과 같으면 true 변경 후 종료
                else {
                    found = true;
                    break;
                }
            }

            if (found){
                System.out.println("1");
            } else
                System.out.println("0");

        }
    }
}
