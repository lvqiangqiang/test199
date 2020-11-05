package com.kkgs.test.po;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import sun.security.provider.MD5;

/**
 * @Auther: lvqiang
 * @Date: 2020/06/24/9:45
 * @Description:
 */

public class ConfigConstant {

    @Value("${h5.coupon.url}")
    public String h5CouponURL;

}
