package com.lcaj;

import datastructures.basic.graph.Graph;
import algorithms.utils.ArrayUtils;
import algorithms.utils.GraphUtils;
import algorithms.utils.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {


        String[][] srcTgts = {{"ababababca", "abababca"}};
        for (int i = 0; i < srcTgts.length; i++) {
            String src = srcTgts[i][0];
            String tgt = srcTgts[i][1];
            System.out.println("Sys res = " + src.indexOf(tgt));
            System.out.println("spm res = " + StringUtils.simplePatternMatching(src, tgt));
            System.out.println("spm2 res = " + StringUtils.simplePatternMatching2(src, tgt));
            System.out.println("kmp res = " + StringUtils.kmpPatternMatching(src, tgt));
        }

        String verticesStr = "A,B,C,D,E,F,G,H,I";
        String edgesStr = "A-B,A-F,B-C,B-I,B-G,C-D,C-I,D-E,D-H,D-G,D-I,E-F,E-H,F-G,G-H";
        Set<String> vertices = new HashSet<>(Arrays.asList(verticesStr.split(",")));
        Set<String> edges = new HashSet<>(Arrays.asList(edgesStr.split(",")));

//        Graph graph = new Graph(vertices, edges, true, false);
        Graph graph = new Graph(verticesStr, edgesStr, true, false);

        GraphUtils.dfsTraversalRecursive(graph, 0, true);
        GraphUtils.dfsTraversalIterativeLabelWhenPush(graph, 0, false);
        GraphUtils.dfsTraversalIterativeLabelWhenPop(graph, 0, false);
        GraphUtils.bfsTraversalIterativeLabelWhenPush(graph, 0, true);
        GraphUtils.bfsTraversalIterativeLabelWhenPop(graph, 0, true);


        String verticesStr1 = "A,B,C,D,E,F,G,H,I";
        String edgesStr1 = "A-B:1,A-C:5,B-C:3,B-D:7,B-E:5,C-E:1,C-F:7,D-E:2,E-F:3,D-G:3,E-G:6,E-H:9,F-H:5,G-H:2,G-I:7,H-I:4";
        Graph graph1 = new Graph(verticesStr1, edgesStr1, true, true);
        GraphUtils.dfsTraversalRecursive(graph1, 0, true);
        GraphUtils.dfsTraversalIterativeLabelWhenPop(graph1, 0, false);
        GraphUtils.bfsTraversalIterativeLabelWhenPop(graph1, 0, true);

        double[] dijkRes =  GraphUtils.getMinPathDijkstra(graph1, 0, true);
        ArrayUtils.printArray(dijkRes);

        int[] heapTest = null;
        ArrayUtils.buildHeap(heapTest, heapTest.length,true);
//        ArrayMethods.heapSort(heapTest, false);
        ArrayUtils.printArray(heapTest);
    }
}

