package ci.miage.nutrici.notification;


public class DemandeNotification {


    private String destinataire;

    private String message;

    private String type;



    public DemandeNotification() {
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

}