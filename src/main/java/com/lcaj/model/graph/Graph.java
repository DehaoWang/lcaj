package com.lcaj.model.graph;

import java.util.*;

public class Graph {
    public static final double CONSTANT_UNDIRECTED_AMV = Double.MAX_VALUE;
    private static final String EDGE_DELIMITER_VERTEX = "-";
    private static final String EDGE_DELIMITER_WEIGHT = ":";
    private static final String DEFAULT_PRINT_ELEMENT = "XXX";

    Double[][] adjacencyMatrix;
    boolean undirected = true;
    boolean weighted = false;
    int numVertices;

    Map<Integer, Vertex> index2Vertex = new HashMap<>();
    Map<String, Integer> vertexName2Index = new HashMap<>();
    Map<Integer, String> index2VertexName = new HashMap<>();


    public Graph(Set<String> vertices, Set<String> edges, boolean undirected, boolean weighted) {
        this.undirected = undirected;
        this.weighted = weighted;
        this.numVertices = vertices.size();

        // initialization
        adjacencyMatrix = new Double[numVertices][numVertices];
        for (int k = 0; k < numVertices * numVertices; k++) {
            adjacencyMatrix[k / numVertices][k % numVertices] = Double.MAX_VALUE;
        }
        // build vertices
        int vIndex = 0;
        for (String v : vertices) {
            vertexName2Index.put(v, vIndex);
            index2VertexName.put(vIndex, v);
            vIndex++;
            System.out.print(String.format("%-3s ", v));
        }
        System.out.println();
        // build edges
        for (String e : edges) {
            int srcIdx = vertexName2Index.get(e.substring(0, 1));
            int dstIdx = vertexName2Index.get(e.substring(1));
            adjacencyMatrix[srcIdx][dstIdx] = 1.0;
            if (undirected) {
                adjacencyMatrix[dstIdx][srcIdx] = 1.0;
            }
        }
        printMatrixForGraph();

    }

    public Graph(String verticesStr, String edgesStr, boolean undirected, boolean weighted) {
        String directInfo = undirected ? "Undirected" : "Directed";
        String weightInfo = weighted ? "Weighted" : "Unweighted";

        System.out.println(String.format("\n\n%s-%s Graph:\nVertices: %s, \nEdges: %s",
                directInfo, weightInfo, verticesStr, edgesStr));
        Set<String> vertices = new HashSet<>(Arrays.asList(verticesStr.split(",")));
        Set<String> edges = new HashSet<>(Arrays.asList(edgesStr.split(",")));

        this.undirected = undirected;
        this.weighted = weighted;
        this.numVertices = vertices.size();

        // initialization
        adjacencyMatrix = new Double[numVertices][numVertices];
        for (int k = 0; k < numVertices * numVertices; k++) {
            adjacencyMatrix[k / numVertices][k % numVertices] = Double.MAX_VALUE;
        }
        // build vertices
        int vIndex = 0;
        for (String v : vertices) {
            vertexName2Index.put(v, vIndex);
            index2VertexName.put(vIndex, v);
            vIndex++;
            System.out.print(String.format("%-3s ", v));
        }
        System.out.println();
        // build edges
        for (String e : edges) {
            String[] tokens = e.split(EDGE_DELIMITER_WEIGHT);

            String[] vPair = tokens[0].split(EDGE_DELIMITER_VERTEX);
            int srcIdx = vertexName2Index.get(vPair[0]);
            int dstIdx = vertexName2Index.get(vPair[1]);

            Double weight = weighted ? Double.parseDouble(tokens[1]) : 1.0;

            adjacencyMatrix[srcIdx][dstIdx] = weight;
            if (undirected) {
                adjacencyMatrix[dstIdx][srcIdx] = weight;
            }
        }
        printMatrixForGraph();
//        Graph(vertices, edges, undirected, weighted);
    }

    public static double getConstantUndirectedAmv() {
        return CONSTANT_UNDIRECTED_AMV;
    }

    public Double[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(Double[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public boolean isUndirected() {
        return undirected;
    }

    public void setUndirected(boolean undirected) {
        this.undirected = undirected;
    }

    public Map<Integer, Vertex> getIndex2Vertex() {
        return index2Vertex;
    }

    public void setIndex2Vertex(Map<Integer, Vertex> index2Vertex) {
        this.index2Vertex = index2Vertex;
    }

    public Map<String, Integer> getVertexName2Index() {
        return vertexName2Index;
    }

    public void setVertexName2Index(Map<String, Integer> vertexName2Index) {
        this.vertexName2Index = vertexName2Index;
    }

    public Map<Integer, String> getIndex2VertexName() {
        return index2VertexName;
    }

    public void setIndex2VertexName(Map<Integer, String> index2VertexName) {
        this.index2VertexName = index2VertexName;
    }

    public String getName(int index) {
        return index2VertexName.get(index);
    }

    public List<Integer> getVisitSequence(boolean visitPreference) {
        List<Integer> visitSequence = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (visitPreference) {
                visitSequence.add(i);
            } else {
                visitSequence.add(numVertices - 1 - i);
            }
        }
        return visitSequence;
    }

    // print graph adjacency matrix
    private void printMatrixForGraph() {
        int h = adjacencyMatrix.length;
        int w = adjacencyMatrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                String output = adjacencyMatrix[i][j] == CONSTANT_UNDIRECTED_AMV ? DEFAULT_PRINT_ELEMENT : adjacencyMatrix[i][j].toString();
                System.out.print(String.format("%-3s ", output));
            }
            System.out.println();
        }
    }
}
