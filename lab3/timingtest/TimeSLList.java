package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        testRound(Ns, times, opCounts, 1000, 10000);
        testRound(Ns, times, opCounts, 2000, 10000);
        testRound(Ns, times, opCounts, 4000, 10000);
        testRound(Ns, times, opCounts, 8000, 10000);
        testRound(Ns, times, opCounts, 16000, 10000);
        testRound(Ns, times, opCounts, 32000, 10000);
        testRound(Ns, times, opCounts, 64000, 10000);
        testRound(Ns, times, opCounts, 128000, 10000);

        printTimingTable(Ns, times, opCounts);
    }

    public static void testRound(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int N, int ops) {
        SLList<Integer> s = new SLList<>();
        for (int i = 0; i < N; i += 1) {
            s.addLast(i);
        }

        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < ops; i += 1) {
            s.addLast(i);
        }
        double timeInSeconds = sw.elapsedTime();

        Ns.addLast(N);
        times.addLast(timeInSeconds);
        opCounts.addLast(ops);
    }

}
