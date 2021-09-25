package com.github.xuqplus.hi.leetcode.q0100.q0181;

import lombok.extern.slf4j.Slf4j;

/**
 * 超过经理收入的员工
 * easy
 * https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/
 */
@Slf4j
public class ATest {

    /**
     * select e.name Employee
     *  from employee e inner join employee e2
     *  on e.managerId = e2.id
     *  where e.salary > e2.salary;
     */
}

