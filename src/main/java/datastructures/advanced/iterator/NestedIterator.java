package datastructures.advanced.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            traverse(node, result);
        }
        this.it = result.iterator();
    }

    private void traverse(NestedInteger node, List<Integer> result) {
        if (node.isInteger()) {
            result.add(node.getInteger());
            return;
        } else {
            for (NestedInteger child : node.getList()) {
                traverse(child, result);
            }
        }
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }
}
