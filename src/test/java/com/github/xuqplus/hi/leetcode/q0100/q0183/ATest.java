package com.github.xuqplus.hi.leetcode.q0100.q0183;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 从不订购的客户
 * easy
 * https://leetcode-cn.com/problems/customers-who-never-order/
 */
@Slf4j
public class ATest {

    /**
     * select c.name as Customers from customers c left join orders o on c.id = o.customerId where o.id is null
     */
}
