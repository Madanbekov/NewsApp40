package kg.geektech.newsapp40.ui.models;

import java.io.Serializable;

public class News implements Serializable {

    private String title;
    private long createdAt;

    public News(String title, long createdAt) {
        this.title = title;
        this.createdAt = createdAt;
    }
    public News(String title) {
        this.title = title;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
