import java.util.*;
class Process {
    int id, arrivalTime, burstTime, completionTime, turnaroundTime, waitingTime;
    
    Process(int id, int at, int bt) {
        this.id = id;
        this.arrivalTime = at;
        this.burstTime = bt;
    }
}
public class fcfs {
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
        
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));
        
        int time = 0;
        double totalTAT = 0, totalWT = 0;
        List<String> gantt = new ArrayList<>();
        List<Integer> ganttTime = new ArrayList<>();
        
        for (Process p : processes) {
            if (time < p.arrivalTime) {
                gantt.add("Idle");
                ganttTime.add(time);
                time = p.arrivalTime;
            }
            
            p.completionTime = time + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            
            totalTAT += p.turnaroundTime;
            totalWT += p.waitingTime;
            
            gantt.add("P" + p.id);
            ganttTime.add(time);
            
            time = p.completionTime;
        }
        ganttTime.add(time);
        
        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
        for (Process p : processes) {
            System.out.println("P" + p.id + "\t" + p.arrivalTime + "\t" + p.burstTime + 
                               "\t" + p.completionTime + "\t" + p.turnaroundTime + "\t" + p.waitingTime);
        }
        
        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT/n);
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT/n);
        
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
