package com.lcaj.util;

import com.lcaj.model.graph.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphMethods {
    public static void dfsTraversalRecursive(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ndfsTraversalRecursive starting at index: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        if (graph.isUndirected()) {
            boolean[] visited = new boolean[graph.getAdjacencyMatrix().length];
            dfsTraversalRecursive(graph, visited, startIndex, visitSequence);
        }
    }

    private static void dfsTraversalRecursive(Graph graph, boolean[] visited, int curr, List<Integer> visitSequence) {

        Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        visited[curr] = true;
        System.out.print(graph.getName(curr) + " -> ");
        for (int next : visitSequence) {
            if (next != curr && !visited[next] && adjacencyMatrix[curr][next] != Graph.CONSTANT_UNDIRECTED_AMV) {
//                System.out.println("curr = " + graph.getName(curr) + " ,next = " + graph.getName(next));
                dfsTraversalRecursive(graph, visited, next, visitSequence);
            }
        }
    }

    /**
     * dfsTraversalIterativeLabelWhenPush has different traversal sequence with dfsTraversalRecursive
     * because the visit status has been known beforehand
     */
    public static void dfsTraversalIterativeLabelWhenPush(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ndfsTraversalIterativeLabelWhenPush starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        if (graph.isUndirected()) {
            Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            boolean[] visited = new boolean[adjacencyMatrix.length];

            Stack<Integer> stack = new Stack<>();
            stack.add(startIndex);
            while (!stack.isEmpty()) {
                Integer curr = stack.pop();
                visited[curr] = true;
                System.out.print(graph.getName(curr) + " -> ");
                for (int next : visitSequence) {
                    if (next != curr && !visited[next] && adjacencyMatrix[curr][next] != Graph.CONSTANT_UNDIRECTED_AMV) {
//                        System.out.println("curr = " + graph.getName(curr) + " ,next = " + graph.getName(next));

                        stack.push(next);
                        // CRITICAL: may enqueue same vertex multiple times!
                        // NOTED: knowing visit status beforehand, causing difference in visit sequence
                        // not complete? https://stackoverflow.com/questions/9201166/iterative-dfs-vs-recursive-dfs-and-different-elements-order

                        // label when push
                        visited[next] = true;
                    }
                }
            }
        }
    }

    /**
     * dfsTraversalIterativeLabelWhenPop has identical traversal sequence with dfsTraversalRecursive
     * when pushing neighbours backwards
     */
    public static void dfsTraversalIterativeLabelWhenPop(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ndfsTraversalIterativeLabelWhenPop starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        if (graph.isUndirected()) {
            Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            boolean[] visited = new boolean[adjacencyMatrix.length];

            Stack<Integer> stack = new Stack<>();
            stack.add(startIndex);
            while (!stack.isEmpty()) {
                Integer curr = stack.pop();
                if (!visited[curr]) {
                    // label when pop
                    visited[curr] = true;
                    System.out.print(graph.getName(curr) + " -> ");
                    for (int next : visitSequence) {
                        if (next != curr && !visited[next] && adjacencyMatrix[curr][next] != Graph.CONSTANT_UNDIRECTED_AMV) {
//                        System.out.println("curr = " + graph.getName(curr) + " ,next = " + graph.getName(next));

                            stack.push(next);
                            // CRITICAL: may enqueue same vertex multiple times!
                            // NOTED: knowing visit status beforehand, causing difference in visit sequence
                            // not complete? https://stackoverflow.com/questions/9201166/iterative-dfs-vs-recursive-dfs-and-different-elements-order
//                        visited[next] = true;
                        }
                    }
                }
            }
        }
    }

    /**
     * bfsTraversalIterativeLabelWhenPush has identical traversal sequence with bfsTraversalIterativeLabelWhenPop
     */
    public static void bfsTraversalIterativeLabelWhenPush(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\nbfsTraversalIterativeLabelWhenPush starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        if (graph.isUndirected()) {
            Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            boolean[] visited = new boolean[adjacencyMatrix.length];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startIndex);
            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                visited[curr] = true;
                System.out.print(graph.getName(curr) + " -> ");
                for (int next : visitSequence) {
                    if (next != curr && !visited[next] && adjacencyMatrix[curr][next] != Graph.CONSTANT_UNDIRECTED_AMV) {
//                        System.out.println("curr = " + graph.getName(curr) + " ,next = " + graph.getName(next));
                        queue.add(next);
                        // CRITICAL: may enqueue same vertex multiple times!
                        visited[next] = true;
                    }
                }
            }
        }
    }

    /**
     * bfsTraversalIterativeLabelWhenPop has identical traversal sequence with bfsTraversalIterativeLabelWhenPush
     */
    public static void bfsTraversalIterativeLabelWhenPop(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\nbfsTraversalIterativeLabelWhenPop starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        if (graph.isUndirected()) {
            Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            boolean[] visited = new boolean[adjacencyMatrix.length];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startIndex);
            while (!queue.isEmpty()) {
                Integer curr = queue.poll();
                if (!visited[curr]) {
                    visited[curr] = true;
                    System.out.print(graph.getName(curr) + " -> ");
                    for (int next : visitSequence) {
                        if (next != curr && !visited[next] && adjacencyMatrix[curr][next] != Graph.CONSTANT_UNDIRECTED_AMV) {
//                        System.out.println("curr = " + graph.getName(curr) + " ,next = " + graph.getName(next));
                            queue.add(next);
                            // CRITICAL: may enqueue same vertex multiple times!
//                            visited[next] = true;
                        }
                    }
                }
            }
        }
    }
}
