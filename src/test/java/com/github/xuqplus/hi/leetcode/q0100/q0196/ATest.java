package com.github.xuqplus.hi.leetcode.q0100.q0196;

import lombok.extern.slf4j.Slf4j;

/**
 * 删除重复的电子邮箱
 * easy
 * https://leetcode-cn.com/problems/delete-duplicate-emails/
 */
@Slf4j
public class ATest {

    /**
     * 1:
     * delete from person where id not in (select id from (select min(id) as id from person group by email) t);
     * 2:
     * delete p from person p, person p2 where p.email = p2.email and p.id > p2.id;
     */
}
