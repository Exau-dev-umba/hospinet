package cd.appmedecininfirmiers.ui.data.model;

public class Patient {
    String name, genre, profession, etatCivil;
    long id;
    String image;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public String getProfession() {
        return profession;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name;
    }
}
