package Leetcode.extra;

import java.util.List;

/**
 * @author zero
 * @created 2020/04/29
 */
public interface NestedInteger {

//    public NestedInteger();

//    NestedInteger(int value);

    boolean isInteger();

    Integer getInteger();

    void setInteger(int value);

    void add(NestedInteger ni);

    List<NestedInteger> getList();
}

