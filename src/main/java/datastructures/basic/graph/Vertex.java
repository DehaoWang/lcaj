package datastructures.basic.graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    private Integer index;
    private String name;
    private Set<Integer> outerVertices;
    private Set<Integer> interVertices;

    public Vertex(String name, int vIndex) {
        this.name = name;
        this.index = vIndex;
        outerVertices = new HashSet<>();
        interVertices = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }

    public void removeOuterEdge(Vertex vertex) {
        outerVertices.remove(vertex.index);
    }

    public void removeInterEdge(Vertex vertex) {
        interVertices.remove(vertex.index);
    }

    public void addOuterEdge(Vertex vertex) {
        outerVertices.add(vertex.index);
    }

    public void addInterEdge(Vertex vertex) {
        interVertices.add(vertex.index);
    }

    public int getOuterDegree() {
        return outerVertices.size();
    }

    public int getInnerDegree() {
        return interVertices.size();
    }

    public Set<Integer> getOuterVertices() {
        return outerVertices;
    }

    public void setOuterVertices(Set<Integer> outerVertices) {
        this.outerVertices = outerVertices;
    }

    public Set<Integer> getInterVertices() {
        return interVertices;
    }

    public void setInterVertices(Set<Integer> interVertices) {
        this.interVertices = interVertices;
    }
}
