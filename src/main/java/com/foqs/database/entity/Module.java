package com.foqs.database.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "modules")
public class Module {

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

    @OneToMany(mappedBy = "module", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Module(){}

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Course getCourse(){
        return this.course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public void addLesson(Lesson lesson) {
        lesson.setModule(this);
        this.lessons.add(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        this.lessons.remove(lesson);
        lesson.setModule(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id.equals(module.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
