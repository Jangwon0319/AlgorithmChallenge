import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 점의 갯수 N 선언 및 입력
        int N = Integer.parseInt(br.readLine());

        // int [][] -> 2는 x,y / N는 좌표 입력 갯수
        int [][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            arr[i][0] = x;

            int y = Integer.parseInt(st.nextToken());
            arr[i][1] = y;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0] +" "+ arr[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
