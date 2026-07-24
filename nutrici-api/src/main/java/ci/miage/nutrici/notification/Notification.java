package ci.miage.nutrici.notification;


import java.time.LocalDateTime;


public class Notification {


    private String id;

    private String destinataire;

    private String message;

    private String type;

    private LocalDateTime date;

    private boolean lue;



    public Notification() {
    }



    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }



    public String getDestinataire() {
        return destinataire;
    }


    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }



    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }



    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }



    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    public boolean isLue() {
        return lue;
    }


    public void setLue(boolean lue) {
        this.lue = lue;
    }

}