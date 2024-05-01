/*
 * NAME: David Oh
 * PID: A18111523
 */

/**
 * Implements round robin computing style
 *
 * @author David Oh
 * @since 5/1/24
 */
public class RoundRobin {

    /* constants */
    private static final String TASKS_COMPLETED = "All tasks are already completed.";

    /* instance variables */
    private MyQueue<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    /**
     * Round robin constructor
     *
     * @param toRun tasks to run
     * @throws IllegalArgumentException if toRun is null
     */
    public RoundRobin(Task[] toRun) {
        if (toRun == null) {
            throw new IllegalArgumentException();
        }

        waitlist = new MyQueue<Task>();
        finished = new MyQueue<Task>();
        for (int i = 0; i < toRun.length; i++) {
            waitlist.enqueue(toRun[i]);
        }
        this.quantum = 4;
        this.burstTime = 0;
        this.waitTime = 0;
    }

    /**
     * Round robin constructor with quantum
     *
     * @param quantum how big to make quantum
     * @param toRun tasks to run
     * @throws IllegalArgumentException if quantum less than one or toRUn is null
     */
    public RoundRobin(int quantum, Task[] toRun) {
        if (quantum < 1) {
            throw new IllegalArgumentException();
        }
        if (toRun == null) {
            throw new IllegalArgumentException();
        }

        waitlist = new MyQueue<Task>();
        finished = new MyQueue<Task>();
        for (int i = 0; i < toRun.length; i++) {
            waitlist.enqueue(toRun[i]);
        }
        this.quantum = quantum;
        this.burstTime = 0;
        this.waitTime = 0;
    }

    /**
     * runs all tasks
     *
     * @return String of what occured
     */
    public String runAllTasks() {
        if (this.waitlist.isEmpty()) {
            return TASKS_COMPLETED;
        }
        while (!this.waitlist.isEmpty()) {
            Task cur = this.waitlist.dequeue();
            for (int i = 0; i < this.quantum; i++) {
                if (!cur.runTask()) {
                    break;
                }
                this.burstTime++;
                this.waitTime += this.waitlist.size();
            }
            if (cur.isFinished()) {
                this.finished.enqueue(cur);
            } else {
                this.waitlist.enqueue(cur);
            }
        }
        String taskOrder = "";
        int numTasks = this.finished.size();
        for (int i = 0; i < numTasks; i++) {
            taskOrder += this.finished.dequeue().toString();
            if (i < numTasks - 1) {
                taskOrder += " -> ";
            }
        }
        return "All tasks are run within " + this.burstTime
                + " units of burst time and " + this.waitTime
                + "units of wait time. The tasks are finished in this order:\n"
                + taskOrder;
    }


    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    /*
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                        new Task("C", 4), new Task("D", 12),
                        new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, toRun: test1
        System.out.println(rr1.runAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.runAllTasks());   // TASKS_COMPLETED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                        new Task("C", 6), new Task("D", 4),
                        new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, toRun: test2
        System.out.println(rr2.runAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.runAllTasks());   // TASKS_COMPLETED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                        new Task("C", 3), new Task("D", 1),
                        new Task("E", 2), new Task("F", 4),
                        new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, toRun: test3
        System.out.println(rr3.runAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.runAllTasks());   // TASKS_COMPLETED
        System.out.println();
    }
    
     */
}
