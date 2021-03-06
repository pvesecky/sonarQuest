package com.viadee.sonarquest.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "World")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "project", unique = true)
    private String project;

    @Column(name = "image")
    private String image;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "usequestcards")
    private Boolean usequestcards;

    @JsonIgnore
    @OneToMany(mappedBy = "world")
    private List<Adventure> adventures;

    @JsonIgnore
    @OneToMany(mappedBy = "world")
    private List<Quest> quests;

    @JsonIgnore
    @OneToMany(mappedBy = "world", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "User_To_World", joinColumns = @JoinColumn(name = "world_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;

    public World() {
    }

    public World(final String name, final String project, final Boolean active, final Boolean usequestcards) {
        this.name = name;
        this.project = project;
        this.active = active;
        this.usequestcards = usequestcards;
    }
}
