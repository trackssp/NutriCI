package ci.miage.nutrici.controller;


import ci.miage.nutrici.notification.DemandeNotification;
import ci.miage.nutrici.notification.Notification;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {



    private final Map<String, Notification> notifications = new LinkedHashMap<>();







    /*
     * Créer une notification
     */
    @PostMapping
    public ResponseEntity<Notification> envoyer(
            @RequestBody DemandeNotification demande) {



        Notification notification = new Notification();



        notification.setId(
                "NOTIF-" +
                        UUID.randomUUID()
                                .toString()
                                .substring(0,8)
        );



        notification.setDestinataire(
                demande.getDestinataire()
        );



        notification.setMessage(
                demande.getMessage()
        );



        notification.setType(
                demande.getType()
        );



        notification.setDate(
                LocalDateTime.now()
        );



        notification.setLue(false);



        notifications.put(
                notification.getId(),
                notification
        );



        return ResponseEntity
                .status(201)
                .body(notification);

    }








    /*
     * Voir toutes les notifications
     */
    @GetMapping
    public List<Notification> lister(){


        return new ArrayList<>(
                notifications.values()
        );

    }








    /*
     * Voir une notification
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notification> consulter(
            @PathVariable String id) {



        Notification notification =
                notifications.get(id);



        if(notification == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(notification);

    }








    /*
     * Marquer une notification comme lue
     */
    @PutMapping("/{id}/lire")
    public ResponseEntity<Notification> lire(
            @PathVariable String id) {



        Notification notification =
                notifications.get(id);



        if(notification == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        notification.setLue(true);



        return ResponseEntity.ok(notification);

    }








    /*
     * Supprimer une notification
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable String id) {



        Notification notification =
                notifications.remove(id);



        if(notification == null){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity
                .noContent()
                .build();

    }



}