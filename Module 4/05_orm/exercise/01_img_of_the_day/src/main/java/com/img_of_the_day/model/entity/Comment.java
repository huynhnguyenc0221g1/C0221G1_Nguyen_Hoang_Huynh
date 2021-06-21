package com.img_of_the_day.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int point;
    private String author;
    private String content;
    private int likes;
    private Date createAt = new Date(System.currentTimeMillis());

    public Comment() {
    }

    public Comment(int point, String author, String content) {
        this.point = point;
        this.author = author;
        this.content = content;
    }

    public Comment(int id, int point, String author, String content, int likes, Date createAt) {
        this.id = id;
        this.point = point;
        this.author = author;
        this.content = content;
        this.likes = likes;
        this.createAt = createAt;
    }

    public Comment(int point, String author, String content, int likes, Date createAt) {
        this.point = point;
        this.author = author;
        this.content = content;
        this.likes = likes;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
