import java.util.Scanner;

public class RoundRobin2 {
    public static void main(String[] args) {
        int count, n, time_quantum, ch = 1;
        int wait_time = 0, turnaround_time = 0;
        int[] at = new int[10];
        int[] bt = new int[10];
        int[] rt = new int[10];
        int remain = 0;
        int[] order = new int[10];
        float avgWaitTime, avgTurnaroundTime;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter no of Processes: ");
        n = input.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter arrival time for Process P%d: ", i + 1);
            at[i] = input.nextInt();
            System.out.printf("Enter burst time for Process P%d: ", i + 1);
            bt[i] = input.nextInt();
            rt[i] = bt[i];
        }
        
        System.out.println("Enter Time Quantum: ");
        time_quantum = input.nextInt();
        remain = n;

        StringBuilder executionOrder = new StringBuilder();

        
        System.out.println("\nProcess\t| Turnaround Time | Waiting Time");
        int time = 0;
        count = 0;
        while (remain != 0) {
            
            if (rt[count] <= time_quantum && rt[count] > 0) {
                time += rt[count];
                rt[count] = 0;
                System.out.printf("P[%d]\t|\t%d\t|\t%d\n", count + 1, time - at[count], time - at[count] - bt[count]);
                wait_time += time - at[count] - bt[count];
                turnaround_time += time  - at[count];
                remain--;
                executionOrder.append(count + 1).append(" ");


            } else if (rt[count] > 0) {
                executionOrder.append(count + 1).append(" ");
                rt[count] -= time_quantum;
                time += time_quantum;
            }
            
            count++;
            if (count == n)
                count = 0;
        }

        System.out.println("\nExecution Order: " + executionOrder.toString());

        
        avgWaitTime = (wait_time) * 1.0f / n;
        avgTurnaroundTime = (turnaround_time) * 1.0f  / n;
        
        System.out.printf("\nAverage Waiting Time= %.2f\n", avgWaitTime);
        System.out.printf("Average Turnaround Time = %.2f\n", avgTurnaroundTime);
        
        input.close();
    }
}
