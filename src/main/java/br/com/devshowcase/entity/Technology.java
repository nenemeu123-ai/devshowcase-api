package br.com.devshowcase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technologies")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "technologies")
    @JsonIgnore
    private List<Project> projects = new ArrayList<>();

    public Technology() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Project> getProjects() { return projects; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProjects(List<Project> projects) { this.projects = projects; }
}
