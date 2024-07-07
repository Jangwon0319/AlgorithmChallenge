import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int hour = sc.nextInt();
        int min = sc.nextInt();

        int total = min + hour * 60 + day * 60 * 24;

        int pivot = 11 + 11 * 60 + 11 * 60 * 24;

        if (total - pivot < 0)
            System.out.println("-1");
        else
            System.out.printf("%d", total - pivot);


        sc.close();

    }
}