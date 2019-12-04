package com.lcaj.model.graph;

import com.lcaj.util.MatrixMethods;

import java.util.*;

public class Graph {
    public static final int CONSTANT_UNDIRECTED_AMV = 0;
    int[][] adjacencyMatrixUG;
    double[][] adjacencyMatrixDG;
    boolean undirected = true;
    int numVertice;

    Map<Integer, Vertex> index2Vertex = new HashMap<>();
    Map<String, Integer> vertexName2Index = new HashMap<>();
    Map<Integer, String> index2VertexName = new HashMap<>();


    public Graph(Set<String> vertices, Set<String> edges, boolean undirected) {
        this.undirected = undirected;
        this.numVertice = vertices.size();
        if (undirected) {
            adjacencyMatrixUG = new int[numVertice][numVertice];
        } else {
            adjacencyMatrixDG = new double[numVertice][numVertice];
            for (int k = 0; k < numVertice * numVertice; k++) {
                adjacencyMatrixDG[k / numVertice][k % numVertice] = Double.MAX_VALUE;
            }
        }

        // build vertices
        int vIndex = 0;
        for (String v : vertices) {
            vertexName2Index.put(v, vIndex);
            index2VertexName.put(vIndex, v);
            vIndex++;
            System.out.print(v + " ");
        }
        System.out.println();
        // build edges
        for (String e : edges) {
            int srcIdx = vertexName2Index.get(e.substring(0, 1));
            int dstIdx = vertexName2Index.get(e.substring(1));
            if (undirected) {
                adjacencyMatrixUG[srcIdx][dstIdx] = 1;
                adjacencyMatrixUG[dstIdx][srcIdx] = 1;
            } else {
                adjacencyMatrixDG[srcIdx][dstIdx] = 1.0;
            }
        }
        if (undirected) {
            MatrixMethods.printMatrix(adjacencyMatrixUG);
        } else {
            MatrixMethods.printMatrix(adjacencyMatrixDG);
        }
    }

    public static int getConstantUndirectedAmv() {
        return CONSTANT_UNDIRECTED_AMV;
    }

    public int[][] getAdjacencyMatrixUG() {
        return adjacencyMatrixUG;
    }

    public void setAdjacencyMatrixUG(int[][] adjacencyMatrixUG) {
        this.adjacencyMatrixUG = adjacencyMatrixUG;
    }

    public double[][] getAdjacencyMatrixDG() {
        return adjacencyMatrixDG;
    }

    public void setAdjacencyMatrixDG(double[][] adjacencyMatrixDG) {
        this.adjacencyMatrixDG = adjacencyMatrixDG;
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
        for (int i = 0; i < numVertice; i++) {
            if (visitPreference) {
                visitSequence.add(i);
            }else {
                visitSequence.add(numVertice - 1 - i);
            }
        }
        return visitSequence;
    }
}
