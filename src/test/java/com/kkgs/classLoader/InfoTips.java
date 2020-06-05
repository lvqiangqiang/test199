package com.kkgs.classLoader;

/**
 * @Auther: lvqiang
 * @Date: 2020/05/22/11:02
 * @Description:
 */
public class InfoTips {

    private String data;

    private String isSuccess;

    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return this.data;
    }
    public void setIsSuccess(String isSuccess){
        this.isSuccess = isSuccess;
    }
    public String getIsSuccess(){
        return this.isSuccess;
    }

    @Override
    public String toString() {
        return "InfoTips{" +
                "data='" + data + '\'' +
                ", isSuccess='" + isSuccess + '\'' +
                '}';
    }
}
