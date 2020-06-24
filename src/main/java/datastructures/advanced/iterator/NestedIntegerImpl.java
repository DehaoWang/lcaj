package datastructures.advanced.iterator;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    @Override
    public boolean isInteger() {
        return val != null;
    }

    @Override
    public Integer getInteger() {
        return this.val;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.list;
    }
}
