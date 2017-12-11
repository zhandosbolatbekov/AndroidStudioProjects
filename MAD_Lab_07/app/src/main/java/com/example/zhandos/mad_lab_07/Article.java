Spackage com.example.zhandos.mad_lab_07;

import java.io.Serializable;

/**
 * Created by zhandos on 10/4/17.
 */

public class Article implements Serializable {

    private String author;
    private String title;
    private String description;
    private String imageUrl;
    private String publishedAt;

    public Article(String author, String title, String description, String imageUrl, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
