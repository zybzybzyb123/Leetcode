package Leetcode.dataStructure.base;

import java.util.List;

public interface NestedInteger {

//    public NestedInteger();

//    NestedInteger(int value);

    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();
}

