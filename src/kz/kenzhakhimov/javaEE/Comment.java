package kz.kenzhakhimov.javaEE;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private User user;
    private Blog blog;
    private String comment;
    private Timestamp post_date;

    public Comment(Long id, User user, Blog blog, String comment, Timestamp post_date) {
        this.id = id;
        this.user = user;
        this.blog = blog;
        this.comment = comment;
        this.post_date = post_date;
    }

    public Comment() {
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPostDate(Timestamp post_date) {
        this.post_date = post_date;
    }
}
