package cd.appmedecininfirmiers.ui.data.model;

public class CorpsMedical {
    int id;
    String name, fonction, specialisation;

    public CorpsMedical(int id, String name, String fonction, String specialisation){
        this.id = id;
        this.name = name;
        this.fonction = fonction;
        this.specialisation = specialisation;
    }

    public int enregistrerAudio(){
        return 1;
    }


}
