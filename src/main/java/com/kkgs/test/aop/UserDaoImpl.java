package com.kkgs.test.aop;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/25/11:42
 * @Description:
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void getUser() {
        System.out.println("获得User对象");
    }

    @Override
    public void go() {
        System.out.println("动起来！！！！！！！");
    }
}
