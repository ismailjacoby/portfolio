package com.ismailjacoby.portfolioapi.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Project extends BaseEntity{
    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "demo_url", length = 255)
    private String demoUrl;

    @Column(name = "code_url", length = 255)
    private String codeUrl;

    @Column(nullable = false)
    private boolean isPublic;

    @ManyToMany
    @JoinTable(
            name = "project_skill",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> technologies;
}
