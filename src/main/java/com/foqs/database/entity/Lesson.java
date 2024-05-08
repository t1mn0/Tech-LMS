package com.foqs.database.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creation_author_id")
    private User creationAuthor;

    @Column
    private Date modificationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modification_author_id")
    private User modificationAuthor;

    @Column
    private Date deletionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deletion_author_id")
    private User deletionAuthor;

    @Lob
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "lesson", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Task> tasks;


    public Lesson(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreationAuthor() {
        return creationAuthor;
    }

    public void setCreationAuthor(User creationAuthor) {
        this.creationAuthor = creationAuthor;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public User getModificationAuthor() {
        return modificationAuthor;
    }

    public void setModificationAuthor(User modificationAuthor) {
        this.modificationAuthor = modificationAuthor;
    }

    public Date getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }

    public User getDeletionAuthor() {
        return deletionAuthor;
    }

    public void setDeletionAuthor(User deletionAuthor) {
        this.deletionAuthor = deletionAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        task.setLesson(this);
        this.tasks.add(task);
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
        task.setLesson(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id.equals(lesson.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}