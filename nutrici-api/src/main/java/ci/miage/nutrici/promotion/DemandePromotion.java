package ci.miage.nutrici.promotion;


import java.time.LocalDate;


public class DemandePromotion {


    private String code;

    private String description;

    private double reduction;

    private LocalDate dateExpiration;



    public DemandePromotion() {
    }



    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }



    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }



    public double getReduction() {
        return reduction;
    }


    public void setReduction(double reduction) {
        this.reduction = reduction;
    }



    public LocalDate getDateExpiration() {
        return dateExpiration;
    }


    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

}