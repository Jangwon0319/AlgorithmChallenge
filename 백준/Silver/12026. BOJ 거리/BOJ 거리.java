import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        arr[0] = 0;

        char next;
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(arr[i] == Integer.MAX_VALUE){
                continue;
            }
            if(cur == 'B'){
                next = 'O';
            }else if(cur =='O'){
                next = 'J';
            }else{
                next = 'B';
            }
            for(int j = i + 1; j < str.length(); j++){
                if(str.charAt(j) == next){
                    int nextValue = arr[i] + (j - i) * (j - i);
                    arr[j] = Math.min(arr[j],nextValue);
                }
            }
        }

        bw.write((arr[N-1] == Integer.MAX_VALUE ? -1 : arr[N-1]) +"\n");
        bw.flush();
        bw.close();
    }
}
