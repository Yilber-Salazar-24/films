package com.javafullstack.springbootfilms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="film")
@Getter
@Setter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="video_url")
    private String videoUrl;

    @Column(name="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    /**
     * Actores.
     */
    @ManyToMany
    @JoinTable(name = "film_has_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actores;

    /**
     * Directores.
     */
    @ManyToMany
    @JoinTable(name = "film_has_director",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directores;


    public void addActor(Actor actor){
        if(this.actores == null){
            this.actores = new ArrayList<>();
        }
        this.actores.add(actor);
    }

    public void addDirector(Director director){
        if(this.directores == null){
            this.directores = new ArrayList<>();
        }
        this.directores.add(director);
    }

}
