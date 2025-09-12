import java.util.*;
class Process {
    int id, arrivalTime, burstTime, completionTime, turnaroundTime, waitingTime;
    boolean completed;
    
    Process(int id, int at, int bt) {
        this.id = id;
        this.arrivalTime = at;
        this.burstTime = bt;
        this.completed = false;
    }
}
public class npSJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        Process[] processes = new Process[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arrival time and burst time for process " + (i+1) + ":");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            processes[i] = new Process(i+1, at, bt);
        }
        
        int time = 0, completedCount = 0;
        double totalTAT = 0, totalWT = 0;
        List<String> gantt = new ArrayList<>();
        List<Integer> ganttTime = new ArrayList<>();
        
        while (completedCount < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!processes[i].completed && processes[i].arrivalTime <= time) {
                    if (processes[i].burstTime < minBT) {
                        minBT = processes[i].burstTime;
                        idx = i;
                    }
                }
            }
            
            if (idx == -1) {
                gantt.add("Idle");
                ganttTime.add(time);
                time++;
            } else {
                Process p = processes[idx];
                gantt.add("P" + p.id);
                ganttTime.add(time);
                
                time += p.burstTime;
                p.completionTime = time;
                p.turnaroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnaroundTime - p.burstTime;
                p.completed = true;
                
                totalTAT += p.turnaroundTime;
                totalWT += p.waitingTime;
                completedCount++;
            }
        }
        ganttTime.add(time);
        
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.println("P" + p.id + "\t" + p.arrivalTime + "\t" + p.burstTime + 
                               "\t" + p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }
        
        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT/n);
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT/n);
        
        // Print Gantt Chart
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

