package com.dpf.stack.base;

import org.junit.Test;

/**
 * @author Pikachues
 * Created 2021/12/23
 */
public class TestMethod {

    @Test
    public void testAddFirst(){
        for (int i = 0; i < 16; i++) {
            System.out.println((i-1)&15);
        }
    }
}
