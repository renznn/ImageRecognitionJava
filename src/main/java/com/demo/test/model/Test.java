package com.demo.test.model;

public class Test {
    int id;// 数据库编号

    String subject;// 考试科目

    String paper_num;//  试卷编号

    String teacher_name;//  监考老师

    String teacher_num;// 监考教师号

    String student_num;//学生学号

    String student_name;//  学生姓名

    float score;//  学生成绩

    String classes;//  班级

    String grade;// 年级

    String check_result;//批改结果

    public String getCheck_result() {
        return check_result;
    }

    public void setCheck_result(String check_result) {
        this.check_result = check_result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPaper_num() {
        return paper_num;
    }

    public void setPaper_num(String paper_num) {
        this.paper_num = paper_num;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_num() {
        return teacher_num;
    }

    public void setTeacher_num(String teacher_num) {
        this.teacher_num = teacher_num;
    }

    public String getStudent_num() {
        return student_num;
    }

    public void setStudent_num(String student_num) {
        this.student_num = student_num;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
