package ci.miage.nutrici.promotion;


import java.time.LocalDate;


public class Promotion {


    private String id;

    private String code;

    private String description;

    private double reduction;

    private boolean active;

    private LocalDate dateExpiration;



    public Promotion() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
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



    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }



    public LocalDate getDateExpiration() {
        return dateExpiration;
    }


    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

}