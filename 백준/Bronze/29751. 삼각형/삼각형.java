import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();

        float s = (float) (W * H) / 2;

        System.out.printf("%.1f", s);

        sc.close();

    }
}