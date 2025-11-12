import java.util.Scanner;

public class rr {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] wtime = new int[10];
        int[] btime = new int[10];
        int[] rtime = new int[10];

        System.out.print("Enter number of processes (MAX 10): ");
        int num = s.nextInt();

        System.out.println("Enter burst time:");
        for (int i = 0; i < num; i++) {
            System.out.print("P[" + (i + 1) + "]: ");
            btime[i] = s.nextInt();
            rtime[i] = btime[i];
            wtime[i] = 0;
        }

        System.out.print("\nEnter quantum: ");
        int quantum = s.nextInt();

        int rp = num, i = 0, time = 0;
        System.out.print("\nGantt Chart:\n" + time);

        while (rp != 0) {
            if (rtime[i] > quantum) {
                rtime[i] -= quantum;
                time += quantum;
                System.out.print(" | P[" + (i + 1) + "] | " + time);
            } else if (rtime[i] > 0) {
                time += rtime[i];
                rtime[i] = 0;
                rp--;
                System.out.print(" | P[" + (i + 1) + "] | " + time);
            }
            i = (i + 1) % num;
        }

        System.out.println("\n\nTotal time: " + time);
        s.close();
    }
}
