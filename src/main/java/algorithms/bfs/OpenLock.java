package algorithms.bfs;

import java.util.*;

public class OpenLock {
    public static void main(String[] args) {
        // test helpers
        // mutate pass
//        for (char c = '0'; c <= '9'; c++) {
//            System.out.println("c=" + c + ", up=" + mutateUp(c) + ", down=" + mutateDown(c));
//        }
        // generate pass
//        System.out.println(generate("4872"));
        System.out.println(generate("0000"));

        // integration pass?
        System.out.println(openLock(new String[]{"1000", "9000", "0100", "0900", "0010", "0090", "0001"}, "4872"));
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock(new String[]{"8888"}, "0009"));
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));

        // buggy
        System.out.println(openLock2WayBFS(new String[]{"1000", "9000", "0100", "0900", "0010", "0090", "0001"}, "4872"));
        System.out.println(openLock2WayBFS(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock2WayBFS(new String[]{"8888"}, "0009"));
        System.out.println(openLock2WayBFS(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));

        System.out.println(openLock2WayBFS2(new String[]{"1000", "9000", "0100", "0900", "0010", "0090", "0001"}, "4872"));
        System.out.println(openLock2WayBFS2(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock2WayBFS2(new String[]{"8888"}, "0009"));
        System.out.println(openLock2WayBFS2(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));

        System.out.println(openLock2WayBFS3(new String[]{"1000", "9000", "0100", "0900", "0010", "0090", "0001"}, "4872"));
        System.out.println(openLock2WayBFS3(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock2WayBFS3(new String[]{"8888"}, "0009"));
        System.out.println(openLock2WayBFS3(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));

    }

    public static int openLock(String[] deadends, String target) {
        // template
        String start = "0000";
        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (deadSet.contains(target) || deadSet.contains(start)) {
            return -1;
        }
        if (target.equals(start)) {
            return 0;
        }
        int depth = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (visited.contains(curr) || deadSet.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (curr.equals(target)) {
                    return depth;
                }
                List<String> options = generate(curr);
                for (String option : options) {
                    if (!visited.contains(option)) {
                        queue.offer(option);
                    }
                }
            }
            // wrong implementation
//            if (failCount == size) {
//                return -1;
//            }
            depth++;
        }

        return -1;
    }

    public static List<String> generateSlow(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            StringBuilder sb = new StringBuilder(curr);
            int c = curr.charAt(i) - '0';
            sb.setCharAt(i, (char) ((c + 11) % 10 + '0'));
            res.add(new String(sb));
            sb.setCharAt(i, (char) ((c + 9) % 10 + '0'));
            res.add(new String(sb));
        }
        return res;
    }

    public static List<String> generate(String curr) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            char[] currChs = curr.toCharArray();
            char base = currChs[i];
            currChs[i] = mutateUp(base);
            res.add(new String(currChs));
            currChs[i] = mutateDown(base);
            res.add(new String(currChs));
        }
        return res;
    }

    public static char mutateUp(char base) {
        if (base < '9') {
            return (char) (base + 1);
        } else {
            return '0';
        }
    }

    public static char mutateDown(char base) {
        if (base > '0') {
            return (char) (base - 1);
        } else {
            return '9';
        }
    }

    public static int openLock2WayBFS(String[] deadends, String target) {
        // template
        String source = "0000";
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains(source)) {
            return -1;
        }
        if (target.equals(source)) {
            return 0;
        }
        Set<String> visitedF = new HashSet<>();
        Set<String> visitedB = new HashSet<>();
        int depthF = 0;
        int depthB = 0;
        Queue<String> queueF = new LinkedList<>();
        Queue<String> queueB = new LinkedList<>();

        queueF.offer(source);
        queueB.offer(target);
        while (!queueF.isEmpty() && !queueB.isEmpty()) {
            int sizeF = queueF.size();
            for (int i = 0; i < sizeF; i++) {
                String curr = queueF.poll();
                if (visitedF.contains(curr)) {
                    continue;
                }
                visitedF.add(curr);
                if (visitedB.contains(curr)) {
                    return depthF + depthB;
                }
                if (deadSet.contains(curr)) {
                    continue;
                }
                List<String> options = generate(curr);
                for (String option : options) {
                    if (!visitedF.contains(option)) {
                        queueF.offer(option);
                    }
                }
            }
            depthF++;

            int sizeB = queueB.size();
            for (int i = 0; i < sizeB; i++) {
                String curr = queueB.poll();
                if (visitedB.contains(curr)) {
                    continue;
                }
                visitedB.add(curr);
                if (visitedF.contains(curr)) {
                    return depthF + depthB;
                }
                if (deadSet.contains(curr)) {
                    continue;
                }
                List<String> options = generate(curr);
                for (String option : options) {
                    if (!visitedB.contains(option)) {
                        queueB.offer(option);
                    }
                }
            }
            depthB++;
        }
        return -1;
    }

    public static int openLock2WayBFS2(String[] deadends, String target) {
        // template
        String source = "0000";
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains(source)) {
            return -1;
        }
        if (target.equals(source)) {
            return 0;
        }
        Set<String> visitedF = new HashSet<>();
        Set<String> visitedB = new HashSet<>();
        int depthF = 0;
        int depthB = 0;
        Queue<String> queueF = new LinkedList<>();
        Queue<String> queueB = new LinkedList<>();

        visitedF.add(source);
        visitedB.add(target);
        queueF.offer(source);
        queueB.offer(target);
        while (!queueF.isEmpty() && !queueB.isEmpty()) {
            int sizeF = queueF.size();
            for (int i = 0; i < sizeF; i++) {
                String curr = queueF.poll();
                List<String> options = generate(curr);
                for (String option : options) {
                    if (!visitedF.contains(option) && !deadSet.contains(option)) {
                        if (visitedB.contains(option)) {
                            return depthF + depthB + 1;
                        }
                        queueF.offer(option);
                        visitedF.add(option);
                    }
                }
            }
            depthF++;

            int sizeB = queueB.size();
            for (int i = 0; i < sizeB; i++) {
                String curr = queueB.poll();
                List<String> options = generate(curr);
                for (String option : options) {
                    if (!visitedB.contains(option) && !deadSet.contains(option)) {
                        if (visitedF.contains(option)) {
                            return depthF + depthB + 1;
                        }
                        queueB.offer(option);
                        visitedB.add(option);
                    }
                }
            }
            depthB++;
        }
        return -1;
    }

    public static int openLock2WayBFS3(String[] deadends, String target) {
        // template
        String source = "0000";
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target) || deadSet.contains(source)) {
            return -1;
        }
        if (target.equals(source)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Set<String> queueF = new HashSet<>();
        Set<String> queueB = new HashSet<>();
        int depth = 0;

        queueF.add(source);
        queueB.add(target);
        while (!queueF.isEmpty() && !queueB.isEmpty()) {
            Set<String> temp;
            if (queueF.size() > queueB.size()) {
                temp = queueF;
                queueF = queueB;
                queueB = temp;
            }
            temp = new HashSet<>();
            for (String curr : queueF) {
                if (visited.contains(curr) || deadSet.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                if (queueB.contains(curr)) {
                    return depth;
                }
                List<String> options = generate(curr);
                for (String option : options) {
                    temp.add(option);
                }
            }
            depth++;
            // swap
            queueF = queueB;
            queueB = temp;
        }
        return -1;
    }
}

