package com.xhh.Junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * 同时测试多组数据
 * @Author： sunfy
 * @Date: Created in 22:39 2019-7-23
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    /**
     * 1. 更改默认的测试运行器 @RunWith(Parameterized.class)
     * 2. 声明变量来存储预期值和结果值
     * 3. 声明一个返回值为Collection的公共静态方法，并用@Parameterized.Parameters修饰
     * 4. 为测试类声明一个带有参数的公共构造函数，并在其中为之声明的变量赋值
     * @Date: 2019-7-23  22:49
     * @Author: sunfy
     */

    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> t(){
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {4,2,2}
        });
    }

    public ParameterTest(int expected,int input1,int input2){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void addTest(){
        assertEquals(expected,new junitCalculateDemo().add(input1,input2));
    }
}