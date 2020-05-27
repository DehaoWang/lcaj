package leetcode.lc207;

/**
 * Created by wangdehao on 19/4/16.
 */
public class CourseSchedule {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        return false;
    }

    public static boolean canFinishBf(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            // start from course i
            if (canFinishStartingWithI(i, prerequisites)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canFinishStartingWithI(int i, int[][] prerequisites) {

        return false;
    }
}
