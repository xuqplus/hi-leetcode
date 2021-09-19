package com.github.xuqplus.hi.leetcode.q0100.q0118;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 杨辉三角
 * easy
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.getRow(5));
    }
}

class Solution {

    static Map<Integer, List<Integer>> map = new HashMap<>(1 << 6);

    static {
        List<Integer> firstRow = Arrays.asList(1);
        map.put(0, firstRow);

        generate(34);
    }

    static int sum(List<Integer> arr, int i0, int i1) {
        if (i0 < 0 || i1 >= arr.size()) {
            return 1;
        }
        return arr.get(i0) + arr.get(i1);
    }

    static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cache = map.get(i);
            if (null != cache) {
                result.add(cache);
                continue;
            }
            List<Integer> previous = result.get(i - 1);
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                int sum = sum(previous, j - 1, j);
                current.add(sum);
            }
            map.put(i, current);
            result.add(current);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        return map.get(rowIndex);
    }
}
