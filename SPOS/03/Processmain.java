import java.util.Scanner;

class Process {
    int wait;
    int submission;    // Arrival time
    int bursts;        // Burst time
    int turnAround;
    int completionTime;

    Process(int sub, int bur) {
        submission = sub;
        bursts = bur;
    }
}

public class Processmain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = s.nextInt();

        Process[] myProcess = new Process[n];

        System.out.println("Enter Arrival time and bursts:");
        for (int i = 0; i < n; i++) {
            int sub = s.nextInt();
            int bur = s.nextInt();
            myProcess[i] = new Process(sub, bur);
        }

        // Sort processes based on arrival time for correct scheduling
        // (Optional, but recommended if input isn't sorted)
        java.util.Arrays.sort(myProcess, (p1, p2) -> p1.submission - p2.submission);

        int currentTime = 0;

        System.out.println("\nProcess\tArrival\tBurst\tCompletion\tTurnaround\tWaiting");

        for (int i = 0; i < myProcess.length; i++) {
            // If process arrives after current time, CPU waits
            if (myProcess[i].submission > currentTime) {
                currentTime = myProcess[i].submission;
            }

            currentTime += myProcess[i].bursts;
            myProcess[i].completionTime = currentTime;
            myProcess[i].turnAround = myProcess[i].completionTime - myProcess[i].submission;
            myProcess[i].wait = myProcess[i].turnAround - myProcess[i].bursts;

            System.out.println(
                "P" + (i + 1) + "\t" +
                myProcess[i].submission + "\t" +
                myProcess[i].bursts + "\t" +
                myProcess[i].completionTime + "\t\t" +
                myProcess[i].turnAround + "\t\t" +
                myProcess[i].wait
            );
        }

        s.close();
    }
}
