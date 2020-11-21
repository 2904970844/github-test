package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

/*@Data                     // 生成set/get方法、equals方法、hadcode方法和toString方法
@RequiredArgsConstructor  // 生成所有必填属性构成的构造方法
@NoArgsConstructor        // 生成默认的构造方法*/
//@TableName("book")
public class Book {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @NonNull
    private String title;           //标题
    @NonNull
    private Integer author;         //作者
    private String summary;         //简介
    private Integer chapterCount;   //章节数目
    private Integer processState;   //连载状态1=连载中，2=完本
    private Integer state;          //书籍状态1=新键，2=审批通过，3=下架
    private Integer points;         //每千字点数
    private Float score;            //评分
    private Integer replies;        //回复数
    private Integer currentChapter; //当前章节
    private Date publishDate;       //发布时间
    private String coverPic;        //封面
//    @NonNull
    private Integer categoryId;     //分类
    @TableField(exist = false)
    List<Chapter> chapterList;      //章节

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", summary='" + summary + '\'' +
                ", chapterCount=" + chapterCount +
                ", processState=" + processState +
                ", state=" + state +
                ", points=" + points +
                ", score=" + score +
                ", replies=" + replies +
                ", currentChapter=" + currentChapter +
                ", publishDate=" + publishDate +
                ", coverPic='" + coverPic + '\'' +
                ", categoryId=" + categoryId +
//                ", chapterList=" + chapterList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getChapterCount() {
        return chapterCount;
    }

    public void setChapterCount(Integer chapterCount) {
        this.chapterCount = chapterCount;
    }

    public Integer getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    public Integer getCurrentChapter() {
        return currentChapter;
    }

    public void setCurrentChapter(Integer currentChapter) {
        this.currentChapter = currentChapter;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
}
