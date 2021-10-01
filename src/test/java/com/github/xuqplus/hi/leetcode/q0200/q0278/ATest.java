package com.github.xuqplus.hi.leetcode.q0200.q0278;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * 第一个错误的版本
 * easy
 * https://leetcode-cn.com/problems/first-bad-version/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.firstBadVersion(5));
    }
}

class VersionControl {
    protected boolean isBadVersion(int v) {
        if (v >= 4) {
            return true;
        }
        return false;
    }
}

class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        Map<Long, Boolean> map = new TreeMap<>();
        if (wrappedIsBadVersion(map, 1L)) {
            return 1;
        }
        long l = 1, r = n, t = n;
        while (true) {
            if (wrappedIsBadVersion(map, t)) {
                if (!wrappedIsBadVersion(map, t - 1)) {
                    return (int) t;
                }
                r = t;
            } else {
                l = t;
            }
            t = (l + r) / 2;
        }
    }

    boolean wrappedIsBadVersion(Map<Long, Boolean> map, Long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        boolean version = isBadVersion(n.intValue());
        map.put(n, version);
        return version;
    }
}
