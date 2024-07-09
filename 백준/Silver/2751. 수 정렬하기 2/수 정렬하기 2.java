import java.io.*;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // 시간 단축을 위해 Scanner가 아닌 Buffer을 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받을 줄의 갯수
        int N = Integer.parseInt(br.readLine());

        // 입력 받을 숫자를 저장할 배열
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(arr);

        // 중복 X 출력
        int temp = 10000001;    // 절댓값 1000000 기준이기 때문

        for (int i : arr) {
            if (i != temp){
                bw.write(i + "\n");
                temp = i;
            }
        }

        bw.flush(); // 버퍼에 남아있는 데이터 모두 출력
        bw.close(); // 버퍼 스트림 비우기



    }
}