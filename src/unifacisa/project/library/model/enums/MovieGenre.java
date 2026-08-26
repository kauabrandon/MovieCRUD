package unifacisa.project.library.model.enums;

public enum MovieGenre {
    ACTION("Action"), ADVENTURE("Adventure"), COMEDY("Comedy"), DRAMA("Drama"), HORROR("Horror"), SCIENCEFICTION("Science-Fiction"), ROMANCE("Romance"), ANIMATION("Animation"), DOCUMENTARY("Documentary"), THRILLER("Thriller");

    private final String descMG;

    MovieGenre(String descMG) {
        this.descMG = descMG;
    }

    public String getDescMG() {
        return descMG;
    }
}
