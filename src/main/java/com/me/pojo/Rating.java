/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

/**
 *
 * @author viraj
 */
public class Rating {
    long rating_id;
    long professor_id;
    long student_id;
    String professor_fName;
    String professor_LName;

    public String getProfessor_fName() {
        return professor_fName;
    }

    public void setProfessor_fName(String professor_fName) {
        this.professor_fName = professor_fName;
    }

    public String getProfessor_LName() {
        return professor_LName;
    }

    public void setProfessor_LName(String professor_LName) {
        this.professor_LName = professor_LName;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }
    String subject;
    int overall_rating;
    int difficulty;
    int recommend;
    int attendance;
    int industry_use;
    String comment;

    public long getRating_id() {
        return rating_id;
    }

    public void setRating_id(long rating_id) {
        this.rating_id = rating_id;
    }

    public long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(long professor_id) {
        this.professor_id = professor_id;
    }

   

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(int overall_rating) {
        this.overall_rating = overall_rating;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getIndustry_use() {
        return industry_use;
    }

    public void setIndustry_use(int industry_use) {
        this.industry_use = industry_use;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
