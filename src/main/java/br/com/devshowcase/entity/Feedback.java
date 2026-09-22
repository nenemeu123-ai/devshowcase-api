package br.com.devshowcase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Feedback() {}

    public Long getId() { return id; }
    public String getComment() { return comment; }
    public Integer getRating() { return rating; }
    public Project getProject() { return project; }

    public void setId(Long id) { this.id = id; }
    public void setComment(String comment) { this.comment = comment; }
    public void setRating(Integer rating) { this.rating = rating; }
    public void setProject(Project project) { this.project = project; }
}
