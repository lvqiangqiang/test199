package utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName Desensitization
 * @Description 脱敏工具类
 * @Author lvqiang
 * @Date 2020/3/5 22:56
 */
public class DesensitizationUtils {

    /**
     * 适合对姓氏进行脱敏   name：金三胖    num：1    输出：金**
     * @param str  传入字符串
     * @param num   保留左边几位
     * @return
     */
    public static String left(String str,int num){
        if(StringUtils.isBlank(str)){
            return "";
        }
        String left = StringUtils.left(str,num);
        return StringUtils.rightPad(left,str.length(),"*");
    }

    /**
     * name：金三胖    num：1    输出：**胖
     * @param str  传入字符串
     * @param num   保留左边几位
     * @return
     */
    public static String right(String str,int num){
        if(StringUtils.isBlank(str)){
            return "";
        }
        String right = StringUtils.right(str,num);
        return StringUtils.leftPad(right,str.length(),"*");
    }

    /**
     *  str：18166040164 head：3  tail：4  结果：181****0161
     * @param str 传入字符串
     * @param head 保留开头的几位
     * @param tail  保留结尾的几位
     * @return
     */
    public static String center(String str,int head,int tail){
        if(StringUtils.isBlank(str)){
            return "";
        }
        int mid = (str.length()-head-tail);
        String regular = "(\\d{"+head+"})\\d{"+mid+"}(\\d{"+tail+"})";
        String template = "$1"+printAnyCharAnyNum('*',mid)+"$2";
        return str.replaceAll(regular,template);
    }

    /**
     * 输出任意字符任意数量
     * @param ch 字符
     * @param num   输出数量
     * @return  返回值
     */
    public static String printAnyCharAnyNum(char ch,int num){
        StringBuilder sb = new StringBuilder();
        for (int i= 0;i<num;i++){
            sb.append(ch);
        }
        return new String(sb);
    }

}
