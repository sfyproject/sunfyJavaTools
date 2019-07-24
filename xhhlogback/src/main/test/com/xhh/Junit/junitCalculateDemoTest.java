package com.xhh.Junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @Author： sunfy
 * @Date: Created in 21:27 2019-7-23
 */
public class junitCalculateDemoTest {

    /**
     * 1. 测试方法必须使用@Test进行修饰
     * 2. 测试方法必须使用public void进行修饰，不能带任何的参数
     * 3. 新建一个源代码目录来存放我们的测试代码（测试代码放在对应的测试文件目录）
     * 4. 测试类的包结构同源代码包结构保持一致
     * 5. 测试单元中的每个方法必须可以独立测试，测试方法不能有任何的依赖
     * 6. 测试类使用Test作为类名的后缀（格式规范，非必须）
     * 7. 测试方法使用Test作为方法名的后缀（格式规范，非必须）
     * <p>
     * 说明：测试不能用来证明你是对的，只能证明你没有错
     * 测试用例用来达到想要的预期结果，但对于逻辑错误无能为力
     *
     * @Date: 2019-7-23  21:28
     * @Author: sunfy
     */

    int a = 6;
    int b = 3;

    /**
     * @BeforeClass 修饰的方法会在所有方法被调用前执行，而且该方法是静态的，所以当测试类被加载后，
     * 接着就会运行它，而且在内存中只会存在一份实例，比较适合加载配置文件
     * @AfterClass 所修饰的方法通常用来对资源的清理，如关闭数据库连接等
     * @Before 和 @After会在每个测试方法的前后各执行一次
     * @Date: 2019-7-23  21:58
     * @Author: sunfy
     */

    @Before
    public void setUp() throws Exception {
        System.out.println("this is Before...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("this is After...");
    }


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is BeforeClass...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is AfterClass...");
    }

    @Test
    public void add() {
        System.out.println("this is add...");
        assertEquals(9, new junitCalculateDemo().add(a, b));
    }

    @Test
    public void subtract() {
        System.out.println("this is subtract...");
        assertEquals(3, new junitCalculateDemo().subtract(a, b));
    }

    @Test
    public void multiply() {
        System.out.println("this is multiply...");
        assertEquals(18, new junitCalculateDemo().multiply(a, b));
    }

    @Test
    public void divide() {
        System.out.println("this is divide...");
        assertEquals(2, new junitCalculateDemo().divide(a, b));
    }

    /**
     * 测试错误的情况
     * Failure 一般由单元测试使用的断言方法判断失败所引起的，这就表示在测试点发现了问题，就是说程序输出的结果和我们预期的不一致
     *
     * @Date: 2019-7-23  21:41
     * @Author: sunfy
     */
    @Test
    public void failedTest() {
        assertEquals(8, new junitCalculateDemo().add(a, b));
    }

    /**
     * 测试失败的情况
     * error 是由代码异常引起的，它可能产生于测试代码本身的错误，也可能是测试代码中的一个隐藏的bug
     *
     * @Date: 2019-7-23  21:42
     * @Author: sunfy
     */
    @Test
    public void errorTest() {
        b = 0;
        assertEquals(3, new junitCalculateDemo().divide(a, b));
    }


    /**
     * 常用注解
     *
     * @Test：将普通方法修改为一个测试方法 expected = ArithmeticException.class 预期本测试类会抛出的异常进行捕获，
     * 若抛出异常，则测试通过，若没有抛出异常，则会提示测试不通过
     * timeout = 2000 设置预期的时间，若程序运行时间超过设置超时时间则测试不通过，否则通过
     * @BeforeClass：会在所有方法运行前执行，static修饰
     * @AfterClass：会在所有方法运行后执行，static修饰
     * @Before：会在每一个测试方法运行前执行一次
     * @After：会在每一个测试方法运行后执行一次
     * @Ignore：所修饰的测试方法会被测试运行器忽略
     *      该注解中可以添加字符串，来说明该注解为何被忽略。例：@Ignore("该测试类被忽略...")
     * @RunWith：可以更改测试运行器 但是自己所写的测试运行器需要继承 org.junit.runner.Runner
     *
     * @Date: 2019-7-23  22:02
     * @Author: sunfy
     */

    @Test(expected = ArithmeticException.class)
    public void testTestExpectedAnnote() {
        b = 0;
        assertEquals(2, new junitCalculateDemo().divide(a, b));
    }

    @Test(timeout = 2000)
    @Ignore("该测试类被忽略...")
    public void testTestTimeoutAnnote() {
        int index = 0;
        while (true) {
            System.out.println("this is testTestTimeoutAnnote...");
            index++;
            if (index > 1000000) {
                break;
            }
        }
//        通过线程休眠时间来测试Timeout时间
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}