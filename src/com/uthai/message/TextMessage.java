//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.uthai.message;

public class TextMessage extends Message {
    private String Content;

    public TextMessage() {
        this.setMsgType("text");
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }
}
