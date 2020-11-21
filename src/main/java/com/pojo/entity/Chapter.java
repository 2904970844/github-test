package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

//@Data
public class Chapter {
    //
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer chapterId;  //章节编号
    private String title;       //章节标题
    private String content;     //章节内容
    private Integer words;      //章节字数
    private Date publishDate;   //发布时间
    private Integer bookId;     //书籍编号
    //数据库不存在的列名
    @TableField(exist = false)
    private Book book;          //书籍类的对象
    private Integer readCount;  //阅读数
    private Integer replyCount; //评论数
    private Integer payState;   //1=收费，2=免费

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", chapterId=" + chapterId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", words=" + words +
                ", publishDate=" + publishDate +
                ", bookId=" + bookId +
                ", book=" + book +
                ", readCount=" + readCount +
                ", replyCount=" + replyCount +
                ", payState=" + payState +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
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

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }
}
