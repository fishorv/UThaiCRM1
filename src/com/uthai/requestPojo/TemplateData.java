package com.uthai.requestPojo;

public class TemplateData {
    String first="{\"value\":\"恭喜你购买成功！\",\"color\":\"#173177\"}";
//    String first = origin.replace("恭喜你购买成功","测试");
    String keyword1=first.replace("恭喜你购买成功","数据1");
    String keyword2=first.replace("恭喜你购买成功","数据2");
    String keyword3=first.replace("恭喜你购买成功","数据3");
    String keyword5=first.replace("恭喜你购买成功","数据4");
    String remark  =first.replace("恭喜你购买成功","结束");

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }


    public String getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
