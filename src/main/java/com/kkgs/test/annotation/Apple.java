package com.kkgs.test.annotation;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/21/20:46
 * @Description:
 */

public class Apple {
    @FruitProvider(id = 1,name = "水晶红富士",address = "烟台")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
