package algorithms.faq;

import algorithms.utils.MatrixUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AucCalculation {
    public static void main(String[] args) {
        double[][] predAndLabel = getPredAndLabel(10);
        MatrixUtils.printMatrix(predAndLabel);
        System.out.println(aucStatistical(predAndLabel));

    }

    public static double[][] getPredAndLabel(int numOfSamples) {
        double[][] predAndLabel = new double[numOfSamples][2];
        Random random = new Random();
        for (int i = 0; i < numOfSamples; i++) {
            predAndLabel[i][0] = random.nextDouble();
            predAndLabel[i][1] = random.nextInt(2);
        }
        return predAndLabel;
    }

    public static double aucClassical(double[][] predAndLabel) {
        int thresNum = 100;
        for (int i = 0; i < thresNum; i++) {
            double threshold = i / thresNum;
            double tpr = getTpr(threshold, predAndLabel);
            double fpr = getFpr(threshold, predAndLabel);

        }
        return 0;
    }

    private static double getFpr(double threshold, double[][] predAndLabel) {
        return 0;
    }

    private static double getTpr(double threshold, double[][] predAndLabel) {
        return 0;
    }

    public static double aucStatistical(double[][] predAndLabel) {
        Arrays.sort(predAndLabel, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return a[0] < b[0] ? -1 : 1;
            }
        });
        int satisfiedPair = 0;
        int negativeCount = 0;
        for (double[] d : predAndLabel) {
            if (d[1] == 1.0) {
                satisfiedPair += negativeCount;
            } else {
                negativeCount++;
            }
        }
        return (double) satisfiedPair / (negativeCount * (predAndLabel.length - negativeCount));
    }
}
