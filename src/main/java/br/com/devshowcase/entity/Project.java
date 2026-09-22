package br.com.devshowcase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String repositoryUrl;

    private String deployUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @ManyToMany
    @JoinTable(
        name = "project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();

    public Project() {}

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getRepositoryUrl() { return repositoryUrl; }
    public String getDeployUrl() { return deployUrl; }
    public Profile getProfile() { return profile; }
    public List<Technology> getTechnologies() { return technologies; }
    public List<Feedback> getFeedbacks() { return feedbacks; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }
    public void setDeployUrl(String deployUrl) { this.deployUrl = deployUrl; }
    public void setProfile(Profile profile) { this.profile = profile; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }
}
