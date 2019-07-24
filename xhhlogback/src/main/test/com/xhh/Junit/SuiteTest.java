package com.xhh.Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试类 测试套件
 * @Author： sunfy
 * @Date: Created in 21:51 2019-7-23
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({junitCalculateDemoTest.class,junitCalculateDemoTest3.class})
public class SuiteTest {
    /**
     * 测试套件就是将组织测试类一起运行的
     * 1. 首先写一个测试套件入口类，该类中不能包含其他的方法且是public修饰
     * 2. 更改测试运行器 @RunWith(Suite.class)
     * 3. 将要测试的测试类作为数据传入
     *      @Suite.SuiteClasses({junitCalculateDemoTest.class,junitCalculateDemoTest3.class})
     * @Date: 2019-7-23  22:35
     * @Params: SuiteTest.java
     * @Author: sunfy
     */
}