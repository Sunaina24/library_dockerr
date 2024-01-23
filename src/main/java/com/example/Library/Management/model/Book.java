package com.example.Library.Management.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@ToString
@Entity
@Data

public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
//    private Boolean borrowed;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User user;
    private int totalCopies;
    private int copiesBorrowed;
}