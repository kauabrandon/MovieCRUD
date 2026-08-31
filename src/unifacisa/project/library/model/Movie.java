package unifacisa.project.library.model;

import unifacisa.project.library.enums.MovieGenre;
import unifacisa.project.library.enums.MovieStatus;

import java.util.Objects;

public class Movie {
    private Long id;
    private String title;
    private String director;
    private int releaseYear;
    private MovieGenre movieGenre;
    private MovieStatus movieStatus;
    private String synopsis;

    public Movie(Long id, String title, String director, int releaseYear, MovieGenre movieGenre, String synopsis) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.movieGenre = movieGenre;
        this.synopsis = synopsis;
        this.movieStatus = MovieStatus.AVAILABLE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public MovieGenre getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(MovieGenre movieGenre) {
        this.movieGenre = movieGenre;
    }

    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public boolean isAvailable() {
        return this.movieStatus == MovieStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s [%s]", title, releaseYear, movieGenre.getDescMG(), movieStatus.getDescMS());
    }
}
