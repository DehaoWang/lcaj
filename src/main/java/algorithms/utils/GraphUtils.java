package algorithms.utils;

import datastructures.basic.graph.Graph;
import datastructures.basic.graph.Vertex;

import java.util.*;

public class GraphUtils {
    public static void dfsTraversalRecursive(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ndfsTraversalRecursive starting at index: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

        boolean[] visited = new boolean[graph.getAdjacencyMatrix().length];
        dfsTraversalRecursive(graph, visited, startIndex, visitSequence);
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

    /**
     * dfsTraversalIterativeLabelWhenPop has identical traversal sequence with dfsTraversalRecursive
     * when pushing neighbours backwards
     */
    public static void dfsTraversalIterativeLabelWhenPop(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ndfsTraversalIterativeLabelWhenPop starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

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

    /**
     * bfsTraversalIterativeLabelWhenPush has identical traversal sequence with bfsTraversalIterativeLabelWhenPop
     */
    public static void bfsTraversalIterativeLabelWhenPush(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\nbfsTraversalIterativeLabelWhenPush starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

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

    /**
     * bfsTraversalIterativeLabelWhenPop has identical traversal sequence with bfsTraversalIterativeLabelWhenPush
     */
    public static void bfsTraversalIterativeLabelWhenPop(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\nbfsTraversalIterativeLabelWhenPop starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);

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

    public static double[] getMinPathDijkstra(Graph graph, int startIndex, boolean visitPreference) {
        System.out.println("\ngetMinPathDijkstra starting at vertex: " + graph.getName(startIndex));
        List<Integer> visitSequence = graph.getVisitSequence(visitPreference);
        int numVertices = graph.getNumVertices();
        Double[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        boolean[] finished = new boolean[numVertices];
        finished[startIndex] = true;

        double[] distance = new double[numVertices];
        int[] prev = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distance[i] = adjacencyMatrix[i][startIndex];
        }
        distance[startIndex] = 0;
        for (int k = 0; k < numVertices - 1; k++) {
            int prevIndex = 0;
            double nearestDist = Double.MAX_VALUE;
            for (int i = 0; i < numVertices; i++) {
                if (!finished[i] && distance[i] < nearestDist) {
                    nearestDist = distance[i];
                    prevIndex = i;
                }
            }
            finished[prevIndex] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!finished[j] && adjacencyMatrix[prevIndex][j] != Graph.CONSTANT_UNDIRECTED_AMV) {
                    if (adjacencyMatrix[prevIndex][j] + nearestDist < distance[j]) {
                        distance[j] = adjacencyMatrix[prevIndex][j] + nearestDist;
                        prev[j] = prevIndex;
                    }
                }
            }
        }
//        ArrayMethods.printArray(distance);
//        ArrayMethods.printArray(prev);
        return distance;
    }

    // practice bfs traversal
    public static List<String> bfsTraversal(Graph graph, int startIndex) {
        System.out.println("\nbfsTraversalLabelWhenPop starting at vertex: " + graph.getName(startIndex));
        List<String> bfsSeq = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        Vertex startVertex = graph.getVertexByIndex(startIndex);
        queue.offer(startVertex);
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if (!visited.contains(curr.getIndex())) {
                visited.add(curr.getIndex());
                bfsSeq.add(curr.getName());
                Set<Integer> neighbors = curr.getOuterVertices();
                for (Integer next : neighbors) {
                    if (!visited.contains(next)) {
                        queue.offer(graph.getVertexByIndex(next));
                    }
                }
            }
        }
        return bfsSeq;
    }

    public static List<String> bfsTopologicalSort(Graph graph) {
        List<String> topoSeq = new LinkedList<>();
        System.out.println("\nbfsTopologicalSort");
        System.out.println("After");
        int[] interDegrees = graph.getInterDegrees();
        ArrayUtils.printArray(interDegrees);
        Queue<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.getInnerDegree() == 0) {
                queue.offer(vertex);
            }
        }
        System.out.println(queue);
        // should be all
//        queue.offer(startVertex);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            topoSeq.add(vertex.getName());
            for (Integer next : vertex.getOuterVertices()) {
                interDegrees[next]--;
                if (interDegrees[next] == 0) {
                    queue.offer(graph.getVertexByIndex(next));
                }
            }
        }
        System.out.println("After");
        ArrayUtils.printArray(interDegrees);

        return topoSeq;
    }
}
