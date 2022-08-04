package org.example.Models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name= "REVIEW_DATA")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private int score;
    private String comment;
    private Date created_at;
    private Date updated_at;


    @ManyToOne
    private Game game;

}
