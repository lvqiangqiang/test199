package com.kkgs.test.aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/25/11:44
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void test(){
        ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("spring-aop-shcema-advice.xml");
        UserDao userDao = (UserDao) cc.getBean("userDao");
//        userDao.getUser();

        userDao.go();

    }

}
