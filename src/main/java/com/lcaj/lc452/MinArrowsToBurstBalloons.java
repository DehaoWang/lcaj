package com.lcaj.lc452;

import algorithms.intervals.IntervalSchedule;

public class MinArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(IntervalSchedule.finMinArrowShots(points));
    }
}
