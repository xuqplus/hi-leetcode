package com.github.xuqplus.hi.leetcode.q0013;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
@Slf4j
public class ATest {

    @Test
    void a() {
        Solution solution = new Solution();
        log.info("{}", solution.romanToInt("MCMXCIV"));
    }
}

class Solution {
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

//    I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
//    X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
//    C可以放在D(500) 和M(1000) 的左边，来表示400 和900。

    Map<String, Integer> numRoman = new TreeMap<>();

    public Solution() {
        for (int thousand = 0; thousand < 4000; thousand += 1000) {
            String th = thousand(thousand);
            for (int hundred = 0; hundred < 1000; hundred += 100) {
                String h = hundred(hundred);
                for (int ten = 0; ten < 100; ten += 10) {
                    String t = ten(ten);
                    for (int i = 0; i < 10; i++) {
                        StringBuilder sb = new StringBuilder(th)
                                .append(h)
                                .append(t)
                                .append(n(i));
                        numRoman.put(sb.toString(), thousand + hundred + ten + i);
                    }
                }
            }
        }
    }

    public int romanToInt(String s) {
        return numRoman.get(s);
    }

    private String thousand(int thousand) {
        switch (thousand / 1000) {
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
        }
        return "";
    }

    private String hundred(int hundred) {
        switch (hundred / 100) {
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
        }
        return "";
    }

    private String ten(int ten) {
        switch (ten / 10) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
        }
        return "";
    }

    private String n(int n) {
        switch (n) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
        }
        return "";
    }
}
