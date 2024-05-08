package com.foqs.database.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int totalUsers;

    @Column
    private int totalTasks;

    @Column
    private double courseCompletionRate;

    @Column
    private double moduleCompletionRate;

    @Column
    private double themeCompletionRate;

    @Column
    private double successfulTaskRate;

    @Column
    private int activeUsersCount;

    @Column
    private Date reportDate;

    public Report(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public double getCourseCompletionRate() {
        return courseCompletionRate;
    }

    public void setCourseCompletionRate(double courseCompletionRate) {
        this.courseCompletionRate = courseCompletionRate;
    }

    public double getModuleCompletionRate() {
        return moduleCompletionRate;
    }

    public void setModuleCompletionRate(double moduleCompletionRate) {
        this.moduleCompletionRate = moduleCompletionRate;
    }

    public double getThemeCompletionRate() {
        return themeCompletionRate;
    }

    public void setThemeCompletionRate(double themeCompletionRate) {
        this.themeCompletionRate = themeCompletionRate;
    }

    public double getSuccessfulTaskRate() {
        return successfulTaskRate;
    }

    public void setSuccessfulTaskRate(double successfulTaskRate) {
        this.successfulTaskRate = successfulTaskRate;
    }

    public int getActiveUsersCount() {
        return activeUsersCount;
    }

    public void setActiveUsersCount(int activeUsersCount) {
        this.activeUsersCount = activeUsersCount;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id.equals(report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

