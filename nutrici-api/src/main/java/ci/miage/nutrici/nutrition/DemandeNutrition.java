package ci.miage.nutrici.nutrition;


public class DemandeNutrition {


    private String utilisateur;

    private String objectif;

    private String allergies;

    private String preferences;



    public DemandeNutrition() {
    }



    public String getUtilisateur() {
        return utilisateur;
    }


    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }



    public String getObjectif() {
        return objectif;
    }


    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }



    public String getAllergies() {
        return allergies;
    }


    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }



    public String getPreferences() {
        return preferences;
    }


    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

}