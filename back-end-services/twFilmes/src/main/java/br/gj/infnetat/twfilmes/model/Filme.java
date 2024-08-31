package br.gj.infnetat.twfilmes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tmdb_id;
    private String original_title;
    private String title;
    private String backdrop_path;
    private String imdb_id;
    private String original_language;
    private String overview;
    private Float popularity;
    private String poster_path;
    private String release_date;
    private Float revenue;
    private Float runtime;
    private String status;
    private String tagline;


    public Filme(long id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public Filme(String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }


}
