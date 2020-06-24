package datastructures.advanced.iterator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Caller {
    public static void main(String[] args) {
        NestedInteger ni0 = new NestedIntegerImpl(1);
        NestedInteger ni1 = new NestedIntegerImpl(1);
        NestedInteger ni2 = new NestedIntegerImpl(Arrays.asList(ni0, ni1));
        NestedInteger ni3 = new NestedIntegerImpl(2);
        NestedInteger ni4 = new NestedIntegerImpl(1);
        NestedInteger ni5 = new NestedIntegerImpl(1);
        NestedInteger ni6 = new NestedIntegerImpl(Arrays.asList(ni4, ni5));
//        NestedInteger ni7 = new NestedIntegerImpl(Arrays.asList(ni2, ni3, ni6));

        NestedIterator i = new NestedIterator(Arrays.asList(ni2, ni3, ni6));
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        NestedIteratorLazy il = new NestedIteratorLazy(Arrays.asList(ni2, ni3, ni6));
        while (il.hasNext()) {
            System.out.println(il.next());
        }
    }
}
