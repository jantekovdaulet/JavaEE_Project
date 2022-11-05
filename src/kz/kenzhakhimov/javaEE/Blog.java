package kz.kenzhakhimov.javaEE;

import java.sql.Timestamp;

public class Blog {
    private Long id;
    private User user;
    private String title;
    private String content;
    private String picture_url;
    private Timestamp post_date;

    public Blog() {
    }

    public Blog(Long id, User user, String title, String content, String picture_url, Timestamp post_date) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.picture_url = picture_url;
        this.post_date = post_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }
}
