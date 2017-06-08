package com.springdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by moke.tsang on 2017/4/28.
 */
@Slf4j
public class ValueOfTest {
    @Test
    public void valueOfTest() throws Exception {
        String s=String.valueOf("");
        Assert.assertNotNull(s);
        log.info("valueOf");
    }

    @Test
    public void IntegerCompare() {
        Integer i = new Integer(-1);
        Assert.assertTrue(i.compareTo(0) < 0);
    }
}
