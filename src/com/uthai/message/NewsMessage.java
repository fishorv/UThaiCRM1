//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.uthai.message;

import java.util.List;

public class NewsMessage extends Message {
    private int ArticleCount;

    private item[] Articles;

    public int getArticleCount() {
        return this.ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        this.ArticleCount = articleCount;
    }

    public item[] getArticles() {
        return Articles;
    }

    public void setArticles(item[] articles) {
        this.Articles = articles;
    }
}
