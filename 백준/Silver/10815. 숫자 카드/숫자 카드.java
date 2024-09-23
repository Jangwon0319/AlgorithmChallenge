import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] Narray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Narray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Narray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Narray);    // 이진 탐색을 위한 정렬

        M = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st1.nextToken());

            bw.write(BinarySearch(num) + " ");
        }
        bw.flush();
        bw.close();
    }

    public static int BinarySearch(int num){
        int left = 0, right = N - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(num > Narray[mid]){
                left = mid + 1;
            }
            else if(num < Narray[mid]){
                right = mid - 1;
            }
            else
                return 1;
        }
        return 0;
    }
}
