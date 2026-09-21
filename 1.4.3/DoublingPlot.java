package week4AlgorithmAnalysis;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;

public class DoublingPlot {

    // Đếm số bộ ba tổng bằng 0 (dùng long để tránh tràn số)
    private static int threeSumCount(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if ((long) a[i] + a[j] + a[k] == 0)
                        count++;
        return count;
    }

    public static double timeTrial(int n) {
        int MAX_INT = 1_000_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniformInt(-MAX_INT, MAX_INT);
        Stopwatch timer = new Stopwatch();
        threeSumCount(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        ArrayList<Double> ns = new ArrayList<>();
        ArrayList<Double> times = new ArrayList<>();

        for (int n = 250; ; n *= 2) {
            double time = timeTrial(n);
            System.out.printf("%7d %7.2f%n", n, time);
            ns.add((double) n);
            times.add(time);
            if (time > 4.0 || n > 16000) break;
        }

        // ---- Đồ thị chuẩn (tuyến tính) ----
        StdDraw.setCanvasSize(600, 400);
        StdDraw.clear();
        double maxN = ns.get(ns.size() - 1);
        double maxT = times.get(times.size() - 1);
        StdDraw.setXscale(0, maxN * 1.1);
        StdDraw.setYscale(0, maxT * 1.1);
        for (int i = 0; i < ns.size(); i++) StdDraw.point(ns.get(i), times.get(i));
        for (int i = 0; i < ns.size() - 1; i++)
            StdDraw.line(ns.get(i), times.get(i), ns.get(i + 1), times.get(i + 1));
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(maxN * 0.5, maxT * 1.05, "Do thi chuan: thoi gian theo N");
        StdDraw.show();

        StdDraw.pause(3000);

        // ---- Đồ thị log-log ----
        StdDraw.clear();
        double[] logN = new double[ns.size()];
        double[] logT = new double[times.size()];
        for (int i = 0; i < ns.size(); i++) {
            logN[i] = Math.log10(ns.get(i));
            logT[i] = Math.log10(Math.max(times.get(i), 1e-6));
        }
        double minLogN = logN[0], maxLogN = logN[logN.length - 1];
        double minLogT = logT[0], maxLogT = logT[0];
        for (double v : logT) {
            if (v < minLogT) minLogT = v;
            if (v > maxLogT) maxLogT = v;
        }
        double marginN = (maxLogN - minLogN) * 0.1;
        double marginT = (maxLogT - minLogT) * 0.1 + 0.1;
        StdDraw.setXscale(minLogN - marginN, maxLogN + marginN);
        StdDraw.setYscale(minLogT - marginT, maxLogT + marginT);
        for (int i = 0; i < logN.length; i++) StdDraw.point(logN[i], logT[i]);
        for (int i = 0; i < logN.length - 1; i++)
            StdDraw.line(logN[i], logT[i], logN[i + 1], logT[i + 1]);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text((minLogN + maxLogN) / 2, maxLogT + marginT * 0.5, "Do thi log-log");
        StdDraw.show();
    }
}