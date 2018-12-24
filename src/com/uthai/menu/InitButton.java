//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.uthai.menu;

public class InitButton {
    public InitButton() {
    }

    public static Menu initMenu() {
        Menu menu = new Menu();
        ClickButton button11 = new ClickButton();
        button11.setKey("11");
        button11.setName("第三代试管");
        ClickButton button12 = new ClickButton();
        button12.setKey("12");
        button12.setName("费用及流程");
        Button button1 = new Button();
        button1.setName("优生攻略");
        button1.setSub_button(new Button[]{button11, button12});
        ViewButton button21 = new ViewButton();
        button21.setUrl("http://www.fishor.com.cn/web/getCode.do");
        button21.setName("待办事项");
        ClickButton button22 = new ClickButton();
        button22.setKey("22");
        button22.setName("查报告");
        Button button2 = new Button();
        ClickButton button23 = new ClickButton();
        button23.setKey("23");
        button23.setName("流程及进度");
        button2.setName("个人中心");
        button2.setSub_button(new Button[]{button21, button22, button23});
        ViewButton button31 = new ViewButton();
        button31.setName("官网首页");
        button31.setUrl("http://www.uthbaby.com");
        ClickButton button32 = new ClickButton();
        button32.setKey("32");
        button32.setName("联系客服");
        ClickButton button33 = new ClickButton();
        button33.setKey("33");
        button33.setName("员工入口");
        Button button3 = new Button();
        button3.setName("即刻优生");
        button3.setSub_button(new Button[]{button31, button32, button33});
        menu.setButton(new Button[]{button1, button2, button3});
        return menu;
    }
}
