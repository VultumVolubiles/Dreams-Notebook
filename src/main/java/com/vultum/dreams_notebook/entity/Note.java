package com.vultum.dreams_notebook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String text;

    @Column(name = "date_create")
    private Long dateCreate;

    @Column(name = "date_create")
    private Long dateUpdate;

    @Column(name = "date_dream")
    private Long dateDream;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private User author;
}
