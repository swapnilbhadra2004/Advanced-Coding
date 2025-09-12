import java.util.*;
class Process {
    int id, arrivalTime, burstTime, remainingTime;
    int completionTime, turnaroundTime, waitingTime;

    Process(int id, int at, int bt) {
        this.id = id;
        this.arrivalTime = at;
        this.burstTime = bt;
        this.remainingTime = bt;
    }
}

public class roundrobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i + 1) + ":");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new Process(i + 1, at, bt);
        }

        System.out.print("Enter Time Quantum: ");
        int quantum = sc.nextInt();

        Queue<Process> queue = new LinkedList<>();
        List<String> gantt = new ArrayList<>();
        List<Integer> ganttTime = new ArrayList<>();

        int time = 0, completed = 0;
        boolean[] visited = new boolean[n];

        while (completed < n) {
            for (int i = 0; i < n; i++) {
                if (!visited[i] && processes[i].arrivalTime <= time) {
                    queue.add(processes[i]);
                    visited[i] = true;
                }
            }

            if (queue.isEmpty()) {
                gantt.add("Idle");
                ganttTime.add(time);
                time++;
                continue;
            }

            Process p = queue.poll();

            gantt.add("P" + p.id);
            ganttTime.add(time);

            if (p.remainingTime > quantum) {
                time += quantum;
                p.remainingTime -= quantum;
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && processes[i].arrivalTime <= time) {
                        queue.add(processes[i]);
                        visited[i] = true;
                    }
                }
                queue.add(p);
            } else {
                time += p.remainingTime;
                p.remainingTime = 0;
                p.completionTime = time;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                completed++;
            }
        }
        ganttTime.add(time);
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        double totalTAT = 0, totalWT = 0;
        for (Process p : processes) {
            System.out.println("P" + p.id + "\t" + p.arrivalTime + "\t" + p.burstTime +
                               "\t" + p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
            totalTAT += p.turnaroundTime;
            totalWT += p.waitingTime;
        }

        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT / n);
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / n);
        System.out.println("\nGantt Chart:");
        for (String block : gantt) {
            System.out.print(" | " + block);
        }
        System.out.println(" |");

        for (int t : ganttTime) {
            System.out.print(t + "    ");
        }
        System.out.println();
    }
}
